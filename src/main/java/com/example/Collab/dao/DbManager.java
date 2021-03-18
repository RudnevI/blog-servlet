package com.example.Collab.dao;

import com.example.Collab.entity.User;

import java.sql.*;

public class DbManager {

    private static Connection connection;
    private static final String URL = "jdbc:sqlite:C:\\Users\\РудневИ\\Documents\\SpringServer\\Collab\\identifier.sqlite";
    private static final String GET_USER_BY_EMAIL = "SELECT * FROM users WHERE email = ? LIMIT 1";

    static {
        try{
            Class.forName("org.sqlite.JDBC");
            connection = DriverManager.getConnection(URL);

        }
        catch (Exception e) {
            e.printStackTrace();
        }

    }

    public static User getUserByEmail(String email) throws SQLException {

        User user = null;

        PreparedStatement statement = connection.prepareStatement(GET_USER_BY_EMAIL);
        statement.setString(1, email);

        ResultSet resultSet = statement.executeQuery();




        if(resultSet.next())  {
            user = new User
                    (
                            resultSet.getLong(1),
                            resultSet.getString(2),
                            resultSet.getString(3),
                            resultSet.getString(4)
                    );

        }
        statement.close();
        resultSet.close();
        /*connection.close();*/

        return user;


    }
}
