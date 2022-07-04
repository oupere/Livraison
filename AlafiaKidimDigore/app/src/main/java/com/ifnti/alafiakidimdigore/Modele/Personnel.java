package com.ifnti.alafiakidimdigore.Modele;

public class Personnel {
    private String id_Personnel;
    private String nom;
    private String prenom;
    private String contact;
    private String status;

    public Personnel(String id_Personnel, String nom, String prenom, String contact, String status) {
        this.id_Personnel = id_Personnel;
        this.nom = nom;
        this.prenom = prenom;
        this.contact = contact;
        this.status = status;
    }
    public String getId_Personnel() {
        return id_Personnel;
    }

    public void setId_Personnel(String id_Personnel) {
        this.id_Personnel = id_Personnel;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public String getContact() {
        return contact;
    }

    public void setContact(String contact) {
        this.contact = contact;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }


}
