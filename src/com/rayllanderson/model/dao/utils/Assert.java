package com.rayllanderson.model.dao.utils;

import com.rayllanderson.model.dao.db.DB;
import com.rayllanderson.model.dao.exceptions.DbException;
import com.rayllanderson.model.dao.exceptions.ObjectExistsException;

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
            st = conn.prepareStatement("select count(username)>0 from admins where username = '" + username + "'");
            rs = st.executeQuery();
            if (rs.next()) {
                boolean hasUsername = rs.getBoolean(1);
                if(hasUsername) {
                    throw new ObjectExistsException("Username já cadastrado. Tente outro.");
                }
            }
        } catch (SQLException e) {
            throw new DbException(e.getMessage());
        }
    }

    public static void cpfNotExists(String cpf) {
        Connection conn = DB.getConnection();
        PreparedStatement st = null;
        ResultSet rs = null;
        try {
            st = conn.prepareStatement("select count(cpf)>0 from users where cpf = '" + cpf + "'");
            rs = st.executeQuery();
            if (rs.next()) {
                boolean hasCpf = rs.getBoolean(1);
                if(hasCpf) {
                    throw new ObjectExistsException("Já existe um usuário cadastrado com o cpf " + cpf +". Tente outro.");
                }
            }
        } catch (SQLException e) {
            throw new DbException(e.getMessage());
        }
    }
}
