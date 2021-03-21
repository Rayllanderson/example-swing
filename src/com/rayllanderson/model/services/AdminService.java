package com.rayllanderson.model.services;

import com.rayllanderson.model.dao.exceptions.ObjectExistsException;
import com.rayllanderson.model.dao.impl.AdminDao;
import com.rayllanderson.model.dao.utils.Assert;
import com.rayllanderson.model.entities.Admin;

import java.util.List;

public class AdminService {

    private AdminDao dao;

    public AdminService() {
        dao = new AdminDao();
    }

    public void register(Admin admin) throws ObjectExistsException {
        Assert.usernameNotExists(admin.getUsername());
        dao.save(admin);
    }

    public void update(Admin admin){
        Assert.usernameNotExists(admin.getUsername());
        dao.update(admin);
    }

    public List<Admin> getAll() {
        return dao.findAll();
    }

    public Admin getById(Long id) {
        return dao.findById(id);
    }

    public void deleteById(Long id){
        dao.deleteById(id);
    }

}
