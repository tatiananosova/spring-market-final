package com.example.springmarket.repository.mappers;

import com.example.springmarket.model.Product;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

public class ProductMapper {
    private final Connection connection;
    private final CategoryMapper categoryMapper;
    private Map<Long, Product> productMap = new HashMap<>();

    public ProductMapper(Connection connection) {
        this.connection  = connection;
        this.categoryMapper = new CategoryMapper(connection);
    }

    public void findById(Long id) throws SQLException {
        PreparedStatement statement = connection.prepareStatement(
                "SELECT id, title, cost, category_id FROM Products WHERE id = ?");
        statement.setLong(1,id);
        try (ResultSet resultSet = statement.executeQuery()) {
            while (resultSet.next()) {
                Product product = new Product();
                product.setId(resultSet.getLong(1));
                product.setTitle(resultSet.getString(2));
                product.setCost(resultSet.getInt(3));
                product.setCategory(categoryMapper.findById(resultSet.getInt(4)));

                productMap.put(product.getId(), product);
            }
        }

        throw new IllegalArgumentException("No product found with id=" + id);
    }

    public Product getById (Long id) {
        return productMap.get(id);
    }

    public void insert(Product product) throws SQLException {
        PreparedStatement statement = connection.prepareStatement(
                "INSERT INTO Products (title, cost, category_id) VALUES (?,?,?)");
        statement.setString(1, product.getTitle());
        statement.setInt(2, product.getCost());
        statement.setLong(3, product.getCategory().getId());
    }

    public void update(Product product) throws SQLException {
        PreparedStatement statement = connection.prepareStatement(
                "UPDATE INTO Products (title, cost, category_id) VALUE (?,?,?) WHERE id =?");
        statement.setString(1, product.getTitle());
        statement.setInt(2, product.getCost());
        statement.setLong(3, product.getCategory().getId());
        statement.setLong(4, product.getId());
    }

    public void delete(Product product) throws SQLException {
        PreparedStatement statement = connection.prepareStatement(
                "DELETE FROM Products WHERE id =?");
        statement.setLong(1, product.getId());
    }

}
