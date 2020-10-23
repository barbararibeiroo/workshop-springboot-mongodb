package com.barbararibeiro.workshopmongo.servico;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.barbararibeiro.workshopmongo.DTO.UsuarioDTO;
import com.barbararibeiro.workshopmongo.domain.Usuario;
import com.barbararibeiro.workshopmongo.repositorio.UsuarioRepositorio;
import com.barbararibeiro.workshopmongo.servico.exception.ObjectNotFoundException;

@Service
public class UsuarioServico {

	@Autowired
	private UsuarioRepositorio repo;

	public List<Usuario> findAll() {
		return repo.findAll();
	}

	public Usuario findById(String id) {
		Optional<Usuario> obj = repo.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado"));
	}
	public Usuario insert(Usuario obj) {
		return repo.insert(obj);
	}
	public Usuario fromDTO(UsuarioDTO objDto) {
		return new Usuario(objDto.getId(), objDto.getNome(), objDto.getEmail());
	}
}
