package com.gabrielxavier.workshopmongo.repositories;

import com.gabrielxavier.workshopmongo.domain.entities.Post;
import com.gabrielxavier.workshopmongo.domain.entities.User;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PostRepository extends MongoRepository<Post, String> {

    List<Post> findByTitleContainingIgnoreCase(String text);
}
