package br.com.sysmap.parrot.service;

import java.util.UUID;

import br.com.sysmap.parrot.model.Usuario;

public interface UsuarioService {

    Usuario salvar(Usuario usuario);

    Usuario buscarPorId(UUID id);

    Usuario buscarPorEmail(String email);

    Usuario atualizar(UUID id, Usuario usuario);

    void deletar(UUID id);
}