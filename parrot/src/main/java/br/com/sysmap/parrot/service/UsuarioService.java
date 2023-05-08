package br.com.sysmap.parrot.service;

import java.util.UUID;

import br.com.sysmap.parrot.model.Usuario;

public interface UsuarioService {

    Usuario salvar(Usuario usuario);

    Usuario buscarPorId(String id);

    Usuario buscarPorEmail(String email);

    Usuario atualizar(String id, Usuario usuario);

    void deletar(String id);
}