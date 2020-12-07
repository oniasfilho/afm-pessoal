package com.sucit.afm.entity;

import com.fasterxml.jackson.annotation.*;
import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;


@Entity
@Table(name = "usuario")
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")
@Data
public class Usuario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String cpf;
    private String nome;
    private String email;
    @Column(name="data_de_criacao", nullable = false, updatable = false)
    @JsonFormat(pattern="dd/MM/yyyy")
    @CreationTimestamp
    private LocalDate dataDeCriacao;
    @Column(name = "ultima_atualizacao")
    @JsonFormat(pattern="dd/MM/yyyy HH:mm" , locale = "pt-BR", timezone = "Brazil/East")
    @UpdateTimestamp
    private LocalDateTime ultimaAtualizacao;
    private String status;
    @ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.PERSIST)
    @JoinTable(
            name = "dispositivo_usuario",
            joinColumns = @JoinColumn(name = "usuario_id"),
            inverseJoinColumns = @JoinColumn(name = "dispositivo_id")
    )
    @JsonIdentityReference(alwaysAsId = true)
    private List<Dispositivo> dispositivos;


    public void addDispositivo(Dispositivo dispositivo){
        if(this.dispositivos == null){
            dispositivos = new ArrayList<>();
        }
        dispositivos.add(dispositivo);
    }

    public Usuario() {

    }


}
