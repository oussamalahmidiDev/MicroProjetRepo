package com.servlets;

import com.controllers.AuthController;
import com.dao.impl.ArticleDao;
import com.dao.impl.UserDao;
import com.models.Article;
import com.models.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "ServletArticles")
public class ServletArticles extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        PrintWriter out = response.getWriter();
//          out.println(request.getParameter("nom"));
//            public Article(String reference, String titre, String auteur, String editeur, float prix, String image, int quantite, int annee) {

            Article newArticle = new Article(request.getParameter("ref"),
            request.getParameter("titre"),
            request.getParameter("auteur"),
            request.getParameter("genre"),
            request.getParameter("editeur"),
            Float.parseFloat(request.getParameter("prix")),
            request.getParameter("image"),
            Integer.parseInt(request.getParameter("quantite")),
            Integer.parseInt(request.getParameter("annee")));
        try {
            if (new ArticleDao().create(newArticle))
            {
                out.println("Artilce added : " + newArticle.toString());
//
            } else {
                out.println("Error");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        PrintWriter out = response.getWriter();

        if (request.getParameter("id") != null) {
            out.println("Redirecting to article " + request.getParameter("id"));
            try {
                request.setAttribute("article", new ArticleDao().find(Integer.parseInt(request.getParameter("id"))));
                request.getRequestDispatcher("/article_details.jsp").forward(request, response);

            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        else {
            String genre = request.getParameter("genre");
            if (genre == null) {
                try {
                    request.setAttribute("articles", new ArticleDao().getAll());
                } catch (Exception e) {
                    e.printStackTrace();
                }
                request.getRequestDispatcher("/articles.jsp").forward(request, response);
            }
            else if (genre.equals("Tous")) {
                try {
                    request.setAttribute("articles", new ArticleDao().getAll());
                } catch (Exception e) {
                    e.printStackTrace();
                }
                request.getRequestDispatcher("/articles.jsp").forward(request, response);
            }
            else {
                try {
                    request.setAttribute("articles", new ArticleDao().getAllByGenre(genre));
                    request.getRequestDispatcher("/articles.jsp").forward(request, response);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }

    }
}
