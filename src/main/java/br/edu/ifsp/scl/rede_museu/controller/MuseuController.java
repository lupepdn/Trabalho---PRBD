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

import br.edu.ifsp.scl.rede_museu.model.dao.MuseuDAO;
import br.edu.ifsp.scl.rede_museu.model.domain.Museu;

@RestController
@RequestMapping("/museus")
public class MuseuController {

    @Autowired
    private MuseuDAO dao;

    @GetMapping("/listar")
    public List<Museu> getMuseus(){
        return dao.findAll();
    }

    @GetMapping("/listar/{id}")
    public Museu getMuseu(@PathVariable("id") Long id){
        Museu p = null;

        if ( dao.existsById(id) ){
            p = dao.findById(id).get();
        }

        return p;
    }

    @PostMapping("/inserir/")
    public Museu inserirMuseu(@RequestBody Museu museu){
        return dao.save(museu);
    }
    /*
    @PutMapping("/alterar/{id}")
    public Museu alterarMuseu(@PathVariable("id") Long id, @RequestBody Museu museu){
        Museu m=dao.findById(id).get();
        m.setNome(museu.getNome());
        m.setLogradouro(museu.getLogradouro());
        m.setNumero(museu.getNumero());
        m.setCep(museu.getCep());
        m.setDescricao(museu.getDescricao());
        return dao.save(m);
    }
    */
    @PutMapping("/alterar/")
    public Museu alterarMuseu(@RequestBody Museu museu){
        return dao.save(museu);
    }
    @DeleteMapping("/deletar/{id}")
    public String deletarMuseu(@PathVariable("id") Long id){
        dao.deleteById(id);
        return "Museu deletado com sucesso!";
    }
}