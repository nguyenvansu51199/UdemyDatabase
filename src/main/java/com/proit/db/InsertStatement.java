package com.proit.db;

import com.proit.db.helper.DbHelper;
import java.sql.Connection;
import java.sql.Statement;

public class InsertStatement {

    public static void main(String[] args) {
        String sql = "Insert into products(name, unitPrice, quantity)"
                + "values(Jean, 2000, 30)";
        try (Connection con = DbHelper.getConnection(); Statement stmt = con.createStatement()) {
            int effected = stmt.executeUpdate(sql);
            System.out.println("EffectedRow:");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
