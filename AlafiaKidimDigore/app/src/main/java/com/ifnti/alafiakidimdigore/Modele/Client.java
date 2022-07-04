package com.ifnti.alafiakidimdigore.Modele;


public class Client {
  //  private String idClient;
    private String nom;
    private String prenom;
    private String contact;
    private String adresse;

    public Client(String nom, String prenom, String contact, String adresse) {
       // this.idClient = idClient;
        this.nom = nom;
        this.prenom = prenom;
        this.contact = contact;
        this.adresse = adresse;
    }

    public Client() {
    }

  /*  public String getIdClient() {
        return idClient;
    }

    public void setIdClient(String idClient) {
        this.idClient = idClient;
    }
*/
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

    public String getAdresse() {
        return adresse;
    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }

    }
