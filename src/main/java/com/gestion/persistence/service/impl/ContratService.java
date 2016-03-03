/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gestion.persistence.service.impl;

import com.gestion.persistence.dao.IContratDao;
import com.gestion.persistence.dao.IDepenseDao;
import com.gestion.persistence.dao.ILocataireDao;
import com.gestion.persistence.dao.ILogementDao;
import com.gestion.persistence.dao.IRoleDao;
import com.gestion.persistence.model.Contrat;
import com.gestion.persistence.model.Role;
import com.gestion.persistence.service.IContratService;
import com.gestion.persistence.service.common.AbstractService;
import java.util.Date;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

/**
 *
 * @author Brice GUEMKAM <briceguemkam@gmail.com>
 */
@Service("contratService")
public class ContratService extends AbstractService<Contrat> implements IContratService
{

    @Autowired
    IContratDao contratDao;

    @Autowired
    IDepenseDao depenseDao;
    @Autowired
    ILocataireDao locataireDao;
    @Autowired
    IRoleDao roleDao;
    @Autowired
    ILogementDao logementDao;

    @Override
    protected PagingAndSortingRepository<Contrat, Long> getDao()
    {
        return contratDao;
    }

    @Override
    public Contrat create(Contrat entity)
    {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        final Role userConnected = roleDao.retrieveAUser(auth.getName()); // get the current logged user
        entity.setUser(userConnected);
        entity.setLocataire(locataireDao.findOne(entity.getLocataire().getId()));
        entity.setLogement(logementDao.findOne(entity.getLogement().getId()));
        return contratDao.save(entity);
    }

    @Override
    public Page<Contrat> findPaginated(Date dateSignature, boolean actif, Date dateFin, long logementID, String nomLocataire, int page, Integer size)
    {
        if (logementID == -1)
        {
            return contratDao.findPaginated(dateSignature, actif, dateFin, nomLocataire, new PageRequest(page, size));
        }
        else
        {
            return contratDao.findPaginated(dateSignature, actif, dateFin, logementID, nomLocataire, new PageRequest(page, size));
        }
    }

    @Override
    public Page<Contrat> findContratByLocataireID(long id, int page, Integer size)
    {
        return contratDao.findContratByLocataire(id, new PageRequest(page, size));
    }

    @Override
    public Page<Contrat> findContratByLogementID(long id, int page, Integer size)
    {
        return contratDao.findContratByLogement(id, new PageRequest(page, size));
    }

}
