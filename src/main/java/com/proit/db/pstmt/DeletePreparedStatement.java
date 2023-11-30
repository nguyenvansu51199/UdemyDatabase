package com.proit.db.pstmt;

import com.proit.db.helper.DbHelper;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class DeletePreparedStatement {

    public static void main(String[] args) {
        String sql = "delete from products where productid = ?";
        try (
                Connection con = DbHelper.getConnection(); PreparedStatement pstmt = con.prepareStatement(sql);) {
            pstmt.setInt(1, 5);

            int rows = pstmt.executeUpdate();

            System.out.println("Row: " + rows);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
