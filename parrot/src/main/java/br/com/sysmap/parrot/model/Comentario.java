package br.com.sysmap.parrot.model;

import java.util.UUID;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@Document(collection = "comentario")
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Comentario {


    @Id
    private UUID id;
    //@DBRef(lazy = true)
    //@JsonBackReference
    private UUID postId;
    private UUID usuarioId; // usuario que fez o comentario
    private String texto;

    protected void setId() { this.id = UUID.randomUUID(); }

}
