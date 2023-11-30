package com.proit.db;

import com.proit.db.helper.DbHelper;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

public class SearchQueryStatement {

    public static void main(String[] args) {
        String sql = "select * from products where name = 'Jeans' or quantity=20";
        try (
                Connection con = DbHelper.getConnection(); Statement stmt = con.createStatement();) {
            ResultSet rs = stmt.executeQuery(sql);

            while (rs.next()) {
                System.out.println("Product Name: " + rs.getString("name"));
                System.out.println("Unitprice: " + rs.getString("unitprice"));
                System.out.println("Quantity: " + rs.getString("quantity"));
                System.out.println("-----");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
