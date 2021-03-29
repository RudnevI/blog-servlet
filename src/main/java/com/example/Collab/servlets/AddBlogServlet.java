package com.example.Collab.servlets;

import com.example.Collab.dao.DbManager;
import com.example.Collab.entity.Blog;
import com.example.Collab.entity.User;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.sql.SQLException;
import java.time.LocalDate;

@WebServlet("/addblog")
public class AddBlogServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        if(request.getSession().getAttribute("USER")!=null) {
            request.getRequestDispatcher("addblog.jsp").forward(request, response);
        }
        else {
            response.sendRedirect("/login");
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String title = request.getParameter("title");
        String content = request.getParameter("content");
        String creationDate = LocalDate.now().toString();

        User user = (User) request.getSession().getAttribute("USER");
        Long authorId = user.getId();

        Blog blog = new Blog(title, content, authorId, creationDate);

        try {
            DbManager.addBlog(blog);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        response.sendRedirect("/home");

    }
}
