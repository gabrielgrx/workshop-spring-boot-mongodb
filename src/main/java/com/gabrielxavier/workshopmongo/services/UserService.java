package com.gabrielxavier.workshopmongo.services;

import com.gabrielxavier.workshopmongo.domain.entities.User;
import com.gabrielxavier.workshopmongo.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    @Autowired
    UserRepository repository;

    public List<User> findAll() {
        return repository.findAll();
    }
}
