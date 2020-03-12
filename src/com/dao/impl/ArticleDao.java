package com.dao.impl;

import com.controllers.DbConnection;
import com.dao.ModelDao;
import com.models.Article;
import com.models.Model;
import com.models.Panier;
import com.models.User;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class ArticleDao implements ModelDao {

    @Override
    public boolean create(Model article) throws Exception {
        String query = "INSERT INTO articles(ref,titre,auteur, genre, editeur,prix,image,quantite,annee) VALUES(?,?,?,?, ?, ?,?,?,?)";
        PreparedStatement preparedStmt = new DbConnection().connect().prepareStatement(query);

        preparedStmt.setString(1, ((Article) article).getReference());
        preparedStmt.setString(2, ((Article) article).getTitre());
        preparedStmt.setString(3, ((Article) article).getAuteur());
        preparedStmt.setString(4, ((Article) article).getGenre());
        preparedStmt.setString(5, ((Article) article).getEditeur());
        preparedStmt.setFloat(6, ((Article) article).getPrix());
        preparedStmt.setString(7, ((Article) article).getImage());
        preparedStmt.setInt(8, ((Article) article).getQuantite());
        preparedStmt.setInt(9, ((Article) article).getAnnee());
        preparedStmt.execute();

        System.out.println("ARTICLE ADDED SUCCESSFULLY : " + ((Article) article).toString());
        return true;
    }

    @Override
    public Model find(int id) throws Exception {
        Article article = new Article();
        String query = "SELECT *  FROM articles WHERE id = " + id;
        ResultSet res = new DbConnection().connect().createStatement().executeQuery(query);
        System.out.println(res);
        while (res.next())
        {
            article.setAnnee(res.getInt("annee"));
            article.setAuteur(res.getString("auteur"));
            article.setEditeur(res.getString("editeur"));
            article.setGenre(res.getString("genre"));
            article.setId(id);
            article.setPrix(res.getFloat("prix"));
            article.setQuantite(res.getInt("quantite"));
            article.setTitre(res.getString("titre"));
            article.setReference(res.getString("ref"));
            article.setImage(res.getString("image"));
        }
        return article;
    }

    @Override
    public int delete(int id) throws Exception {
        return 0;
    }

    @Override
    public List<Model> getAll() throws Exception {
        List<Model> articlesList = new ArrayList<>();

        String query = "SELECT *  FROM articles";
//        articles(ref,titre,auteur, genre, editeur,prix,image,quantite,annee)
        ResultSet res = new DbConnection().connect().createStatement().executeQuery(query);
        System.out.println(res);
        while (res.next())
        {
            articlesList.add(new Article(res.getInt("id"), res.getString("ref"), res.getString("titre"), res.getString("auteur"),
                res.getString("genre"), res.getString("editeur"), res.getFloat("prix"), res.getString("image"),
                res.getInt("quantite"), res.getInt("annee")
                ));
        }

        return articlesList;
    }

    public List<Article> getAllByGenre(String genre) throws Exception {
        List<Article> articlesList = new ArrayList<>();

        String query = "SELECT *  FROM articles WHERE genre = ' " + genre + "'";
//        articles(ref,titre,auteur, genre, editeur,prix,image,quantite,annee)
        ResultSet res = new DbConnection().connect().createStatement().executeQuery(query);
        System.out.println(res);
        while (res.next())
        {
            articlesList.add(new Article(res.getInt("id"), res.getString("ref"), res.getString("titre"), res.getString("auteur"),
                res.getString("genre"), res.getString("editeur"), res.getFloat("prix"), res.getString("image"),
                res.getInt("quantite"), res.getInt("annee")
            ));
        }

        return articlesList;
    }

}
