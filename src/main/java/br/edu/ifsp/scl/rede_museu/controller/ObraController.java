package br.edu.ifsp.scl.rede_museu.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.edu.ifsp.scl.rede_museu.model.dao.ObraDAO;
import br.edu.ifsp.scl.rede_museu.model.domain.Obra;


@RestController
@RequestMapping("/obras")
public class ObraController {

    @Autowired
    private ObraDAO dao;

    @GetMapping("/listar")
    public List<Obra> getObras(){
        /*List<Obra> a = dao.findAll();
        System.out.println(a.size());
        System.out.println(a.get(0).getTitulo());
        System.out.println(a.get(0).getArtista().getNome());
        System.out.println(a.get(1));
        return null;*/
        return dao.findAll();
    }

    @GetMapping("/listar/{id}")
    public Obra getObra(@PathVariable("id") Long id){
        Obra p = null;

        if ( dao.existsById(id) ){
            p = dao.findById(id).get();
        }

        return p;
    }

    @PostMapping("/inserir/")
    public Obra inserirObra(@RequestBody Obra obra){
        return dao.save(obra);
    }
    /*
    @PutMapping("/alterar/{id}")
    public Obra alterarObra(@PathVariable("id") Long id, @RequestBody Obra obra){
        Obra o=dao.findById(id).get();
        o.setTitulo(obra.getTitulo());
        o.setAno(obra.getAno());
        o.setDesignacao(obra.getDesignacao());
        o.setMovimento(obra.getMovimento());
        o.setComprimento(obra.getComprimento());
        o.setAltura(obra.getAltura());
        o.setProfundidade(obra.getProfundidade());
        o.setArtista(obra.getArtista());
        o.setExposicao(obra.getExposicao());
        return dao.save(o);
    }
    */
    @PutMapping("/alterar/")
    public Obra alterarObra(@RequestBody Obra obra){
        return dao.save(obra);
    }
    @DeleteMapping("/deletar/{id}")
    public String deletarObra(@PathVariable("id") Long id){
        dao.deleteById(id);
        return "Obra deletada com sucesso!";
    }
}