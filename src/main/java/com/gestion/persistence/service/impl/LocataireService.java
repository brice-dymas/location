/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gestion.persistence.service.impl;

import com.gestion.persistence.dao.ILocataireDao;
import com.gestion.persistence.model.Locataire;
import com.gestion.persistence.service.ILocataireService;
import com.gestion.persistence.service.common.AbstractService;
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
public class LocataireService extends AbstractService<Locataire> implements ILocataireService
{

    @Autowired
    ILocataireDao locataireDao;

    @Override
    protected PagingAndSortingRepository<Locataire, Long> getDao()
    {
        return locataireDao;
    }

    @Override
    public Page<Locataire> findPaginated(String nom, String profession, int page, Integer size)
    {
        return locataireDao.findPaginated('%' + nom + '%', '%' + profession + '%', new PageRequest(page, size));
    }

    @Override
    public Locataire update(Locataire entity)
    {
        Locataire toUpdate = locataireDao.findOne(entity.getId());
        toUpdate.setAdresse(entity.getAdresse());
        toUpdate.setCni(entity.getCni());
        toUpdate.setNom(entity.getNom());
        toUpdate.setProfession(entity.getProfession());
        toUpdate.setTelephone(entity.getTelephone());
        return locataireDao.save(toUpdate);
    }

    @Override
    public void deleteById(long entityId)
    {
        locataireDao.delete(entityId);
    }

}
