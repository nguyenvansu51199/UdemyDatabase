package com.proit.db.pstmt;

import com.proit.db.helper.DbHelper;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class UpdatePreparedStatement {

    public static void main(String[] args) {
        String sql = "update products set name = ?, unitprice=?, quantity=?"
                + " where productid=?";
        try (
                Connection con = DbHelper.getConnection(); PreparedStatement pstmt = con.prepareStatement(sql);) {
            pstmt.setString(1, "Shoes");
            pstmt.setDouble(2, 2000);
            pstmt.setInt(3, 50);
            pstmt.setInt(4, 3);

            int rows = pstmt.executeUpdate();

            System.out.println("Row: " + rows);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
