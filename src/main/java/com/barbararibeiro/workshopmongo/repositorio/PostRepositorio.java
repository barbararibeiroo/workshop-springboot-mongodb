package com.barbararibeiro.workshopmongo.repositorio;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.barbararibeiro.workshopmongo.domain.Post;

@Repository
public interface PostRepositorio extends MongoRepository<Post, String>{
	
	List<Post> findByTitleContainingIgnoreCase(String texto);
}
