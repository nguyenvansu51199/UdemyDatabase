package com.proit.db.pstmt;

import com.proit.db.helper.DbHelper;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class BatchProcessing {

    public static void main(String[] args) {
        String sql = "insert into products (name, unitprice, quantity)"
                + " values(?,?,?)";
        try (
                Connection con = DbHelper.getConnection(); PreparedStatement pstmt = con.prepareStatement(sql);) {
            pstmt.setString(1, "Jacket");
            pstmt.setDouble(2, 250);
            pstmt.setInt(3, 45);
            pstmt.addBatch();

            pstmt.setString(1, "Jacket1");
            pstmt.setDouble(2, 350);
            pstmt.setInt(3, 45);
            pstmt.addBatch();

            int[] rows = pstmt.executeBatch();
            for (int row : rows) {
                System.out.println("Effected row: " + row);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
