package com.example.springmarket.repository.mappers;

import com.example.springmarket.model.Category;
import com.example.springmarket.model.Product;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class CategoryMapper {
    private final Connection connection;

    public CategoryMapper(Connection connection) {
        this.connection  = connection;
    }

    public Category findById(int id) throws SQLException {
        PreparedStatement statement = connection.prepareStatement(
                "SELECT id, category_name FROM Categories WHERE id = ?");
        statement.setInt(1,id);
        try (ResultSet resultSet = statement.executeQuery()) {
            while (resultSet.next()) {
                Category category = new Category();
                category.setId(resultSet.getLong(1));
                category.setCategoryName(resultSet.getString(2));
                return category;
            }
        }

        throw new IllegalArgumentException("No category found with id=" + id);
    }

    public void insert(Category category) throws SQLException {
        PreparedStatement statement = connection.prepareStatement(
                "INSERT INTO Categories (category_name) VALUES (?)");
        statement.setString(1, category.getCategoryName());
    }

    public void update(Category category) throws SQLException {
        PreparedStatement statement = connection.prepareStatement(
                "UPDATE INTO Categories (category_name) VALUE (?) WHERE id =?");
        statement.setString(1, category.getCategoryName());
        statement.setLong(1, category.getId());
    }

    public void delete(Category category) throws SQLException {
        PreparedStatement statement = connection.prepareStatement(
                "DELETE FROM Categories WHERE id =?");
        statement.setLong(1, category.getId());
    }
}
