package com.rayllanderson.tests;

import com.rayllanderson.model.dao.DB;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DataBaseTest {

    public static void main(String[] args) throws SQLException {

        Connection conn = DB.getConnection();

        Statement st = conn.createStatement();

        String sql = "SELECT * FROM perfils ";

        ResultSet rs = st.executeQuery(sql);

        while (rs.next()) {
            System.out.print(rs.getLong("id") + " - ");
            System.out.println(rs.getString("name"));
        }


    }
}
