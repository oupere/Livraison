package com.ifnti.alafiakidimdigore.Modele;

import com.google.firebase.firestore.ServerTimestamp;
import com.google.type.Date;

public class Paiement {
    private String id_paiement;
    private Date date_paiement;
    private Double taux_commission;
    private Double fraisExpedition;
    private Double montantTotal;

    public Paiement(String id_paiement, Date date_paiement, Double taux_commission, Double fraisExpedition, Double montantTotal) {
        this.id_paiement = id_paiement;
        this.date_paiement = date_paiement;
        this.taux_commission = taux_commission;
        this.fraisExpedition = fraisExpedition;
        this.montantTotal = montantTotal;
    }

    public String getId_paiement() {
        return id_paiement;
    }

    public void setId_paiement(String id_paiement) {
        this.id_paiement = id_paiement;
    }

    @ServerTimestamp
    public Date getDate_paiement() {
        return date_paiement;
    }

    public void setDate_paiement(Date date_paiement) {
        this.date_paiement = date_paiement;
    }

    public Double getTaux_commission() {
        return taux_commission;
    }

    public void setTaux_commission(Double taux_commission) {
        this.taux_commission = taux_commission;
    }

    public Double getFraisExpedition() {
        return fraisExpedition;
    }

    public void setFraisExpedition(Double fraisExpedition) {
        this.fraisExpedition = fraisExpedition;
    }

    public Double getMontantTotal() {
        return montantTotal;
    }

    public void setMontantTotal(Double montantTotal) {
        this.montantTotal = montantTotal;
    }

}
