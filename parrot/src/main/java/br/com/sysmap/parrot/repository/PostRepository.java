package br.com.sysmap.parrot.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

import br.com.sysmap.parrot.model.Post;

public interface PostRepository  extends MongoRepository<Post,String>{

   List<Post> findAllByIdUsuario(String idUsuario);
    
}