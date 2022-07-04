package com.ifnti.alafiakidimdigore.Modele;

import com.google.firebase.firestore.ServerTimestamp;
import com.google.type.Date;

public class Commande {
    private String id_commande;
    private Date date_commande;
    private String localisation;
    private Date date_reception;
    private Client id_client;
    private Personnel id_personnel;

    public Commande(String id_commande, Date date_commande, String localisation, Date date_reception, Client id_client, Personnel id_personnel) {
        this.id_commande = id_commande;
        this.date_commande = date_commande;
        this.localisation = localisation;
        this.date_reception = date_reception;
        this.id_client = id_client;
        this.id_personnel = id_personnel;
    }

    public String getId_commande() {
        return id_commande;
    }

    public void setId_commande(String id_commande) {
        this.id_commande = id_commande;
    }

    @ServerTimestamp public Date getDate_commande() {
        return date_commande;
    }

    public void setDate_commande(Date date_commande) {
        this.date_commande = date_commande;
    }

    public String getLocalisation() {
        return localisation;
    }

    public void setLocalisation(String localisation) {
        this.localisation = localisation;
    }

    @ServerTimestamp public Date getDate_reception() {
        return date_reception;
    }

    public void setDate_reception(Date date_reception) {
        this.date_reception = date_reception;
    }

    public Client getId_client() {
        return id_client;
    }

    public void setId_client(Client id_client) {
        this.id_client = id_client;
    }

    public Personnel getId_personnel() {
        return id_personnel;
    }

    public void setId_personnel(Personnel id_personnel) {
        this.id_personnel = id_personnel;
    }


}
