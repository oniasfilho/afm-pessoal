package com.sucit.afm.entity;

import com.fasterxml.jackson.annotation.*;
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
    @ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
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

    public Usuario(String cpf, String nome, String email, String status,List<Dispositivo> dispositivos) {
        this.cpf = cpf;
        this.nome = nome;
        this.email = email;
        this.status = status;
        this.dispositivos = dispositivos;
    }

    @Override
    public String toString() {
        return "Usuario{" +
                "id=" + id +
                ", cpf='" + cpf + '\'' +
                ", nome='" + nome + '\'' +
                ", email='" + email + '\'' +
                ", dataDeCriacao=" + dataDeCriacao +
                ", ultimaAtualizacao=" + ultimaAtualizacao +
                ", status='" + status + '\'' +
                ", dispositivos=" + dispositivos +
                '}';
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public LocalDate getDataDeCriacao() {
        return dataDeCriacao;
    }

    public LocalDateTime getUltimaAtualizacao() {
        return ultimaAtualizacao;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public List<Dispositivo> getDispositivos() {
        return dispositivos;
    }

    public void setDispositivos(List<Dispositivo> dispositivos) {
        this.dispositivos = dispositivos;
    }
}
