package com.barbararibeiro.workshopmongo.resources;

import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

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

	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public ResponseEntity<UsuarioDTO> findById(@PathVariable String id) {
		Usuario obj = servico.findById(id);
		return ResponseEntity.ok().body(new UsuarioDTO(obj));

	}
	@RequestMapping(method = RequestMethod.POST)
	public ResponseEntity<Void> insert(@RequestBody UsuarioDTO objDto) {
	Usuario obj = servico.fromDTO(objDto);
	obj = servico.insert(obj);
	URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getId()).toUri();
	return ResponseEntity.created(uri).build();
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<Void> delete(@PathVariable String id) {
		servico.delete(id);
		return ResponseEntity.noContent().build();
	}
}