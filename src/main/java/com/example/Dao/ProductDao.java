package com.example.Dao;

import com.example.Connector.JDBCConnector;
import com.example.Products.Product;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ProductDao implements BasicDao<Product> {
    @Override
    public List<Product> getAll() {
        List<Product> productList = new ArrayList<>();
        try (Connection conn = JDBCConnector.getConnection()) {
            Statement statement = conn.createStatement();
            ResultSet resultSet = statement.executeQuery("select * from products");
            {
                while ((resultSet.next())) {
                    int id = resultSet.getInt(1);
                    String name = resultSet.getString(2);
                    int cost = resultSet.getInt(3);
                    int count = resultSet.getInt(4);
                    Product product = new Product(id, name, cost, count);
                    productList.add(product);
                }
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
            throw new RuntimeException(ex);

        }
        return productList;
    }

    @Override
    public Product getById(int id) {
        Product product = new Product();
        try (Connection conn = JDBCConnector.getConnection()) {
            String sql = "select * from products where id=?";
            try (PreparedStatement preparedStatement = conn.prepareStatement(sql)) {
                preparedStatement.setInt(1, id);
                ResultSet resultSet = preparedStatement.executeQuery();
                if (resultSet.next()) {
                    String name = resultSet.getString(2);
                    int cost = resultSet.getInt(3);
                    int count = resultSet.getInt(4);
                      product = new Product(id, name, cost, count);
                }

            }

        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return product;
    }

    @Override
    public Product deleteById(int id) {
        Product product = new Product();
        try (Connection conn = JDBCConnector.getConnection()) {
            String sql = "DELETE FROM products WHERE id = ?";
            try (PreparedStatement preparedStatement = conn.prepareStatement(sql)) {
                preparedStatement.setInt(1, id);
                preparedStatement.execute();
            }
        } catch (Exception ex) {
            ex.printStackTrace();
            throw new RuntimeException(ex);
        }
        return null;
    }

    @Override
    public Product updateById(Product model) {
        Product product = getById(model.getId());
        try (Connection conn = JDBCConnector.getConnection()) {
            String sql = "UPDATE products SET name = ?, count = ?, cost = ? WHERE id = ?";
            try (PreparedStatement preparedStatement = conn.prepareStatement(sql)) {
                preparedStatement.setString(1, model.getName());
                preparedStatement.setInt(2, model.getCount());
                preparedStatement.setInt(3, model.getCost());
                preparedStatement.setInt(4, model.getId());
                preparedStatement.execute();
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return product;
    }

    @Override
    public Product create(Product model) {
        try (Connection conn = JDBCConnector.getConnection()) {
            String sql = "insert into products (name,cost, count ) values(?,?,?)";
            try (PreparedStatement preparedStatement = conn.prepareStatement(sql)) {
                preparedStatement.setString(1, model.getName());
                preparedStatement.setInt(2, model.getCost());
                preparedStatement.setInt(3, model.getCount());
                preparedStatement.execute();
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return model;
    }
}