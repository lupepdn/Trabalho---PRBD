package br.edu.ifsp.scl.rede_museu.model.domain;

import java.time.LocalDate;
import java.util.List;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.DateTimeFormat.ISO;

//import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
//import jakarta.persistence.OneToOne;

@Entity
public class Exposicao{
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long id;

    @Column(length=200, nullable=false)
    private String titulo;

    private String descricao;

    @DateTimeFormat(iso=ISO.DATE)
    @Column(columnDefinition="DATE", nullable=false)
    private LocalDate data_inicio;

    @DateTimeFormat(iso=ISO.DATE)
    @Column(columnDefinition="DATE", nullable=false)
    private LocalDate data_termino;

    @ManyToOne
    @JoinColumn(name="id_curador")
    private Curador curador;

    @ManyToOne
    @JoinColumn(name="id_museu")
    private Museu museu;

    /*@OneToMany(mappedBy="exposicao")*///VER ISSO
    //@OneToMany(mappedBy="exposicao")
    //private List<Obra> obras;

    /*public List<Obra> getObras() {
        return obras;
    }

    public void setObras(List<Obra> obras) {
        this.obras = obras;
    }*/

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public LocalDate getData_inicio() {
        return data_inicio;
    }

    public void setData_inicio(LocalDate data_inicio) {
        this.data_inicio = data_inicio;
    }

    public LocalDate getData_termino() {
        return data_termino;
    }

    public void setData_termino(LocalDate data_termino) {
        this.data_termino = data_termino;
    }

    public Curador getCurador() {
        return curador;
    }

    public void setCurador(Curador curador) {
        this.curador = curador;
    }

    public Museu getMuseu() {
        return museu;
    }

    public void setMuseu(Museu museu) {
        this.museu = museu;
    }

    
}