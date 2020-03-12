package com.controllers;

import com.models.User;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.sql.ResultSet;
import java.sql.SQLException;

public class AuthController {

    public static void authenticate(User u, HttpServletRequest request) {
        HttpSession session = request.getSession();
        /* Récupération de l'objet depuis la session */
        session.setAttribute( "current_user", u);
    }

    public static User currentUser (HttpServletRequest request) {
        return (User) request.getSession().getAttribute("current_user");
    }

    public static boolean verifyCredentials (String email, String password) throws SQLException {
        String query = "SELECT count(*) AS total FROM users WHERE email = '" + email + "' AND password = '" + password + "'";
        System.out.println("QUERY : " + query);
        ResultSet rs = new DbConnection().connect().createStatement().executeQuery(query);
        System.out.println(rs);
        while (rs.next()) {
            int total = rs.getInt("total");
            System.out.println("COUNT : " + total);
            if (total != 0) return true;
            else return false;
            // print the results
        }
        System.out.println(rs);
        return false;
    }



}
