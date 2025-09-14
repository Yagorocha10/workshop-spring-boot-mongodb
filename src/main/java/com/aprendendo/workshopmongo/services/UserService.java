package com.aprendendo.workshopmongo.services;


import com.aprendendo.workshopmongo.domain.User;
import com.aprendendo.workshopmongo.repository.UserRepository;
import com.aprendendo.workshopmongo.services.exception.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserRepository repo;

    public List<User> findAll() {
        return repo.findAll();
    }

    public User findById(String id) {
        return repo.findById(id)
                .orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado" + id));
    }




}
