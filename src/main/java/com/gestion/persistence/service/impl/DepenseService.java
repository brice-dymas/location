/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gestion.persistence.service.impl;

import com.gestion.persistence.dao.IContratDao;
import com.gestion.persistence.dao.IDepenseDao;
import com.gestion.persistence.dao.IRoleDao;
import com.gestion.persistence.model.Depense;
import com.gestion.persistence.model.Role;
import com.gestion.persistence.service.IDepenseService;
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
@Service("depenseService")
public class DepenseService extends AbstractService<Depense> implements IDepenseService
{

    @Autowired
    IRoleDao roleDao;

    @Autowired
    IContratDao contratDao;

    @Autowired
    IDepenseDao depenseDao;

    @Override
    protected PagingAndSortingRepository<Depense, Long> getDao()
    {
        return depenseDao;
    }

    @Override
    public Depense create(Depense entity)
    {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        final Role userConnected = roleDao.retrieveAUser(auth.getName()); // get the current logged user
        entity.setContrat(contratDao.findOne(entity.getContrat().getId()));
        entity.setUser(userConnected);
        return depenseDao.save(entity);
    }

    @Override
    public void deleteById(long entityId)
    {
        depenseDao.delete(entityId);
    }

    @Override
    public Depense update(Depense entity)
    {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        final Role userConnected = roleDao.retrieveAUser(auth.getName()); // get the current logged user
        Depense toUpdate = depenseDao.findOne(entity.getId());
        toUpdate.setContrat(contratDao.findOne(entity.getContrat().getId()));
        toUpdate.setDateOperation(entity.getDateOperation());
        toUpdate.setLibelle(entity.getLibelle());
        toUpdate.setMontant(entity.getMontant());
        toUpdate.setUser(userConnected);
        return depenseDao.save(toUpdate);
    }

    @Override
    public Page<Depense> findPaginated(Date dateOperation, int montant, String libelle, int page, Integer size)
    {
        return depenseDao.findPaginated(dateOperation, montant, '%' + libelle + '%', new PageRequest(page, size));
    }

    @Override
    public Page<Depense> findDepenseByContratID(long id, int page, Integer size)
    {
        return depenseDao.findDepenseByContratID(id, new PageRequest(page, size));
    }

}
