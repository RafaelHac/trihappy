package com.trihappy.alpha.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.trihappy.alpha.domain.Post;

@Repository
public interface PostRepository extends MongoRepository<Post, String>{

}
