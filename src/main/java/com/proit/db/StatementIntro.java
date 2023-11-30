package com.proit.db;

import com.proit.db.helper.DbHelper;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class StatementIntro {

    public static void main(String[] args) {
        Connection con = null;
        Statement stmt = null;
        try {
            con = DbHelper.getConnection();
            stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery("select * from products");

            while (rs.next()) {
                System.out.println("Name: " + rs.getString("name"));
                System.out.println("UnitPrice: " + rs.getString("unitprice"));

            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                stmt.close();
                con.close();
            } catch (SQLException ex) {

            }
        }
    }
}
