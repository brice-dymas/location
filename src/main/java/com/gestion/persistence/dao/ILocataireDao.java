/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gestion.persistence.dao;

import com.gestion.persistence.model.Locataire;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

/**
 *
 * @author Brice GUEMKAM <briceguemkam@gmail.com>
 */
public interface ILocataireDao extends JpaRepository<Locataire, Long>, JpaSpecificationExecutor<Locataire>
{

    @Query("SELECT L FROM Locataire L WHERE  L.nom LIKE :nom or L.profession LIKE : profession")
    Page<Locataire> findPaginated(@Param("nom") String nom, @Param("profession") String profession, Pageable pageable);
}
