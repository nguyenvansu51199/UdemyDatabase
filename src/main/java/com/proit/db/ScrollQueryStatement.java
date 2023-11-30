package com.proit.db;

import com.proit.db.helper.DbHelper;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

public class ScrollQueryStatement {

    public static void main(String[] args) {
        String sql = "select * from products";
        try (
                Connection con = DbHelper.getConnection(); Statement stmt = con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);) {

            ResultSet rs = stmt.executeQuery(sql);

            while (rs.next()) {
                System.out.println("Product Name: " + rs.getString("name"));
            }

            if (rs.previous()) {
                System.out.println("Product Name: " + rs.getString("name"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
