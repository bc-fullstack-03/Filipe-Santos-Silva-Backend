package br.com.sysmap.parrot.service;

import java.util.UUID;

import br.com.sysmap.parrot.model.Comentario;

public interface ComentarioService {

    Comentario salvar(Comentario comentario);

    Comentario buscarPorId(UUID id);

    Comentario atualizar(UUID id, Comentario comentario);

    void deletar(UUID id);

}