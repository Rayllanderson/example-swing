package com.rayllanderson.model.dao.utils;

import com.rayllanderson.model.dao.db.DB;
import com.rayllanderson.model.dao.exceptions.DbException;
import com.rayllanderson.model.dao.exceptions.UsernameExistsException;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Assert {

    public static void usernameNotExists(String username) {
        Connection conn = DB.getConnection();
        PreparedStatement st = null;
        ResultSet rs = null;
        try {
            st = conn.prepareStatement("select count(admins)>0 from admins where username = '" + username + "'");
            rs = st.executeQuery();
            if (rs.next()) {
                boolean hasUsername = rs.getBoolean(1);
                if(hasUsername) {
                    throw new UsernameExistsException("Username já cadastrado. Tente outro.");
                }
            }
        } catch (SQLException e) {
            throw new DbException(e.getMessage());
        }
    }
}
