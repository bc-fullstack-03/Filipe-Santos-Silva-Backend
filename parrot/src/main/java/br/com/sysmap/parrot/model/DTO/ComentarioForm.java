package br.com.sysmap.parrot.model.DTO;

import java.util.UUID;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ComentarioForm {

    private UUID idPost;
    private UUID idUsuario; // que realiza o comentario
    private String texto;
    
}