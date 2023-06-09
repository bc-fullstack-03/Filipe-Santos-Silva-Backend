package br.com.sysmap.parrot.service.Impl;

import java.util.UUID;

import br.com.sysmap.parrot.model.Usuario;
import br.com.sysmap.parrot.repository.UsuarioRepository;
import br.com.sysmap.parrot.service.UsuarioService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UsuarioServiceImpl implements UsuarioService {

    @Autowired
    UsuarioRepository usuarioRepository;

    @Override
    public Usuario salvar(Usuario usuario) {
     
        usuarioRepository.save(usuario);
        return usuario;
    }

    @Override
    public Usuario buscarPorId(String id) {
        return usuarioRepository.findById(id).get();
    }

    @Override
    public Usuario buscarPorEmail(String email) {
        return usuarioRepository.findByEmail(email);
    }

    @Override
    public Usuario atualizar(String id, Usuario usuario) {
        Usuario usu = usuarioRepository.findById(id).get();
        usu.setNome(usuario.getNome());
        usu.setEmail(usuario.getEmail());
        usu.setSenha(usuario.getSenha());
        usuarioRepository.save(usu);
        return usu;
    }

    @Override
    public void deletar(String id) {
        usuarioRepository.deleteById(id);
    }

    

}