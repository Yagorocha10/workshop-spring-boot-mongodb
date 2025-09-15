package com.aprendendo.workshopmongo.repository;

import com.aprendendo.workshopmongo.domain.Post;
import com.aprendendo.workshopmongo.domain.User;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PostRepository extends MongoRepository<Post, String> {
}
