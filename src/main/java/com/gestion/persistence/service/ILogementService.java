/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gestion.persistence.service;

import com.gestion.persistence.IOperations;
import com.gestion.persistence.model.Logement;
import java.util.List;
import org.springframework.data.domain.Page;

/**
 *
 * @author Brice GUEMKAM <briceguemkam@gmail.com>
 */
public interface ILogementService extends IOperations<Logement>
{

    Page<Logement> findPaginated(String libelle, int prix,
            boolean occupe, int page, Integer size);

    List<Logement> findLogementByStatut(boolean occupe);
}
