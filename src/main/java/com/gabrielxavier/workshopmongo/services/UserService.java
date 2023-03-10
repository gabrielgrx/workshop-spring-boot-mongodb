package com.gabrielxavier.workshopmongo.services;

import com.gabrielxavier.workshopmongo.domain.entities.User;
import com.gabrielxavier.workshopmongo.dto.UserDTO;
import com.gabrielxavier.workshopmongo.repositories.UserRepository;
import com.gabrielxavier.workshopmongo.services.exception.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    UserRepository repository;

    public List<User> findAll() {
        return repository.findAll();
    }

    public User findById(String id) {
        Optional<User> obj = repository.findById(id);
        return obj.orElseThrow(() -> new ObjectNotFoundException("Object not found"));
    }

    public User insert(User obj) {
        return repository.insert(obj);
    }

    public void delete(String id) {
        findById(id); //throws exception if doesn't exists
        repository.deleteById(id);
    }

    public User update(User obj) {
        User newObj = findById(obj.getId());
        updateData(Optional.ofNullable(newObj), obj);
        return repository.save(newObj);
    }

    private void updateData(Optional<User> newObj, User obj) {
        newObj.get().setName(obj.getName());
        newObj.get().setEmail(obj.getEmail());
    }

    public User fromDTO(UserDTO objDto) {
        return new User(objDto.getId(), objDto.getName(), objDto.getEmail());
    }

}
