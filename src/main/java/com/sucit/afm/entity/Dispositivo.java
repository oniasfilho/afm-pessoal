package com.sucit.afm.entity;

import com.fasterxml.jackson.annotation.*;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "dispositivo")
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class , property = "id")
public class Dispositivo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String numero;
    private String imei;
    private String tipo;
    private String status;
    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(
            name = "dispositivo_usuario",
            joinColumns = @JoinColumn(name = "dispositivo_id"),
            inverseJoinColumns = @JoinColumn(name = "usuario_id")
    )
    @JsonIdentityReference(alwaysAsId = true)
    private List<Usuario> usuarios;

    public Dispositivo() {

    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public String getImei() {
        return imei;
    }

    public void setImei(String imei) {
        this.imei = imei;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public List<Usuario> getUsuarios() {
        return usuarios;
    }

    public void setUsuarios(List<Usuario> usuarios) {
        this.usuarios = usuarios;
    }

    public Dispositivo(String numero, String imei, String tipo, String status) {
        this.numero = numero;
        this.imei = imei;
        this.tipo = tipo;
        this.status = status;
    }

    @Override
    public String toString() {
        return "Dispositivo{" +
                "id=" + id +
                ", numero='" + numero + '\'' +
                ", imei='" + imei + '\'' +
                ", tipo='" + tipo + '\'' +
                ", status='" + status + '\'' +
                '}';
    }
}
