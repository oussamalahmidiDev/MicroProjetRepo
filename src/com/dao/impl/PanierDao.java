package com.dao.impl;

import com.controllers.DbConnection;
import com.dao.ModelDao;
import com.models.*;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class PanierDao implements ModelDao {

    @Override
    public boolean create(Model panier) throws Exception {
        String query = "INSERT INTO paniers(article_id,user_id, quantite) VALUES(?,?,?)";
        PreparedStatement preparedStmt = new DbConnection().connect().prepareStatement(query);

        preparedStmt.setInt(1, ((Panier) panier).getArticle().getId());
        preparedStmt.setInt(2, ((Panier) panier).getOrderer().getId());
        preparedStmt.setInt(3, ((Panier) panier).getQuantite());

        preparedStmt.execute();

        System.out.println("PANIER ADDED SUCCESSFULLY : " + ((Panier) panier).toString());
        return true;
    }

    @Override
    public Model find(int id) throws Exception {
        return null;
    }

    @Override
    public int delete(int id) throws Exception {
        String query = "DELETE FROM paniers WHERE id = " + id;
        return new DbConnection().connect().createStatement().executeUpdate(query);
    }

    @Override
    public List<Model> getAll() throws Exception {
        return null;
    }

    public List<Model> getAll(int userId) throws Exception {
        List<Model> panierList = new ArrayList<>();

        String query = "SELECT *  FROM paniers WHERE user_id=" + userId + " AND command_id IS NULL";

        ResultSet res = new DbConnection().connect().createStatement().executeQuery(query);
        System.out.println(res);
        while (res.next())
        {
            panierList.add(new Panier(res.getInt("id"), (Article) new ArticleDao().find(res.getInt("article_id")), res.getInt("quantite")));
        }

        return panierList;
    }

    public List<Panier> getAll(int userId, int commandeId) throws Exception {
        List<Panier> panierList = new ArrayList<>();

        String query = "SELECT *  FROM paniers WHERE user_id=" + userId + " AND command_id=" + commandeId;

        ResultSet res = new DbConnection().connect().createStatement().executeQuery(query);
        System.out.println(res);
        while (res.next())
        {
            panierList.add(new Panier(res.getInt("id"), (Article) new ArticleDao().find(res.getInt("article_id")), res.getInt("quantite")));
        }

        return panierList;
    }
//
    public boolean addToCommande (int userId) throws Exception {
        System.out.println("USER ID : " + userId);
        System.out.println("USER : " + new UserDao().find(userId).toString());
        int commandId = new CommandeDao().create(new Commande(new Date(System.currentTimeMillis()), (User) new UserDao().find(userId)));
        System.out.println("COMD ID : " + commandId);
        List<Model> pList = this.getAll(userId);
        for (Model p : pList) {
            String query = "UPDATE paniers SET command_id = " + commandId + " WHERE id=" + p.getId() + " AND command_id IS NULL";
            System.out.println("SQL QUERY : " + query);
            int res = new DbConnection().connect().createStatement().executeUpdate(query);
            System.out.println(res);
        }

        return true;
    }
}
