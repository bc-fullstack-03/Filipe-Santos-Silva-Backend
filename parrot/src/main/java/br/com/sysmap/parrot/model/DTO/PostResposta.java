package br.com.sysmap.parrot.model.DTO;

import java.util.List;
import java.util.UUID;

import br.com.sysmap.parrot.model.Comentario;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class PostResposta {

 
    private UUID idUsuario;
    private String texto;
    private List<UUID> curtidas;
    private List<Comentario> comentarios;
    
}