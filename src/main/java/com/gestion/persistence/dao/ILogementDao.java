/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gestion.persistence.dao;

import com.gestion.persistence.model.Logement;
import java.util.List;
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
public interface ILogementDao extends JpaRepository<Logement, Long>, JpaSpecificationExecutor<Logement>
{

    @Query("SELECT L FROM Logement L WHERE  L.libelle LIKE :libelle "
            + " AND L.prix >= :prix AND L.occupe= :occupe ")
    Page<Logement> findPaginated(@Param("libelle") String libelle, @Param("prix") int prix,
            @Param("occupe") boolean occupe, Pageable pageable);

    @Query("SELECT L FROM Logement L WHERE L.occupe= :occupe ")
    List<Logement> findLogementByStatut(@Param("occupe") boolean occupe);

}
