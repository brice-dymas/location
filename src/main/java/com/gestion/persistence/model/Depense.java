/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gestion.persistence.model;

import java.util.Date;
import java.util.Objects;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Digits;
import javax.validation.constraints.Size;
import org.hibernate.validator.constraints.NotBlank;
import org.springframework.format.annotation.NumberFormat;

/**
 *
 * @author Brice GUEMKAM <briceguemkam@gmail.com>
 */
@Entity
public class Depense extends EntityObject
{

    @NotBlank(message = "{blank.message}")
    @Size(min = 5, max = 255, message = "{size.message}")
    private String libelle;

    @Temporal(TemporalType.DATE)
    private Date dateOperation;

    @NumberFormat
    @Digits(fraction = 0, integer = Integer.MAX_VALUE, message = "{digits.message}")
    private int montant;

    @ManyToOne
    private Role user;

    @ManyToOne
    private Contrat contrat;

    @Override
    public String toString()
    {
        return "Depense{" + "libelle=" + libelle + ", dateOperation=" + dateOperation + ", montant=" + montant + ", user=" + user + ", contrat=" + contrat + '}';
    }

    @Override
    public int hashCode()
    {
        int hash = 5;
        hash = 59 * hash + Objects.hashCode(this.libelle);
        hash = 59 * hash + Objects.hashCode(this.dateOperation);
        hash = 59 * hash + this.montant;
        hash = 59 * hash + Objects.hashCode(this.user);
        hash = 59 * hash + Objects.hashCode(this.contrat);
        return hash;
    }

    @Override
    public boolean equals(Object obj)
    {
        if (obj == null)
        {
            return false;
        }
        if (getClass() != obj.getClass())
        {
            return false;
        }
        final Depense other = (Depense) obj;
        if (!Objects.equals(this.libelle, other.libelle))
        {
            return false;
        }
        if (!Objects.equals(this.dateOperation, other.dateOperation))
        {
            return false;
        }
        if (this.montant != other.montant)
        {
            return false;
        }
        if (!Objects.equals(this.user, other.user))
        {
            return false;
        }
        if (!Objects.equals(this.contrat, other.contrat))
        {
            return false;
        }
        return true;
    }

    public String getLibelle()
    {
        return libelle;
    }

    public void setLibelle(String libelle)
    {
        this.libelle = libelle;
    }

    public Date getDateOperation()
    {
        return dateOperation;
    }

    public void setDateOperation(Date dateOperation)
    {
        this.dateOperation = dateOperation;
    }

    public int getMontant()
    {
        return montant;
    }

    public void setMontant(int montant)
    {
        this.montant = montant;
    }

    public Role getUser()
    {
        return user;
    }

    public void setUser(Role user)
    {
        this.user = user;
    }

    public Contrat getContrat()
    {
        return contrat;
    }

    public void setContrat(Contrat contrat)
    {
        this.contrat = contrat;
    }

    public Depense()
    {
    }

}
