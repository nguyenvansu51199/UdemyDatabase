package com.proit.db;

import com.proit.db.helper.DbHelper;
import java.sql.Connection;

public class UdemyDatabases {

    public static void main(String[] args) {
        try {
            Connection con = DbHelper.getConnection();
            System.out.println("Successfully");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
