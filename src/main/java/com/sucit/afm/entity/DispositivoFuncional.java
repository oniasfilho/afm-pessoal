package com.sucit.afm.entity;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIdentityReference;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import lombok.Data;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "dispositivo_funcional")
@JsonIdentityInfo( scope = DispositivoFuncional.class, generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")
@Data
@DynamicUpdate
public class DispositivoFuncional {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String numero;
    private String imei;
    private String status;
    private String nick;
    @OneToMany(mappedBy = "dispositivoFuncional",
                cascade = {CascadeType.PERSIST, CascadeType.MERGE,
                            CascadeType.DETACH, CascadeType.REFRESH})
    @JsonIdentityReference(alwaysAsId = true)
    private List<Usuario> usuarios;


}
