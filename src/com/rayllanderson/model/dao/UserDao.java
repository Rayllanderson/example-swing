package com.rayllanderson.model.dao;

import com.rayllanderson.model.dao.db.DB;
import com.rayllanderson.model.dao.db.DbException;
import com.rayllanderson.model.entities.User;
import com.rayllanderson.model.entities.enums.Perfil;

import java.sql.*;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

public class UserDao {

    private Connection conn = DB.getConnection();
    private SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");

    public void save(User user) {
        PreparedStatement st = null;
        try {
            st = conn.prepareStatement("insert into users" + " (cpf, name, birthdate, email, active, perfil_id) values (?, ?, ?, ?, "
                    + "?, ?);");
            insertUser(user, st);
            st.executeUpdate();
        } catch (SQLException e) {
            throw new DbException(e.getMessage());
        }
    }

    public void update(User user){
        PreparedStatement st = null;
        try {
            st = conn.prepareStatement("update users set cpf = ?, name = ?, birthdate = ?, email = ?, active = ?" +
                    ", perfil_id = ? where cpf = ?");
            insertUser(user, st);
            st.setInt(7, user.getCpf());
            st.executeUpdate();
        } catch (SQLException e) {
            throw new DbException(e.getMessage());
        }
    }

    public User findByCpf(Integer cpf) {
        PreparedStatement st = null;
        ResultSet rs = null;
        try {
            st = conn.prepareStatement("select * from users where cpf = " + cpf);
            rs = st.executeQuery();
            if (rs.next()) {
                return instantiateUser(rs);
            }
        } catch (SQLException e) {
            throw new DbException(e.getMessage());
        }
        return null;
    }

    public List<User> findAll() {
        PreparedStatement st = null;
        ResultSet rs = null;
        List<User> users = new ArrayList<>();
        try {
            st = conn.prepareStatement("select * from users");
            rs = st.executeQuery();
            while (rs.next()) {
                users.add(instantiateUser(rs));
            }
            return users;
        } catch (SQLException e) {
            throw new DbException(e.getMessage());
        }
    }

    public User deleteByCpf(Integer cpf) {
        PreparedStatement st = null;
        ResultSet rs = null;
        try {
            st = conn.prepareStatement("delete from users where cpf = " + cpf);
            int row = st.executeUpdate();
            if (row == 0) {
                throw new DbException("Ops, ocorreu um erro inesperado. Não conseguimos deletar.");
            }
        } catch (SQLException e) {
            throw new DbException(e.getMessage());
        }
        return null;
    }

    private void insertUser(User user, PreparedStatement st) throws SQLException {
        st.setInt(1, user.getCpf());
        st.setString(2, user.getName());
        st.setDate(3, new Date(user.getBirthdate().getTime()));
        st.setString(4, user.getEmail());
        st.setBoolean(5, user.isActive());
        st.setInt(6, user.getPerfil().getCode());
    }

    private User instantiateUser(ResultSet rs) throws SQLException {
        User user = new User();
        user.setCpf(rs.getInt("cpf"));
        user.setName(rs.getString("name"));
        user.setEmail(rs.getString("email"));
        user.setBirthdate(rs.getDate("birthdate"));
        user.setPerfil(Perfil.valueOf(rs.getInt("perfil_id")));
        user.setActive(rs.getBoolean("active"));
        return user;
    }

}
