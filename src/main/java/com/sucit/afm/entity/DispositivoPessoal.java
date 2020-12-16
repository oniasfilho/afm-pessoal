package com.sucit.afm.entity;

import com.fasterxml.jackson.annotation.*;
import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "dispositivo_pessoal")
@JsonIdentityInfo( scope = DispositivoPessoal.class , generator = ObjectIdGenerators.PropertyGenerator.class , property = "id")
@Data
public class DispositivoPessoal {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String numero;
    private String imei;
    private String status;
    private String nick;
}
