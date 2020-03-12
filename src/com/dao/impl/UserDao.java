package com.dao.impl;

import com.controllers.DbConnection;
import com.dao.ModelDao;
import com.models.Model;
import com.models.Panier;
import com.models.User;

import java.sql.*;
import java.util.List;

public class UserDao implements ModelDao {

    @Override
    public boolean create(Model u) throws Exception {
        String query = "INSERT INTO users(nom,prenom,email,adresse,password) VALUES(?,?,?, ?, ?)";
        PreparedStatement preparedStmt = new DbConnection().connect().prepareStatement(query);


//        PreparedStatement preparedStmt = Dbc.connection.prepareStatement(query);

        preparedStmt.setString (1, ((User) u).getNom());
        preparedStmt.setString (2, ((User) u).getPrenom());
        preparedStmt.setString (3, ((User) u).getEmail());
        preparedStmt.setString (4, ((User) u).getAdresse());
        preparedStmt.setString (5, ((User) u).getPassword());
        preparedStmt.execute();

        System.out.println("USER ADDED SUCCESSFULLY : " + ((User) u).toString());
        return true;
    }

//    public List<Panier> getPanier() {
//
//    }

    @Override
    public Model find(int id) throws Exception {
        User user = new User();
        String query = "SELECT *  FROM users WHERE id = " + id;
        ResultSet res = new DbConnection().connect().createStatement().executeQuery(query);
        System.out.println(res);
        while (res.next())
        {
            user.setId(res.getInt("id"));
            user.setNom(res.getString("nom"));
            user.setPrenom(res.getString("prenom"));
            user.setEmail(res.getString("email"));
            user.setPassword(res.getString("password"));
            user.setAdresse(res.getString("adresse"));
        }
        return user;
    }

    public User findByEmail(String email) throws Exception {
        User user = new User();
        String query = "SELECT *  FROM users WHERE email = '" + email + "'";
        ResultSet res = new DbConnection().connect().createStatement().executeQuery(query);
        System.out.println(res);
        while (res.next())
        {
            user.setId(res.getInt("id"));
            user.setNom(res.getString("nom"));
            user.setPrenom(res.getString("prenom"));
            user.setEmail(res.getString("email"));
            user.setPassword(res.getString("password"));
            user.setAdresse(res.getString("adresse"));
        }
        return user;
    }

    @Override
    public int delete(int id) throws Exception {
        return 0;
    }

    @Override
    public List<Model> getAll() throws Exception {
        return null;
    }
}
