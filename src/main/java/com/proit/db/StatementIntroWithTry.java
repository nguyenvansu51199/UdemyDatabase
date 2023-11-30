package com.proit.db;

import com.proit.db.helper.DbHelper;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

public class StatementIntroWithTry {

    public static void main(String[] args) {
        try (
                Connection con = DbHelper.getConnection(); Statement stmt = con.createStatement();) {

            ResultSet rs = stmt.executeQuery("select * from products");

            while (rs.next()) {
                System.out.println("Name: " + rs.getString("name"));
                System.out.println("UnitPrice: " + rs.getString("unitprice"));

            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
