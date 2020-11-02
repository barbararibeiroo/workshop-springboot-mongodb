package com.barbararibeiro.workshopmongo.repositorio;

import java.util.Date;
import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import com.barbararibeiro.workshopmongo.domain.Post;

@Repository
public interface PostRepositorio extends MongoRepository<Post, String>{

@Query("{ 'title': <field>: { $regex: ?0, $options: 'i' } }")
	List<Post> searchTitle(String texto);
	
	List<Post> findByTitleContainingIgnoreCase(String texto);
	
	@Query("{ $and: [ { data: {$gte: ?1} }, { data: { $lte: ?2} } , { $or: [ { 'title': { $regex: ?0, $options: 'i' } }, { 'corpo': { $regex: ?0, $options: 'i' } }, { 'comentarios.texto': { $regex: ?0, $options: 'i' } } ] } ] }")
	List<Post> fullSearch(String texto, Date minDate, Date maxDate);

}
