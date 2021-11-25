package com.ouhamza.crud_app.service;

import com.ouhamza.crud_app.dao.RoleRepo;
import com.ouhamza.crud_app.model.Role;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ReoleService {

    @Autowired
    private RoleRepo roleRepo;

    public void save(Role role){
        roleRepo.save(role);
    }

}