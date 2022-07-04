package com.ifnti.alafiakidimdigore.Modele;

import java.io.Serializable;

public class Plat implements Serializable{
    private String libelle;
    private Double prix_unitaire;
    private String image_plats;
    private String detail_plats;
    private int temps;
    private int star;
    private int numbrerSelectionner;
    private int calories;

    public Plat(String libelle, Double prix_unitaire, String image_plats, String detail_plats, int temps, int numbrerSelectionner, int calories) {
        this.libelle = libelle;
        this.prix_unitaire = prix_unitaire;
        this.image_plats = image_plats;
        this.detail_plats = detail_plats;
        this.temps = temps;
        this.star = star;
        this.numbrerSelectionner = numbrerSelectionner;
        this.calories = calories;
    }

    public int getStar() {
        return star;
    }

    public void setStar(int star) {
        this.star = star;
    }

    public String getLibelle() {
        return libelle;
    }

    public void setLibelle(String libelle) {
        this.libelle = libelle;
    }

    public Double getPrix_unitaire() {
        return prix_unitaire;
    }

    public void setPrix_unitaire(Double prix_unitaire) {
        this.prix_unitaire = prix_unitaire;
    }

    public String getImage_plats() {
        return image_plats;
    }

    public void setImage_plats(String image_plats) {
        this.image_plats = image_plats;
    }

    public String getDetail_plats() {
        return detail_plats;
    }

    public void setDetail_plats(String detail_plats) {
        this.detail_plats = detail_plats;
    }

    public int getTemps() {
        return temps;
    }

    public void setTemps(int temps) {
        this.temps = temps;
    }

    public int getNumbrerSelectionner() {
        return numbrerSelectionner;
    }

    public void setNumbrerSelectionner(int numbrerSelectionner) {
        this.numbrerSelectionner = numbrerSelectionner;
    }

    public int getCalories() {
        return calories;
    }

    public void setCalories(int calories) {
        this.calories = calories;
    }

}
