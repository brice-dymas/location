/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gestion.persistence.service;

import com.gestion.persistence.IOperations;
import com.gestion.persistence.model.Contrat;
import java.util.Date;
import org.springframework.data.domain.Page;

/**
 *
 * @author Brice GUEMKAM <briceguemkam@gmail.com>
 */
public interface IContratService extends IOperations<Contrat>
{

    Page<Contrat> findPaginated(Date dateSignature, boolean actif,
            Date dateFin, long logementID, String nomLocataire, int page, Integer size);

    Page<Contrat> findContratByLocataireID(long id, int page, Integer size);

    Page<Contrat> findContratByLogementID(long id, int page, Integer size);
}
