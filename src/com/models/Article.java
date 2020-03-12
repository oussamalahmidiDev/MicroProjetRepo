package com.models;

public class Article extends Model {
    private String reference;
    private String titre;
    private String auteur;
    private String editeur;
    private float prix;
    private String image;
    private String genre;
    private int quantite;
    private int annee;

    public int getAnnee() {
        return annee;
    }

    public void setAnnee(int annee) {
        this.annee = annee;
    }

    public Article(String reference, String titre, String auteur, String genre, String editeur, float prix, String image, int quantite, int annee) {
        this.reference = reference;
        this.titre = titre;
        this.auteur = auteur;
        this.genre = genre;
        this.editeur = editeur;
        this.prix = prix;
        this.image = image;
        this.quantite = quantite;
        this.annee = annee;
    }

    public Article(int id, String reference, String titre, String auteur, String genre, String editeur, float prix, String image, int quantite, int annee) {
        this.id = id;
        this.reference = reference;
        this.titre = titre;
        this.auteur = auteur;
        this.genre = genre;
        this.editeur = editeur;
        this.prix = prix;
        this.image = image;
        this.quantite = quantite;
        this.annee = annee;
    }

    public Article() {}

    public String getReference() {
        return reference;
    }

    public void setReference(String reference) {
        this.reference = reference;
    }

    public String getTitre() {
        return titre;
    }

    public void setTitre(String titre) {
        this.titre = titre;
    }

    public String getAuteur() {
        return auteur;
    }

    public void setAuteur(String auteur) {
        this.auteur = auteur;
    }

    public String getEditeur() {
        return editeur;
    }

    public void setEditeur(String editeur) {
        this.editeur = editeur;
    }

    public float getPrix() {
        return prix;
    }

    public void setPrix(float prix) {
        this.prix = prix;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public int getQuantite() {
        return quantite;
    }

    public void setQuantite(int quantite) {
        this.quantite = quantite;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    @Override
    public String toString() {
        return "Article{" +
            "reference='" + reference + '\'' +
            ", titre='" + titre + '\'' +
            ", auteur='" + auteur + '\'' +
            ", editeur='" + editeur + '\'' +
            ", genre='" + editeur + '\'' +
            ", prix=" + prix +
            ", image='" + image + '\'' +
            ", quantite=" + quantite +
            '}';
    }
}
