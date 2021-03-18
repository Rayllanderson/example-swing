package com.rayllanderson.model.service;

import com.rayllanderson.model.entities.User;

import java.util.ArrayList;
import java.util.List;

public class UserService {

    private static List<User> users = new ArrayList<>();

    public void add(User user){
        users.add(user);
    }

    public static List<User> getAll(){
        return users;
    }

    public boolean deleteById(Long id){
        return users.removeIf(u -> u.getId().equals(id));
    }
}
