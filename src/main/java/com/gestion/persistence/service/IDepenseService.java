/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gestion.persistence.service;

import com.gestion.persistence.IOperations;
import com.gestion.persistence.model.Depense;
import java.util.Date;
import org.springframework.data.domain.Page;

/**
 *
 * @author Brice GUEMKAM <briceguemkam@gmail.com>
 */
public interface IDepenseService extends IOperations<Depense>
{

    Page<Depense> findPaginated(Date dateOperation, int montant,
            String libelle, int page, Integer size);

    Page<Depense> findDepenseByContratID(long id, int page, Integer size);
}
