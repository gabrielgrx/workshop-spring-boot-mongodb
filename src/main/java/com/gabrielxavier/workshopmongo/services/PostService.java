package com.gabrielxavier.workshopmongo.services;

import com.gabrielxavier.workshopmongo.domain.entities.Post;
import com.gabrielxavier.workshopmongo.domain.entities.User;
import com.gabrielxavier.workshopmongo.dto.UserDTO;
import com.gabrielxavier.workshopmongo.repositories.PostRepository;
import com.gabrielxavier.workshopmongo.repositories.UserRepository;
import com.gabrielxavier.workshopmongo.services.exception.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class PostService {

    @Autowired
    PostRepository repository;

    public Post findById(String id) {
        Optional<Post> obj = repository.findById(id);
        return obj.orElseThrow(() -> new ObjectNotFoundException("Object not found"));
    }

    public List<Post> findByTitle(String text) {
        return repository.searchTitle(text);
    }

    public List<Post> fullSearch(String text, Date minDate, Date maxDate) {
        maxDate = new Date(maxDate.getTime() + 24 * 60 * 60 * 1000);
        return repository.fullSearch(text, minDate, maxDate);
    }
}
