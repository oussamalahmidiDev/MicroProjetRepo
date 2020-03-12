package com.servlets;

import com.controllers.AuthController;
import com.dao.impl.ArticleDao;
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

@WebServlet(name = "ServletPaniers")
public class ServletPaniers extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        PrintWriter out = response.getWriter();
        if (request.getParameter("action").equals("add")) {
            try {
                Panier newPanier = new Panier((Article) new ArticleDao().find(Integer.parseInt(request.getParameter("article_id"))),
                    Integer.parseInt(request.getParameter("quantite")),
                    (User) request.getSession().getAttribute("current_user"));
                if (new PanierDao().create(newPanier))
                {
                    response.sendRedirect("articles");
//
                } else {
                    out.println("Error");
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        else {
            try {
                if (new PanierDao().delete(Integer.parseInt(request.getParameter("panier_id"))) != 0) {
                    response.sendRedirect("paniers");
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            request.setAttribute("paniers", new PanierDao().getAll(AuthController.currentUser(request).getId()));
        } catch (Exception e) {
            e.printStackTrace();
        }
        request.getRequestDispatcher("/panier.jsp").forward(request, response);

    }
}
