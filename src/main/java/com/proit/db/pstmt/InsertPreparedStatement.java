package com.proit.db.pstmt;

import com.proit.db.helper.DbHelper;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class InsertPreparedStatement {

    public static void main(String[] args) {
        String sql = "insert into products (name, unitprice, quantity)"
                + " values(?,?,?)";
        try (
                Connection con = DbHelper.getConnection(); PreparedStatement pstmt = con.prepareStatement(sql);) {
            pstmt.setString(1, "Shirt");
            pstmt.setDouble(2, 250);
            pstmt.setInt(3, 45);
            int rows = pstmt.executeUpdate();

            System.out.println("Row: " + rows);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
