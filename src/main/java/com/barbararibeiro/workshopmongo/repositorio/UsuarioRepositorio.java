package com.barbararibeiro.workshopmongo.repositorio;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.barbararibeiro.workshopmongo.domain.Usuario;

@Repository
public interface UsuarioRepositorio extends MongoRepository<Usuario, String>{


}
