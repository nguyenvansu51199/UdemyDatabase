package com.proit.db.pstmt;

import com.proit.db.helper.DbHelper;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Scanner;

public class SearchQueryPreparedStatement {

    public static void main(String[] args) {
        String sql = "select * from products where name like ?";
        try (
                Connection con = DbHelper.getConnection(); PreparedStatement pstmt = con.prepareStatement(sql);) {
            Scanner sc = new Scanner(System.in);
            System.out.printf("Type of name product: ");
            String search = sc.nextLine();
            pstmt.setString(1, "%" + search + "%");
            ResultSet rs = pstmt.executeQuery();

            while (rs.next()) {
                int id = rs.getInt("productid");
                String name = rs.getString("name");
                double unitPrice = rs.getDouble("unitprice");
                int quantity = rs.getInt("quantity");
                System.out.printf("%3d %3s %3f %3d", id, name, unitPrice, quantity);
                System.out.println("");
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
