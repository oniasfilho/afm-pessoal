package com.sucit.afm.entity;

import com.fasterxml.jackson.annotation.*;
import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.DynamicUpdate;
import org.hibernate.annotations.UpdateTimestamp;
import org.springframework.data.rest.core.annotation.RestResource;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "usuario")
@JsonIdentityInfo(scope = Usuario.class, generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")
@Data
@DynamicUpdate
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
    private String lotacao;
    @JsonIdentityReference(alwaysAsId = true)
    @OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name="dispositivo_pessoal")
    private DispositivoPessoal dispositivoPessoal;
    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinColumn(name = "dispositivo_funcional")
//    @JsonIdentityReference(alwaysAsId = true)
    private DispositivoFuncional dispositivoFuncional;
}
