package com.barbararibeiro.workshopmongo.servico;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.barbararibeiro.workshopmongo.domain.Post;
import com.barbararibeiro.workshopmongo.repositorio.PostRepositorio;
import com.barbararibeiro.workshopmongo.servico.exception.ObjectNotFoundException;

@Service
public class PostServico {

	@Autowired
	private PostRepositorio repo;

	public Post findById(String id) {
		Optional<Post> obj = repo.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado"));
	}
	
	public List<Post> findByTitle(String texto){
		return repo.findByTitleContainingIgnoreCase(texto);
	}

}
