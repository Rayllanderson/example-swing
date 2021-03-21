package com.rayllanderson.model.dao;

import com.rayllanderson.model.dao.db.DB;
import com.rayllanderson.model.dao.db.DbException;
import com.rayllanderson.model.entities.User;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class UserDao {

    private Connection conn = DB.getConnection();

    public void save(User user) {
        PreparedStatement st = null;
        try {
            st = conn.prepareStatement("insert into users" + " (cpf, name, birthdate, email, active, perfil_id) values (?, ?, ?, ?, "
                    + "?, ?);");
            insertUser(user, st);
            st.executeUpdate();
        } catch (SQLException e) {
            throw new DbException(e.getMessage());
        } finally {
            DB.closeConnection();
        }
    }

    private void insertUser(User user, PreparedStatement st) throws SQLException {
        st.setInt(1, user.getCpf());
        st.setString(2, user.getName());
        st.setDate(3, new Date(user.getBirthdate().getTime()));
        st.setString(4, user.getEmail());
        st.setBoolean(5, user.isActive());
        st.setInt(6, user.getPerfil().getCode());
    }

}
