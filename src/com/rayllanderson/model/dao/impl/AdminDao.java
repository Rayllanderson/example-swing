package com.rayllanderson.model.dao.impl;

import com.rayllanderson.model.dao.exceptions.ObjectExistsException;
import com.rayllanderson.model.dao.db.DB;
import com.rayllanderson.model.dao.exceptions.DbException;
import com.rayllanderson.model.entities.Admin;
import com.rayllanderson.model.entities.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class AdminDao {

    private Connection conn = DB.getConnection();

    public void save(Admin admin) throws ObjectExistsException {
        PreparedStatement st = null;
        try {
            st = conn.prepareStatement("insert into admins (username, password) values (?, ?);");
            st.setString(1, admin.getUsername());
            st.setString(2, admin.getPassword());
            st.executeUpdate();
        } catch (SQLException e) {
            throw new DbException(e.getMessage());
        }
    }

    public void update(Admin admin){
        PreparedStatement st = null;
        try {
            st = conn.prepareStatement("update users set id = ?, username = ?, password = ? where id = ?");
            insertAdmin(admin, st);
            st.setLong(4, admin.getId());
            st.executeUpdate();
        } catch (SQLException e) {
            throw new DbException(e.getMessage());
        }
    }

    public Admin findById(Long id) {
        PreparedStatement st = null;
        ResultSet rs = null;
        try {
            st = conn.prepareStatement("select * from admins where id = " + id);
            rs = st.executeQuery();
            if (rs.next()) {
                return instantiateAdmin(rs);
            }
        } catch (SQLException e) {
            throw new DbException(e.getMessage());
        }
        return null;
    }

    public List<Admin> findAll() {
        PreparedStatement st = null;
        ResultSet rs = null;
        List<Admin> admins = new ArrayList<>();
        try {
            st = conn.prepareStatement("select * from admins");
            rs = st.executeQuery();
            while (rs.next()) {
                admins.add(instantiateAdmin(rs));
            }
            return admins;
        } catch (SQLException e) {
            throw new DbException(e.getMessage());
        }
    }

    public User deleteById(Long id) {
        PreparedStatement st = null;
        ResultSet rs = null;
        try {
            st = conn.prepareStatement("delete from admins where id = " + id);
            int row = st.executeUpdate();
            if (row == 0) {
                throw new DbException("Ops, ocorreu um erro. Id não existe.");
            }
        } catch (SQLException e) {
            throw new DbException(e.getMessage());
        }
        return null;
    }

    private void insertAdmin(Admin admin, PreparedStatement st) throws SQLException {
        st.setLong(1, admin.getId());
        st.setString(2, admin.getUsername());
        st.setString(3, admin.getPassword());
    }

    private Admin instantiateAdmin(ResultSet rs) throws SQLException {
        Admin admin = new Admin();
        admin.setId(rs.getLong("id"));
        admin.setUsername(rs.getString("username"));
        admin.setPassword(rs.getString("password"));
        return admin;
    }

}
