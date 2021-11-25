package com.ouhamza.crud_app.dao;

import com.ouhamza.crud_app.model.User;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserReop extends JpaRepository<User, Integer> {

}