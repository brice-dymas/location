/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gestion.persistence.dao;

import com.gestion.persistence.model.Depense;
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
public interface IDepenseDao extends JpaRepository<Depense, Long>, JpaSpecificationExecutor<Depense>
{

    @Query("SELECT d FROM Depense d WHERE d.libelle LIKE :libelle "
            + "AND d.dateOperation >= :dateOperation AND d.montant >= :montant")
    Page<Depense> findPaginated(@Param("dateOperation") Date dateOperation, @Param("montant") int montant,
            @Param("libelle") String libelle, Pageable pageable);

    @Query("SELECT d FROM Depense d WHERE d.contrat.id= :id")
    Page<Depense> findDepenseByContratID(@Param("id") long id, Pageable pageable);
}
