package com.proit.db;

import com.proit.db.helper.DbHelper;
import java.sql.Connection;
import java.sql.Statement;

public class UpdateStatement {

    public static void main(String[] args) {
        String sql = "update products set name = 'Skirt', unitprice = 1000 where productid = 1";

        try (
                Connection con = DbHelper.getConnection(); Statement stmt = con.createStatement();) {
            int effected = stmt.executeUpdate(sql);
            System.out.println("Effected: " + effected);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
