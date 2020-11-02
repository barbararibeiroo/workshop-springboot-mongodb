package com.barbararibeiro.workshopmongo.servico;

import java.util.Date;
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
		return repo.searchTitle(texto);
	}
	public List<Post> fullSearch(String texto, Date minDate, Date maxDate){
		//ACRESCENTANDO MAIS UM DIA NA DATA MÁXIMA
		maxDate = new Date(maxDate.getTime() + 24 * 60 * 60 * 1000);
		return repo.fullSearch(texto, minDate, maxDate);
	}
}
