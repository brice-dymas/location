/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gestion.persistence.model;

import java.util.Objects;
import javax.persistence.Entity;
import javax.validation.constraints.Size;
import org.hibernate.validator.constraints.NotBlank;

/**
 *
 * @author Brice GUEMKAM <briceguemkam@gmail.com>
 */
@Entity
public class Locataire extends EntityObject
{

    @NotBlank(message = "{blank.message}")
    @Size(min = 3, max = 255, message = "{size.message}")
    private String nom;

    @NotBlank(message = "{blank.message}")
    @Size(min = 5, max = 255, message = "{size.message}")
    private String profession;

    @NotBlank(message = "{blank.message}")
    @Size(min = 9, max = 9, message = "{size.message}")
    private String cni;

    @NotBlank(message = "{blank.message}")
    @Size(min = 9, max = 9, message = "{size.message}")
    private String telephone;

    @NotBlank(message = "{blank.message}")
    @Size(min = 5, max = 255, message = "{size.message}")
    private String adresse;

    public Locataire()
    {
    }

    public String getNom()
    {
        return nom;
    }

    public void setNom(String nom)
    {
        this.nom = nom;
    }

    public String getProfession()
    {
        return profession;
    }

    public void setProfession(String profession)
    {
        this.profession = profession;
    }

    public String getCni()
    {
        return cni;
    }

    public void setCni(String cni)
    {
        this.cni = cni;
    }

    public String getTelephone()
    {
        return telephone;
    }

    public void setTelephone(String telephone)
    {
        this.telephone = telephone;
    }

    public String getAdresse()
    {
        return adresse;
    }

    public void setAdresse(String adresse)
    {
        this.adresse = adresse;
    }

    @Override
    public int hashCode()
    {
        int hash = 7;
        hash = 59 * hash + Objects.hashCode(this.nom);
        hash = 59 * hash + Objects.hashCode(this.profession);
        hash = 59 * hash + Objects.hashCode(this.cni);
        hash = 59 * hash + Objects.hashCode(this.telephone);
        hash = 59 * hash + Objects.hashCode(this.adresse);
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
        final Locataire other = (Locataire) obj;
        if (!Objects.equals(this.nom, other.nom))
        {
            return false;
        }
        if (!Objects.equals(this.profession, other.profession))
        {
            return false;
        }
        if (!Objects.equals(this.cni, other.cni))
        {
            return false;
        }
        if (!Objects.equals(this.telephone, other.telephone))
        {
            return false;
        }
        if (!Objects.equals(this.adresse, other.adresse))
        {
            return false;
        }
        return true;
    }

    @Override
    public String toString()
    {
        return "Locataire{" + "nom=" + nom + ", profession=" + profession + ", cni=" + cni + ", telephone=" + telephone + ", adresse=" + adresse + '}';
    }

}
