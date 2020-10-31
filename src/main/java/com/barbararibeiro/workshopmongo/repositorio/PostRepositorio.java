package com.barbararibeiro.workshopmongo.repositorio;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.barbararibeiro.workshopmongo.domain.Post;

@Repository
public interface PostRepositorio extends MongoRepository<Post, String>{


}
