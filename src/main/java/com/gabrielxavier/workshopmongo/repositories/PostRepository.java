package com.gabrielxavier.workshopmongo.repositories;

import com.gabrielxavier.workshopmongo.domain.entities.Post;
import com.gabrielxavier.workshopmongo.domain.entities.User;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PostRepository extends MongoRepository<Post, String> {
}
