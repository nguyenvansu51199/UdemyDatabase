package com.proit.db.pstmt;

import com.proit.db.helper.DbHelper;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class TransactionDemo {

    public static void main(String[] args) {
        String sql = "insert into products (name, unitprice, quantity)"
                + " values(?,?,?)";
        try (
                Connection con = DbHelper.getConnection(); PreparedStatement pstmt = con.prepareStatement(sql);) {
            try {
                con.setAutoCommit(false);
                pstmt.setString(1, "Hat");
                pstmt.setDouble(2, 350);
                pstmt.setInt(3, 45);
                int rows = pstmt.executeUpdate();

                pstmt.setString(1, "Hat1");
                pstmt.setDouble(2, 550);
                pstmt.setInt(3, 45);
                rows = pstmt.executeUpdate();

                System.out.println("Row: " + rows);
                con.commit();
            } catch (Exception e) {
                con.rollback();
                e.printStackTrace();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
