package br.com.sysmap.parrot.controller;

import java.util.List;

import org.modelmapper.ModelMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.sysmap.parrot.model.Post;
import br.com.sysmap.parrot.model.DTO.PostForm;
import br.com.sysmap.parrot.model.DTO.PostResposta;
import br.com.sysmap.parrot.service.Impl.PostServiceImpl;
import jakarta.websocket.server.PathParam;

@RestController
@RequestMapping("api/v1/post")
public class PostController {

    @Autowired
    private ModelMapper modelMapper;

    @Autowired
    private PostServiceImpl postServiceImpl;


    Logger log = LoggerFactory.getLogger(PostController.class);



    @PostMapping
    public ResponseEntity<PostResposta> salvar(PostForm postForm) {

        log.info("Salvando post");

        Post post = convertToEntity(postForm);
        postServiceImpl.salvar(post);
        return ResponseEntity.status(HttpStatus.CREATED).body(convertToResposta(post)); 

    }


    @GetMapping({"/{id}"})
    public ResponseEntity<PostResposta> buscarPorId(@PathVariable String id) {
        log.info("Buscando post por id");
        Post post = postServiceImpl.buscarPorId(id);
        return ResponseEntity.ok(convertToResposta(post));
    }

    @GetMapping({"/{idUsuario}"})
    public List<PostResposta>buscarPorIdUsuario(@PathVariable String idUsuario) {
        log.info("Buscando post por idUsuario");
        List<Post> post = postServiceImpl.buscarTodos(idUsuario);
        return post.stream().map(this::convertToResposta).toList();
     
    }

    @DeleteMapping({"/{id}"})
    public ResponseEntity deletar(@PathVariable String id) {
        log.info("Deletando post por id");
        postServiceImpl.deletar(id);
        return ResponseEntity.noContent().build();
    }


    @PutMapping({"/{id}"})
    public ResponseEntity<PostResposta> atualizar(@PathVariable String id, PostForm postForm) {
        log.info("Atualizando post por id");
        Post post = convertToEntity(postForm);
        postServiceImpl.atualizar(id, post);
        return ResponseEntity.ok(convertToResposta(post));
    }



      //metodo para converter DTO request na entidade Usuario
      private Post convertToEntity(PostForm postForm) {
        return modelMapper.map(postForm, Post.class);

    }


    // metodo para converter entidade Usuario em DTO response
    private PostResposta convertToResposta(Post usuario) {
        return modelMapper.map(usuario, PostResposta.class);
    }


    
}