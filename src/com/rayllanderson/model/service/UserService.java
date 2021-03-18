package com.rayllanderson.model.service;

import com.rayllanderson.model.entities.User;

import java.util.ArrayList;
import java.util.List;

public class UserService {

    private static List<User> users = new ArrayList<>();

    public void save(User user){
        users.add(user);
    }

    public static List<User> getAll(){
        return users;
    }

    public boolean deleteById(Long id){
        return users.removeIf(u -> u.getId().equals(id));
    }

    public void update(User user) {
        deleteById(user.getId());
        this.save(user);
    }
}
