package br.com.sysmap.parrot.service;

import java.util.List;
import java.util.UUID;

import br.com.sysmap.parrot.model.Post;

public interface PostService {

    Post salvar(Post post);

    Post buscarPorId(String id);

    List<Post> buscarTodos(String idUsuario);


    Post atualizar(String id, Post post);

    void deletar(String id);

}