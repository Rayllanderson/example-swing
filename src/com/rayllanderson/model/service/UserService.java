package com.rayllanderson.model.service;

import com.rayllanderson.model.dao.db.DB;
import com.rayllanderson.model.entities.User;

import java.sql.Connection;
import java.util.List;

public class UserService {

    private Connection conn = DB.getConnection();

    public void save(User user){
    }

    public static List<User> getAll(){
        return null;
    }

    public boolean deleteById(Long id){
        return false;
    }

    public void update(User user) {
        this.save(user);
    }
}
