package com.example.Collab.dao;

import com.example.Collab.entity.Blog;
import com.example.Collab.entity.User;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DbManager {

    private static Connection connection;
    private static final String URL = "jdbc:sqlite:C:\\Users\\admin\\Documents\\java\\blog-servlet\\identifier.sqlite";
    private static final String GET_USER_BY_EMAIL = "SELECT * FROM users WHERE email = ? LIMIT 1";
    private static final String GET_ALL_BLOGS = "SELECT * FROM blogs";
    private static final String GET_USER_BY_ID = "SELECT * FROM users WHERE id = ?";
    private static final String ADD_USER = "INSERT INTO users VALUES(null,   ?, ?, ?)";
    private static final String ADD_BLOG = "INSERT INTO blogs VALUES(null, ?, ?, ?, ?)";

    static {
        try {
            Class.forName("org.sqlite.JDBC");
            connection = DriverManager.getConnection(URL);

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public static User getUserByEmail(String email) throws SQLException {

        User user = null;
        try {
            PreparedStatement statement = connection.prepareStatement(GET_USER_BY_EMAIL);
            statement.setString(1, email);

            ResultSet resultSet = statement.executeQuery();


            if (resultSet.next()) {
                user = new User
                        (
                                resultSet.getLong(1),
                                resultSet.getString(2),
                                resultSet.getString(3),
                                resultSet.getString(4)
                        );

            }
        /*statement.close();
        resultSet.close();*/
            /*connection.close();*/
        } catch (Exception e) {
            System.out.println("User does not exist");
        }
        return user;


    }

    public static List<Blog> getAllBlogs() throws SQLException {

        Blog blog;
        List<Blog> blogs = new ArrayList();
        PreparedStatement statement = connection.prepareStatement(GET_ALL_BLOGS);

        ResultSet set = statement.executeQuery();

        while (set.next()) {

            blog = new Blog(
                    set.getLong(1),
                    set.getString(2),
                    set.getString(3),
                    set.getLong(4),
                    set.getString(5)
            );
            blogs.add(blog);
        }
        return blogs;
    }

    public static User getUserById(Long id) throws SQLException {

        PreparedStatement statement = connection.prepareStatement(GET_USER_BY_ID);
        statement.setLong(1, id);
        ResultSet set = statement.executeQuery();

        return new User(
                set.getLong(1),
                set.getString(2),
                set.getString(3),
                set.getString(4)
        );

    }

    public static void addUser(User user) throws SQLException {

        PreparedStatement statement = connection.prepareStatement(ADD_USER);

        statement.setString(1, user.getEmail());
        statement.setString(2, user.getFullName());
        statement.setString(3, user.getPassword());

        statement.executeUpdate();


    }

    public static void addBlog(Blog blog) throws SQLException {

        PreparedStatement statement = connection.prepareStatement(ADD_BLOG);

        statement.setString(1, blog.getTitle());
        statement.setString(2, blog.getContent());
        statement.setLong(3, blog.getAuthorId());
        statement.setString(4, blog.getCreationDate());

        statement.executeUpdate();


    }


}
