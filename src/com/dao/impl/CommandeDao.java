package com.dao.impl;

import com.controllers.AuthController;
import com.controllers.DbConnection;
import com.dao.ModelDao;
import com.models.*;
import javafx.scene.web.HTMLEditorSkin;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class CommandeDao implements ModelDao {
    public boolean create(Model commande) throws Exception {
        String query = "INSERT INTO commandes(date) VALUES(?,?)";
        PreparedStatement preparedStmt = new DbConnection().connect().prepareStatement(query, Statement.RETURN_GENERATED_KEYS);

        preparedStmt.setDate(1, ((Commande) commande).getDateCommande());


        preparedStmt.execute();

        System.out.println("C ADDED SUCCESSFULLY : " + ((Panier) commande).toString());
        return true;
    }

    @Override
    public Model find(int id) throws Exception {
        return null;
    }

    @Override
    public int delete(int id) throws Exception {
        return 0;
    }

    @Override
    public List<Model> getAll() throws Exception {
        return null;
    }

    public List<Model> getAll(int userId) throws Exception {
        List<Model> commandesList = new ArrayList<>();

        String query = "SELECT *  FROM commandes WHERE user_id=" + userId;

        ResultSet res = new DbConnection().connect().createStatement().executeQuery(query);
        System.out.println(res);
        while (res.next())
        {
            List<Panier> commandPanier =  new PanierDao().getAll(userId, res.getInt("id"));
//            Commande(Date dateCommande, User commandUser, List<Panier> paniers)
            commandesList.add(new Commande(res.getInt("id"), res.getDate("date"), (User) new UserDao().find(userId), commandPanier));
        }

        return commandesList;
    }

    public int create(Commande commande) throws Exception {
        String query = "INSERT INTO commandes(date,user_id) VALUES(?,?)";
        PreparedStatement preparedStmt = new DbConnection().connect().prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
        System.out.println("USER CMD : " + ((Commande) commande).getCommandUser().getId());
        preparedStmt.setDate(1, ((Commande) commande).getDateCommande());
        preparedStmt.setInt(2, ((Commande) commande).getCommandUser().getId());


        preparedStmt.execute();

        System.out.println("C ADDED SUCCESSFULLY : " + ((Commande) commande).toString());
        int commandId = 0;
        ResultSet generatedKeys = preparedStmt.getGeneratedKeys();
        if (generatedKeys.next()) {
            commandId = generatedKeys.getInt(1);
        }
        return commandId;
    }


}
