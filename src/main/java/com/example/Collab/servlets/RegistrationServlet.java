package com.example.Collab.servlets;

import com.example.Collab.dao.DbManager;
import com.example.Collab.entity.User;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.sql.SQLException;

@WebServlet("/registration")
public class RegistrationServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        request.getRequestDispatcher("registration.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String fullName = request.getParameter("full-name");
        String email = request.getParameter("email");
        String password = request.getParameter("password");
        String confirmPassword = request.getParameter("confirm-password");

        String errorCode = "0";

        try {
            if(DbManager.getUserByEmail(email)!=null) {
                errorCode = "1";
            }
            else if(password.length() < 8) {
                errorCode = "2";
            }
            else if(!password.equals(confirmPassword)) {
                errorCode = "3";
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        String redirect = "/registration?error=" + errorCode;
        if(errorCode.equals("0")) {
            try {
                User user = new User(fullName, email, password);
                DbManager.addUser(user);
                request.getSession().setAttribute("USER", user);

            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
            response.sendRedirect("/home");
        }
        else {

            response.sendRedirect(redirect);
        }



    }
}
