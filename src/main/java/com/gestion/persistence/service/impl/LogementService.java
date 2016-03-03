/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gestion.persistence.service.impl;

import com.gestion.persistence.dao.ICategorieDao;
import com.gestion.persistence.dao.ILogementDao;
import com.gestion.persistence.model.Logement;
import com.gestion.persistence.service.ILogementService;
import com.gestion.persistence.service.common.AbstractService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Service;

/**
 *
 * @author Brice GUEMKAM <briceguemkam@gmail.com>
 */
@Service
public class LogementService extends AbstractService<Logement> implements ILogementService
{

    @Autowired
    ILogementDao logementDao;

    @Autowired
    ICategorieDao categorieDao;

    @Override
    protected PagingAndSortingRepository<Logement, Long> getDao()
    {
        return logementDao;
    }

    @Override
    public Page<Logement> findPaginated(String libelle, int prix, boolean occupe, int page, Integer size)
    {
        return logementDao.findPaginated('%' + libelle + '%', prix, occupe, new PageRequest(page, size));
    }

    @Override
    public Logement update(Logement entity)
    {
        Logement toUpdate = logementDao.findOne(entity.getId());
        toUpdate.setCategorie(categorieDao.findOne(entity.getCategorie().getId()));
        toUpdate.setCaution(entity.getCaution());
        toUpdate.setDescription(entity.getDescription());
        toUpdate.setLibelle(entity.getLibelle());
        toUpdate.setOccupe(entity.isOccupe());
        toUpdate.setPrix(entity.getPrix());
        return logementDao.save(toUpdate);
    }

    @Override
    public void deleteById(long entityId)
    {
        logementDao.delete(entityId);
    }

    @Override
    public List<Logement> findLogementByStatut(boolean occupe)
    {
        return logementDao.findLogementByStatut(occupe);
    }

}
