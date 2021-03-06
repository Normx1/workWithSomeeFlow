package com.example.Dao;

import com.example.Connector.JDBCConnector;
import com.example.User.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class UserDao implements BasicDao<User> {

    @Override
    public List<User> getAll() {
        List<User> userList = new ArrayList<>();
        try (Connection conn = JDBCConnector.getConnection();
             Statement statement = conn.createStatement();
             ResultSet resultSet = statement.executeQuery("select * from users");) {
            //Получем все элементы таблицы
            while (resultSet.next()) {
                int id = resultSet.getInt(1);
                String name = resultSet.getString(2);
                String mail = resultSet.getString(3);
                String password = resultSet.getString(4);
                User user = new User(id, name, mail, password);
                userList.add(user);
            }
        } catch (Exception ex) {
            ex.printStackTrace();
            throw new RuntimeException(ex);
        }
        return userList;
    }

    @Override
    public User getById(int id) {
        User user = new User();
        try (Connection conn = JDBCConnector.getConnection()) {
            String sql = "select * from users where id=?";
            try (PreparedStatement preparedStatement = conn.prepareStatement(sql)) {
                preparedStatement.setInt(1, id);
                ResultSet resultSet = preparedStatement.executeQuery();
                if (resultSet.next()) {
                    String name = resultSet.getString(2);
                    String mail = resultSet.getString(3);
                    String password = resultSet.getString(4);
                    user = new User(id, name, mail, password);
                }
            }
        } catch (Exception ex) {
            ex.printStackTrace();
            throw new RuntimeException(ex);
        }
        return user;
    }

    @Override
    public User deleteById(int id) {
        User user = getById(id);
        try (Connection conn = JDBCConnector.getConnection()) {
            String sql = "DELETE FROM users WHERE id = ?";
            try (PreparedStatement preparedStatement = conn.prepareStatement(sql)) {
                preparedStatement.setInt(1, id);
                preparedStatement.execute();
            }
        } catch (Exception ex) {
            ex.printStackTrace();
            throw new RuntimeException(ex);
        }
        return user;
    }


    @Override
    public User updateById(User user1) {
        User user = getById(user1.getId());
        try (Connection conn = JDBCConnector.getConnection()) {
            String sql = "UPDATE users SET name = ?, mail = ?, password = ? WHERE id = ?";
            try (PreparedStatement preparedStatement = conn.prepareStatement(sql)) {
                preparedStatement.setString(1, user1.getName());
                preparedStatement.setString(2, user1.getMail());
                preparedStatement.setString(3, user1.getPassword());
                preparedStatement.setInt(4, user1.getId());
                preparedStatement.execute();
            }
        } catch (Exception ex) {
            ex.printStackTrace();
            throw new RuntimeException(ex);
        }
        return user;
    }

    @Override
    public User create(User user) {
        try (Connection conn = JDBCConnector.getConnection()) {
            String sql = "insert into users (name, mail, password) values (?, ?, ?)";
            try (PreparedStatement preparedStatement = conn.prepareStatement(sql)) {
                preparedStatement.setString(1, user.getName());
                preparedStatement.setString(2, user.getMail());
                preparedStatement.setString(3, user.getPassword());
                preparedStatement.execute();
            }
        } catch (Exception ex) {
            ex.printStackTrace();
            throw new RuntimeException(ex);
        }
        return user;
    }

     public static User find(String name, String password) {
         User user = new User();
         try (Connection conn = JDBCConnector.getConnection()) {
             String sql = "select * from users where name =? , password = ?";
             try (PreparedStatement preparedStatement = conn.prepareStatement(sql)) {
                 preparedStatement.setString(1, name);
                 preparedStatement.setString(2, password);
                 ResultSet resultSet = preparedStatement.executeQuery();
                 if (resultSet.next()) {
                     int id = resultSet.getInt(1);
                     String nameUser = resultSet.getString(2);
                     String mail = resultSet.getString(3);
                     String passwordUser = resultSet.getString(4);
                     user = new User(id, nameUser, mail, passwordUser);
                 }
             }
         } catch (Exception ex) {
             ex.printStackTrace();
             throw new RuntimeException(ex);
         }
         return user;
    }
}