/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gestion.persistence.service;

import com.gestion.persistence.IOperations;
import com.gestion.persistence.model.Locataire;
import org.springframework.data.domain.Page;

/**
 *
 * @author Brice GUEMKAM <briceguemkam@gmail.com>
 */
public interface ILocataireService extends IOperations<Locataire>
{

    Page<Locataire> findPaginated(String nom, String profession, int page, Integer size);
}
