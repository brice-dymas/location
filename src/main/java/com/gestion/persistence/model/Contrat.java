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

/**
 *
 * @author Brice GUEMKAM <briceguemkam@gmail.com>
 */
@Entity
public class Contrat extends EntityObject
{

    @Temporal(TemporalType.DATE)
    private Date dateSignature;

    @Temporal(TemporalType.DATE)
    private Date dateDebut;

    @Temporal(TemporalType.DATE)
    private Date dateFin;

    private boolean actif;

    @ManyToOne
    private Role user;

    @ManyToOne
    private Logement logement;

    @ManyToOne
    private Locataire locataire;

    public Contrat()
    {
        actif = true;
    }

    public Date getDateSignature()
    {
        return dateSignature;
    }

    public void setDateSignature(Date dateSignature)
    {
        this.dateSignature = dateSignature;
    }

    public Date getDateDebut()
    {
        return dateDebut;
    }

    public void setDateDebut(Date dateDebut)
    {
        this.dateDebut = dateDebut;
    }

    public Date getDateFin()
    {
        return dateFin;
    }

    public void setDateFin(Date dateFin)
    {
        this.dateFin = dateFin;
    }

    public boolean isActif()
    {
        return actif;
    }

    public void setActif(boolean actif)
    {
        this.actif = actif;
    }

    public Role getUser()
    {
        return user;
    }

    public void setUser(Role user)
    {
        this.user = user;
    }

    public Logement getLogement()
    {
        return logement;
    }

    public void setLogement(Logement logement)
    {
        this.logement = logement;
    }

    public Locataire getLocataire()
    {
        return locataire;
    }

    public void setLocataire(Locataire locataire)
    {
        this.locataire = locataire;
    }

    @Override
    public int hashCode()
    {
        int hash = 7;
        hash = 29 * hash + Objects.hashCode(this.dateSignature);
        hash = 29 * hash + Objects.hashCode(this.dateDebut);
        hash = 29 * hash + Objects.hashCode(this.dateFin);
        hash = 29 * hash + Objects.hashCode(this.user);
        hash = 29 * hash + Objects.hashCode(this.logement);
        hash = 29 * hash + Objects.hashCode(this.locataire);
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
        final Contrat other = (Contrat) obj;
        if (!Objects.equals(this.dateSignature, other.dateSignature))
        {
            return false;
        }
        if (!Objects.equals(this.dateDebut, other.dateDebut))
        {
            return false;
        }
        if (!Objects.equals(this.dateFin, other.dateFin))
        {
            return false;
        }
        if (!Objects.equals(this.user, other.user))
        {
            return false;
        }
        if (!Objects.equals(this.logement, other.logement))
        {
            return false;
        }
        if (!Objects.equals(this.locataire, other.locataire))
        {
            return false;
        }
        return true;
    }

    @Override
    public String toString()
    {
        return "Contrat{" + "dateSignature=" + dateSignature + ", dateDebut=" + dateDebut + ", dateFin=" + dateFin + ", user=" + user + ", logement=" + logement + ", locataire=" + locataire + '}';
    }

}
