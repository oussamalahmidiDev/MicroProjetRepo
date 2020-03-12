package com.models;

import java.sql.Date;
import java.util.HashMap;

public class Panier extends Model {

    private Article article;
    private int quantite;
    private User orderer;

    public Article getArticle() {
        return article;
    }

    public Panier() {}
    public Panier(Article article, int quantite, User orderer) {
        this.article = article;
        this.quantite = quantite;
        this.orderer = orderer;
    }

    public Panier(int id, Article article, int quantite, User orderer) {
        this.id = id;
        this.article = article;
        this.quantite = quantite;
        this.orderer = orderer;
    }
    public Panier(int id, Article article, int quantite) {
        this.id = id;
        this.article = article;
        this.quantite = quantite;
        this.orderer = orderer;
    }

    public void setArticle(Article article) {
        this.article = article;
    }

    @Override
    public String toString() {
        return "Panier{" +
            "article=" + article +
            ", quantite=" + quantite +
            ", orderer=" + orderer +
            '}';
    }

    public int getQuantite() {
        return quantite;
    }

    public void setQuantite(int quantite) {
        this.quantite = quantite;
    }

    public User getOrderer() {
        return orderer;
    }

    public void setOrderer(User orderer) {
        this.orderer = orderer;
    }
}
