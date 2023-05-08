package br.com.sysmap.parrot.model;

import java.util.List;
import java.util.UUID;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;




@Document(collection = "post")
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Post {

    @Id
    private UUID id;
    private UUID idUsuario;
    private String texto;
    private List<UUID> curtidas;
    private List<Comentario> comentarios;


    protected void setId() { this.id = UUID.randomUUID(); }

    
}