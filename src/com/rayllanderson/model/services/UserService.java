package com.rayllanderson.model.services;

import com.rayllanderson.model.dao.exceptions.DbException;
import com.rayllanderson.model.dao.exceptions.ObjectExistsException;
import com.rayllanderson.model.dao.impl.UserDao;
import com.rayllanderson.model.dao.utils.Assert;
import com.rayllanderson.model.entities.User;

import java.util.List;

public class UserService {

    private UserDao userDao;

    public UserService(){
        userDao = new UserDao();
    }

    public void save(User user) throws ObjectExistsException {
        Assert.cpfNotExists(user.getCpf());
        userDao.save(user);
    }

    public List<User> getAll(){
        return userDao.findAll();
    }

    public User getByCpf(String cpf){
        return userDao.findByCpf(cpf);
    }

    public boolean deleteByCpf(String cpf){
        try{
            userDao.deleteByCpf(cpf);
            return true;
        }catch (DbException e){
            return false;
        }
    }

    public void update(User user) {
        userDao.update(user);
    }
}
