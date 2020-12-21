package com.sucit.afm.entity;

import com.fasterxml.jackson.annotation.*;
import lombok.Data;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "dispositivo_funcional")
@Data
@JsonRootName(value = "dispositivo_funcional")
@JsonInclude(JsonInclude.Include.NON_NULL)
public class DispositivoFuncional {
    @Id
    @JsonIdentityInfo(
            generator = ObjectIdGenerators.PropertyGenerator.class,
            property = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String numero;
    private String imei;
    private String status;
    private String nick;
    @OneToMany(mappedBy = "dispositivoFuncional",
                cascade = {CascadeType.PERSIST, CascadeType.MERGE,
                            CascadeType.DETACH, CascadeType.REFRESH})
    @JsonIgnore
    private List<Usuario> usuarios;


}
