package com.aprendendo.workshopmongo.resources;


import com.aprendendo.workshopmongo.domain.Post;
import com.aprendendo.workshopmongo.domain.User;
import com.aprendendo.workshopmongo.dto.UserDTO;
import com.aprendendo.workshopmongo.repository.PostRepository;
import com.aprendendo.workshopmongo.repository.UserRepository;
import com.aprendendo.workshopmongo.resources.util.URL;
import com.aprendendo.workshopmongo.services.PostService;
import com.aprendendo.workshopmongo.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping(value = "/posts")
public class PostResource {
    @Autowired
    private PostService service;
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PostRepository repo;


    @GetMapping(value = "/{id}")
    public ResponseEntity<Post> findById(@PathVariable String id) {
        Post obj = service.findById(id);
        return ResponseEntity.ok(obj);
    }

    @GetMapping
    public ResponseEntity<List<Post>> findAll() {
        return  ResponseEntity.ok(repo.findAll());
    }

    @GetMapping(value = "/titlesearch")
    public ResponseEntity<List<Post>> findByTitle(@RequestParam(value = "text", defaultValue = "") String text) {
        text = URL.decodeParam(text);
        List<Post> list = service.findByTitle(text);
        return ResponseEntity.ok().body(list);



    }




}
