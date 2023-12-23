package com.example.mysql_access.repos;

import org.springframework.data.repository.CrudRepository;

import com.example.mysql_access.model.User;

public interface UserRepo extends CrudRepository<User,Integer>{
    
    
}
