package com.barbararibeiro.workshopmongo.config;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import com.barbararibeiro.workshopmongo.domain.Usuario;
import com.barbararibeiro.workshopmongo.repositorio.UsuarioRepositorio;

@Configuration
public class Instantiation implements CommandLineRunner {

	@Autowired
	private UsuarioRepositorio usuarioRepositorio;

	@Override
	public void run(String... args) throws Exception {
		
		usuarioRepositorio.deleteAll();
		
		Usuario maria = new Usuario(null, "Maria Brown", "maria@gmail.com");
		Usuario alex = new Usuario(null, "Alex Green", "alex@gmail.com");
		Usuario bob = new Usuario(null, "Bob Grey", "bob@gmail.com");
		
		usuarioRepositorio.saveAll(Arrays.asList(maria,alex,bob));
	}

}
