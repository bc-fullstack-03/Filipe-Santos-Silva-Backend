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
public class ComentarioResposta {

    private String idUsuario; // que realiza o comentario
    private String texto;

}