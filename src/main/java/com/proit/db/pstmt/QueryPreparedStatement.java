package com.proit.db.pstmt;

import com.proit.db.helper.DbHelper;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class QueryPreparedStatement {

    public static void main(String[] args) {
        String sql = "select * from products";
        try (
                Connection con = DbHelper.getConnection(); PreparedStatement pstmt = con.prepareStatement(sql);) {
            ResultSet rs = pstmt.executeQuery();

            while (rs.next()) {
                int id = rs.getInt("productid");
                String name = rs.getString("name");
                double unitPrice = rs.getDouble("unitprice");
                int quantity = rs.getInt("quantity");
                System.out.printf("%d %s %f %d", id, name, unitPrice, quantity);
                System.out.println("--");
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
