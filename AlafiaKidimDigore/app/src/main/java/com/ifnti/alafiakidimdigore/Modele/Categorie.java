package com.ifnti.alafiakidimdigore.Modele;

import java.util.ArrayList;

public class Categorie {
    private String libelle;
    private String image_plats;

    public String getLibelle() {
        return libelle;
    }

    public void setLibelle(String libelle) {
        this.libelle = libelle;
    }

    public String getImage_plats() {
        return image_plats;
    }

    public void setImage_plats(String image_plats) {
        this.image_plats = image_plats;
    }

    public Categorie(String libelle, String image_plats) {
        this.libelle = libelle;
        this.image_plats = image_plats;
    }
}
