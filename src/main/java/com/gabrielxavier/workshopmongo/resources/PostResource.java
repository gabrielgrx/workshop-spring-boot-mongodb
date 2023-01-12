package com.gabrielxavier.workshopmongo.resources;

import com.gabrielxavier.workshopmongo.domain.entities.Post;
import com.gabrielxavier.workshopmongo.domain.entities.User;
import com.gabrielxavier.workshopmongo.dto.UserDTO;
import com.gabrielxavier.workshopmongo.resources.util.URL;
import com.gabrielxavier.workshopmongo.services.PostService;
import com.gabrielxavier.workshopmongo.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping(value = "/posts")
public class PostResource {

    @Autowired
    private PostService service;

    @GetMapping(value = "/{id}")
    public ResponseEntity<Post> findById(@PathVariable String id) {
        Post obj = service.findById(id);
        return ResponseEntity.ok().body(obj);
    }

    @GetMapping(value = "/titlesearch")
    public ResponseEntity<List<Post>> findByTitle(@RequestParam(value = "text", defaultValue = "") String text) {
        text = URL.decodeParam(text);
        List<Post> list = service.findByTitle(text);
        return ResponseEntity.ok().body(list);
    }
}
