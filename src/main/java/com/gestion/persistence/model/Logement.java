/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gestion.persistence.model;

import java.util.Objects;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.validation.constraints.Digits;
import javax.validation.constraints.Size;
import org.hibernate.validator.constraints.NotBlank;
import org.springframework.format.annotation.NumberFormat;

/**
 *
 * @author Brice GUEMKAM <briceguemkam@gmail.com>
 */
@Entity
public class Logement extends EntityObject
{

    @NotBlank(message = "{blank.message}")
    @Size(min = 3, max = 100, message = "{size.message}")
    private String libelle;

    @NotBlank(message = "{blank.message}")
    @Size(min = 10, max = 255, message = "{size.message}")
    private String description;

    private boolean occupe;

    @NumberFormat
    @Digits(fraction = 0, integer = Integer.MAX_VALUE, message = "{digits.message}")
    private int prix;

    @NumberFormat
    @Digits(fraction = 0, integer = Integer.MAX_VALUE, message = "{digits.message}")
    private int caution;

    @ManyToOne
    Categorie categorie;

    public Logement()
    {
        occupe = false;
    }

    public String getLibelle()
    {
        return libelle;
    }

    public void setLibelle(String libelle)
    {
        this.libelle = libelle;
    }

    public String getDescription()
    {
        return description;
    }

    public void setDescription(String description)
    {
        this.description = description;
    }

    public int getPrix()
    {
        return prix;
    }

    public void setPrix(int prix)
    {
        this.prix = prix;
    }

    public int getCaution()
    {
        return caution;
    }

    public void setCaution(int caution)
    {
        this.caution = caution;
    }

    public Categorie getCategorie()
    {
        return categorie;
    }

    public void setCategorie(Categorie categorie)
    {
        this.categorie = categorie;
    }

    public void setOccupe(boolean occupe)
    {
        this.occupe = occupe;
    }

    public boolean isOccupe()
    {
        return occupe;
    }

    @Override
    public int hashCode()
    {
        int hash = 3;
        hash = 61 * hash + Objects.hashCode(this.libelle);
        hash = 61 * hash + Objects.hashCode(this.description);
        hash = 61 * hash + this.prix;
        hash = 61 * hash + this.caution;
        hash = 61 * hash + Objects.hashCode(this.categorie);
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
        final Logement other = (Logement) obj;
        if (!Objects.equals(this.libelle, other.libelle))
        {
            return false;
        }
        if (!Objects.equals(this.description, other.description))
        {
            return false;
        }
        if (this.prix != other.prix)
        {
            return false;
        }
        if (this.caution != other.caution)
        {
            return false;
        }
        if (!Objects.equals(this.categorie, other.categorie))
        {
            return false;
        }
        return true;
    }

    @Override
    public String toString()
    {
        return "Logement{" + "libelle=" + libelle + ", description=" + description + ", prix=" + prix + ", caution=" + caution + ", categorie=" + categorie + '}';
    }

}
