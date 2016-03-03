/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gestion.persistence.dao;

import com.gestion.persistence.model.Contrat;
import java.util.Date;
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
public interface IContratDao extends JpaRepository<Contrat, Long>, JpaSpecificationExecutor<Contrat>
{

    @Query("SELECT c FROM Contrat c WHERE c.actif= :actif AND c.dateSignature >= :dateSignature "
            + " OR c.dateFin<= :dateFin AND c.logement.id= :logementID  AND c.locataire.nom LIKE :nomLocataire")
    Page<Contrat> findPaginated(@Param("dateSignature") Date dateSignature, @Param("actif") boolean actif,
            @Param("dateFin") Date dateFin, @Param("logementID") long logementID,
            @Param("nomLocataire") String nomLocataire, Pageable pageable);

    @Query("SELECT c FROM Contrat c WHERE c.actif= :actif AND c.dateSignature >= :dateSignature "
            + " OR c.dateFin<= :dateFin  AND c.locataire.nom LIKE :nomLocataire")
    Page<Contrat> findPaginated(@Param("dateSignature") Date dateSignature, @Param("actif") boolean actif,
            @Param("dateFin") Date dateFin, @Param("nomLocataire") String nomLocataire, Pageable pageable);

    @Query("SELECT c FROM Contrat c WHERE c.locataire.id= :id")
    Page<Contrat> findContratByLocataire(@Param("id") long id, Pageable pageable);

    @Query("SELECT c FROM Contrat c WHERE c.logement.id= :id")
    Page<Contrat> findContratByLogement(@Param("id") long id, Pageable pageable);

}
