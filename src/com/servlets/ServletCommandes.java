package com.servlets;

import com.controllers.AuthController;
import com.dao.impl.ArticleDao;
import com.dao.impl.CommandeDao;
import com.dao.impl.PanierDao;
import com.models.Article;
import com.models.Panier;
import com.models.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "ServletCommandes")
public class ServletCommandes extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        PrintWriter out = response.getWriter();
        try {

            if (new PanierDao().addToCommande(AuthController.currentUser(request).getId()))
            {
                response.sendRedirect("commandes");
//
            } else {
                out.println("Error");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            request.setAttribute("commandes", new CommandeDao().getAll(AuthController.currentUser(request).getId()));
        } catch (Exception e) {
            e.printStackTrace();
        }
        request.getRequestDispatcher("/commandes.jsp").forward(request, response);
    }
}
