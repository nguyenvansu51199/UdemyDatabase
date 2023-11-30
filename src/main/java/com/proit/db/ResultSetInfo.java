package com.proit.db;

import com.proit.db.helper.DbHelper;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.Statement;

public class ResultSetInfo {

    public static void main(String[] args) {
        try (
                Connection con = DbHelper.getConnection(); Statement stmt = con.createStatement();) {
            String sql = "select * from products";
            ResultSet rs = stmt.executeQuery(sql);

            ResultSetMetaData meta = rs.getMetaData();

            System.out.println("Column count: " + meta.getColumnCount());

            for (int i = 1; i <= meta.getColumnCount(); i++) {
                System.out.printf("%d: %s \n", i, meta.getColumnName(i));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
