package com.barbararibeiro.workshopmongo.resources;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.barbararibeiro.workshopmongo.DTO.UsuarioDTO;
import com.barbararibeiro.workshopmongo.domain.Usuario;
import com.barbararibeiro.workshopmongo.servico.UsuarioServico;

@RestController
@RequestMapping(value = "/usuarios")
public class UsuarioResource {

	@Autowired
	private UsuarioServico servico;

	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<List<UsuarioDTO>> findAll() {
		List<Usuario> list = servico.findAll();
		List<UsuarioDTO> listDTO = list.stream().map(x -> new UsuarioDTO(x)).collect(Collectors.toList()); 
		return ResponseEntity.ok().body(listDTO);
	}

}
