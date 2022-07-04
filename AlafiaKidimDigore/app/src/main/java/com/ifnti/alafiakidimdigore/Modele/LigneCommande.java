package com.ifnti.alafiakidimdigore.Modele;

public class LigneCommande {
    private String id_ligne;
    private int quantiteCommande;
    private Double montantCommande;
    private Plat id_plats;
    private Commande id_commande;

    public LigneCommande(String id_ligne, int quantiteCommande, Double montantCommande, Plat id_plats, Commande id_commande) {
        this.id_ligne = id_ligne;
        this.quantiteCommande = quantiteCommande;
        this.montantCommande = montantCommande;
        this.id_plats = id_plats;
        this.id_commande = id_commande;
    }

    public String getId_ligne() {
        return id_ligne;
    }

    public void setId_ligne(String id_ligne) {
        this.id_ligne = id_ligne;
    }

    public int getQuantiteCommande() {
        return quantiteCommande;
    }

    public void setQuantiteCommande(int quantiteCommande) {
        this.quantiteCommande = quantiteCommande;
    }

    public Double getMontantCommande() {
        return montantCommande;
    }

    public void setMontantCommande(Double montantCommande) {
        this.montantCommande = montantCommande;
    }

    public Plat getId_plats() {
        return id_plats;
    }

    public void setId_plats(Plat id_plats) {
        this.id_plats = id_plats;
    }

    public Commande getId_commande() {
        return id_commande;
    }

    public void setId_commande(Commande id_commande) {
        this.id_commande = id_commande;
    }

}
