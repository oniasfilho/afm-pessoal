package com.sucit.afm.entity;

import com.fasterxml.jackson.annotation.*;
import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "dispositivo")
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class , property = "id")
@Data
public class Dispositivo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String numero;
    private String imei;
    private String tipo;
    private String status;
    private String nick;
    @ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinTable(
            name = "dispositivo_usuario",
            joinColumns = @JoinColumn(name = "dispositivo_id"),
            inverseJoinColumns = @JoinColumn(name = "usuario_id")
    )
    @JsonIdentityReference(alwaysAsId = true)
    private List<Usuario> usuarios;




}
