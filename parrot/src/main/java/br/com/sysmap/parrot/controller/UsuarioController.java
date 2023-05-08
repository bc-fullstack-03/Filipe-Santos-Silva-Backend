package br.com.sysmap.parrot.controller;

import java.util.UUID;

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
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.sysmap.parrot.model.Usuario;
import br.com.sysmap.parrot.model.DTO.UsuarioForm;
import br.com.sysmap.parrot.model.DTO.UsuarioResposta;
import br.com.sysmap.parrot.service.Impl.UsuarioServiceImpl;


@RestController
@RequestMapping("api/v1/usuario")
public class UsuarioController {
    
    @Autowired
    private ModelMapper modelMapper;

    @Autowired
    private UsuarioServiceImpl usuarioServiceImpl;


    Logger log = LoggerFactory.getLogger(UsuarioController.class);


    @PostMapping
    public ResponseEntity<UsuarioResposta> salvar(@RequestBody UsuarioForm usuarioForm) {

        log.info("Salvando usuario");

        Usuario usuario = convertToEntity(usuarioForm);
        usuarioServiceImpl.salvar(usuario);
        return ResponseEntity.status(HttpStatus.CREATED).body(convertToResposta(usuario)); 
        
    }

    @GetMapping({"/{id}"})
    public ResponseEntity<UsuarioResposta> buscarPorId(@PathVariable UUID id) {
        log.info("Buscando usuario por id");
        Usuario usuario = usuarioServiceImpl.buscarPorId(id);
        return ResponseEntity.ok(convertToResposta(usuario));
    }

    @GetMapping({"/{email}"})
    public ResponseEntity<UsuarioResposta> buscarPorEmail(@PathVariable String email) {
        log.info("Buscando usuario por email");
        Usuario usuario = usuarioServiceImpl.buscarPorEmail(email);
        return ResponseEntity.ok(convertToResposta(usuario));
    }

    @PutMapping({"/{id}"})
    public ResponseEntity<UsuarioResposta> atualizar(@PathVariable UUID id, @RequestBody UsuarioForm usuarioForm) {
        log.info("Atualizando usuario");
        Usuario usuario = convertToEntity(usuarioForm);
        usuarioServiceImpl.atualizar(id, usuario);
        return ResponseEntity.ok(convertToResposta(usuario));
    }

    @DeleteMapping({"/{id}"})
    public ResponseEntity deletar(@PathVariable UUID id) {
        log.info("Deletando usuario");
        usuarioServiceImpl.deletar(id);
        return ResponseEntity.noContent().build();
    }
      


  




    //metodo para converter DTO request na entidade Usuario
    private Usuario convertToEntity(UsuarioForm dadosUserForm) {
        return modelMapper.map(dadosUserForm, Usuario.class);

    }


    // metodo para converter entidade Usuario em DTO response
    private UsuarioResposta convertToResposta(Usuario usuario) {
        return modelMapper.map(usuario, UsuarioResposta.class);
    }


















}