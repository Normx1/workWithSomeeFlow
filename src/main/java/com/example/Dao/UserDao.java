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
             ResultSet resultSet = statement.executeQuery("select * from table_name");) {
            //Получем все элементы таблицы
            while (resultSet.next()) {
                int id = resultSet.getInt(1);
                String name = resultSet.getString(2);
                String mail = resultSet.getString(3);
                User user = new User(id, name, mail);
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
            String sql = "select * from table_name where id=?";
            try (PreparedStatement preparedStatement = conn.prepareStatement(sql)) {
                preparedStatement.setInt(1, id);
                ResultSet resultSet = preparedStatement.executeQuery();
                if (resultSet.next()) {

                    int userId = resultSet.getInt(1);
                    String name = resultSet.getString(2);
                    String mail = resultSet.getString(3);
                    String password = resultSet.getString(4);
                    User userById = new User(userId, name, mail, password);
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
            String sql = "DELETE FROM table_name WHERE id = ?";
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
            String sql = "UPDATE table_name SET name = ?, mail = ?, password = ? WHERE id = ?";
            try (PreparedStatement preparedStatement = conn.prepareStatement(sql)) {
                preparedStatement.setString(1, user1.getName());
                preparedStatement.setString(2, user1.getMail());
                preparedStatement.setString(3, user1.getPassword());
                preparedStatement.setInt(4, user.getId());
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
            String sql = "insert into table_name (name, mail, password) values (?, ?, ?)";
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
}