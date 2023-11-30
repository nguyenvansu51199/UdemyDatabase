package com.proit.db;

import com.proit.db.helper.DbHelper;
import java.sql.Connection;
import java.sql.Statement;

public class DeleteStatement {

    public static void main(String[] args) {
        String sql = "delete from products where productid = 2";
        try (
                Connection con = DbHelper.getConnection(); Statement stmt = con.createStatement();) {
            int effected = stmt.executeUpdate(sql);
            System.out.println("Effected: " + effected);
        } catch (Exception e) {
        }
    }

}
