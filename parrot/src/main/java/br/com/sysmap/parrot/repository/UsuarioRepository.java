package br.com.sysmap.parrot.repository;

import java.util.UUID;

import org.springframework.data.mongodb.repository.MongoRepository;

import br.com.sysmap.parrot.model.Usuario;

public interface UsuarioRepository  extends MongoRepository<Usuario, UUID>{

    void findByEmail(String email);

    
}