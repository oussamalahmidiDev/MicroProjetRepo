package com.servlets;

import com.controllers.AuthController;
import com.dao.impl.UserDao;
import com.models.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "RegisterController")
public class ServletRegister extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        User u = new User(request.getParameter("nom"), )
          PrintWriter out = response.getWriter();
//          out.println(request.getParameter("nom"));
          User newUser = new User(request.getParameter("nom"),
              request.getParameter("prenom"),
              request.getParameter("adresse"),
              request.getParameter("email"),
              request.getParameter("password"));
        try {
            if (new UserDao().create(newUser))
            {
//                out.println("User added : " + newUser.toString());
                AuthController.authenticate(newUser, request);
                response.sendRedirect("home");

//
            } else {
                out.println("Error");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
       request.getRequestDispatcher("/register.jsp").forward(request, response);
    }
}
