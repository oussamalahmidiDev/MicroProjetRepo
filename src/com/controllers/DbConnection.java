package com.controllers;

import javax.servlet.http.HttpServlet;
import java.sql.Connection;
import java.sql.DriverManager;

public class DbConnection extends HttpServlet {

    private String host;
    private String port;
    private String username;
    private String password;
    private String dbName;

    public Connection connection;

    public DbConnection(String host, String port, String username, String password, String dbName) {
        super();
        this.host = host;
        this.port = port;
        this.username = username;
        this.password = password;
        this.dbName = dbName;
    }


    // DEFAULT DB CONFIG
//    public DbConnection() {
//        super();
//        this.host = getServletContext().getInitParameter("db-host");
//        this.port = getServletContext().getInitParameter("db-port");
//        this.username = getServletContext().getInitParameter("db-username");
//        this.password = getServletContext().getInitParameter("db-password");
//        this.dbName = getServletContext().getInitParameter("db-name");
//    }

    public DbConnection() {
        super();
        this.host = "127.0.0.1";
        this.port = "3306";
        this.username = "root";
        this.password = "oussama14";
        this.dbName = "microprojet";
    }



    public Connection connect() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            this.connection = DriverManager.getConnection(
                "jdbc:mysql://" + this.host + ":" + this.port + "/" + this.dbName , this.username, this.password);
            System.out.println("Connection successful.");
            return connection;
        } catch (Exception e) {
            System.out.println(e);
        }
        return null;
    }
}
