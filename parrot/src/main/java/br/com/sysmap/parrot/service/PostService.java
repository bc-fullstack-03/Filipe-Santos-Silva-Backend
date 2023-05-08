package br.com.sysmap.parrot.service;

import java.util.UUID;

import br.com.sysmap.parrot.model.Post;

public interface PostService {

    Post salvar(Post post);

    Post buscarPorId(UUID id);

    Post buscarPorEmail(String email);

    Post atualizar(UUID id, Post post);

    void deletar(UUID id);

}