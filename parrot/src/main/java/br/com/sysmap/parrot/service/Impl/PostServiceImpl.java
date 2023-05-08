package br.com.sysmap.parrot.service.Impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.sysmap.parrot.model.Post;
import br.com.sysmap.parrot.repository.PostRepository;
import br.com.sysmap.parrot.repository.UsuarioRepository;
import br.com.sysmap.parrot.service.PostService;

@Service
public class PostServiceImpl implements PostService {

    @Autowired
    private PostRepository postRepository;


    @Override
    public Post salvar(Post post) {
        return postRepository.save(post);
    }

    @Override
    public Post buscarPorId(String id) {
        return postRepository.findById(id).get();
    }


    @Override
    public Post atualizar(String id, Post post) {
      Optional<Post> _post = postRepository.findById(id);
        if(!_post.isPresent()) {
            throw new RuntimeException("Post não encontrado");
        }
        _post.get().setTexto(post.getTexto());
      return postRepository.save(_post.get());
    }

    @Override
    public void deletar(String id) {
       postRepository.deleteById(id);
    }

    @Override
    public List<Post> buscarTodos(String idUsuario) {
     
        return postRepository.findAllByIdUsuario(idUsuario);
    }
    

}