package br.com.sysmap.parrot.model;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Document(collection = "usuario")
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Usuario {

    @Id
    private UUID id;
    private String nome;
    private String email;
    private String senha;
    private List<Post> feed = new ArrayList<>();
    private List<UUID> amigos = new ArrayList<>();

    protected void setId() {
        this.id = UUID.randomUUID();
    }

}