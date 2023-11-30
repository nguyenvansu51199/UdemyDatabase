package com.proit.db.dao;

import com.proit.db.helper.DbHelper;
import com.proit.db.model.Product;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class ProductDao {

    public Product create(Product entity) throws ClassNotFoundException, SQLException {
        String sql = "insert into products(name, unitprice, quantity)"
                + "values(?, ?, ?) ";
        try (Connection con = DbHelper.getConnection(); PreparedStatement pstmt = con.prepareStatement(sql,
                Statement.RETURN_GENERATED_KEYS);) {

            pstmt.setString(1, entity.getName());
            pstmt.setDouble(2, entity.getUnitPrice());
            pstmt.setInt(3, entity.getQuantity());

            int rows = pstmt.executeUpdate();

            ResultSet rs = pstmt.getGeneratedKeys();
            if (rs.next()) {
                entity.setProductId(rs.getInt(1));
            }
            return entity;
        }
    }

    public Product update(Product entity) throws ClassNotFoundException, SQLException {
        String sql = "update products set name = ?, unitPrice = ?, quantity=? where productId =?";
        try (Connection con = DbHelper.getConnection(); PreparedStatement pstmt = con.prepareStatement(sql)) {

            pstmt.setString(1, entity.getName());
            pstmt.setDouble(2, entity.getUnitPrice());
            pstmt.setInt(3, entity.getQuantity());
            pstmt.setInt(4, entity.getProductId());
            int rows = pstmt.executeUpdate();

            return entity;
        }
    }

    public Product findById(int id) throws ClassNotFoundException, SQLException {
        String sql = "select * from products where productid = ?";
        try (Connection con = DbHelper.getConnection(); PreparedStatement pstmt = con.prepareStatement(sql)) {

            pstmt.setInt(1, id);
            ResultSet rs = pstmt.executeQuery();
            Product entity = null;
            if (rs.next()) {
                entity = new Product();
                entity.setProductId(id);
                entity.setName(rs.getString("name"));
                entity.setUnitPrice(rs.getDouble("unitprice"));
                entity.setQuantity(rs.getInt("quantity"));

            }
            return entity;
        }
    }
}
