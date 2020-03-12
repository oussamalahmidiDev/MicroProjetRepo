package com.models;

import java.sql.Date;
import java.util.List;

public class Commande extends Model {
    private Date dateCommande;
    private User commandUser;
    private List<Panier> paniers;

    public Commande() {}
    public Commande(Date dateCommande, User commandUser/*, List<Panier> paniers*/) {
        this.dateCommande = dateCommande;
        this.commandUser = commandUser;
//        this.paniers = paniers;
    }

    public Commande(Date dateCommande, User commandUser, List<Panier> paniers) {
        this.dateCommande = dateCommande;
        this.commandUser = commandUser;
        this.paniers = paniers;
    }

    public Commande(int id, Date dateCommande, User commandUser, List<Panier> paniers) {
        this.dateCommande = dateCommande;
        this.commandUser = commandUser;
        this.paniers = paniers;
        this.id = id;
    }

    public Commande(int id, Date dateCommande, User commandUser/*, List<Panier> paniers*/) {
        this.id = id;
        this.dateCommande = dateCommande;
        this.commandUser = commandUser;
//        this.paniers = paniers;
    }

    public Date getDateCommande() {
        return dateCommande;
    }

    public void setDateCommande(Date dateCommande) {
        this.dateCommande = dateCommande;
    }

    public User getCommandUser() {
        return commandUser;
    }

    public void setCommandUser(User commandUser) {
        this.commandUser = commandUser;
    }

    public List<Panier> getPaniers() {
        return paniers;
    }

    public void setPaniers(List<Panier> paniers) {
        this.paniers = paniers;
    }
}
