package br.edu.ifsp.scl.rede_museu.model.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class Obra{
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long id;

    @Column(nullable=false)
    private String titulo;

    @Column(nullable=false)
    private int ano;

    @Column(nullable=false, length=120) 
    private String movimento;

    @Column(nullable=false, length=80)
    private String designacao;

    @Column(nullable=false)
    private double altura;

    @Column(nullable=false)
    private double comprimento;
    
    private Double profundidade;//Nullable, pois não se mede a profundidade de pinturas, por exemplo.

    /*@ManyToOne
    @JoinColumn(name="id_artista")
    private Artista artista;*/
    /*@ManyToOne
    @JoinColumn(name = "id_artista")
    @JsonIgnore 
    private Artista artista;

    public Artista getArtista() {
        return artista;
    }

    public void setArtista(Artista artista) {
        this.artista = artista;
    }*/
    
    
    @Column(length = 150, nullable = false)
    private String artista;
    

    public String getArtista() {
        return artista;
    }

    public void setArtista(String artista) {
        this.artista = artista;
    }

    @ManyToOne 
    @JoinColumn (name = "id_exposicao")
    private Exposicao exposicao;

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

    public int getAno() {
        return ano;
    }

    public void setAno(int ano) {
        this.ano = ano;
    }

    public String getMovimento() {
        return movimento;
    }

    public void setMovimento(String movimento) {
        this.movimento = movimento;
    }

    public String getDesignacao() {
        return designacao;
    }

    public void setDesignacao(String designacao) {
        this.designacao = designacao;
    }

    public double getAltura() {
        return altura;
    }

    public void setAltura(double altura) {
        this.altura = altura;
    }

    public double getComprimento() {
        return comprimento;
    }

    public void setComprimento(double comprimento) {
        this.comprimento = comprimento;
    }

    public double getProfundidade() {
        return profundidade;
    }

    public void setProfundidade(Double profundidade) {
        this.profundidade = profundidade;
    }

    /*public Artista getArtista() {
        return artista;
    }

    public void setArtista(Artista artista) {
        this.artista = artista;
    }*/

    /*public Exposicao getExposicao() {
        return exposicao;
    }

    public void setExposicao(Exposicao exposicao) {
        this.exposicao = exposicao;
    }*/


}