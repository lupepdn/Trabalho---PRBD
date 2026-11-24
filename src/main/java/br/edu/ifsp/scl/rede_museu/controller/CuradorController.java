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

import br.edu.ifsp.scl.rede_museu.model.dao.CuradorDAO;
import br.edu.ifsp.scl.rede_museu.model.domain.Curador;


@RestController
@RequestMapping("/curadores")
public class CuradorController {
    @Autowired
    private CuradorDAO dao;

    @GetMapping("/listar")
    public List<Curador> getCuradores(){
        return dao.findAll();
    }

    @GetMapping("/listar/{id}")
    public Curador getCurador(@PathVariable("id") Long id){
        Curador p = null;

        if ( dao.existsById(id) ){
            p = dao.findById(id).get();
        }

        return p;
    }

    @PostMapping("/inserir/")
    public Curador inserirCurador(@RequestBody Curador curador){
        return dao.save(curador);
    }
    /*
    @PutMapping("/alterar/{id}")
    public Curador alterarCurador(@PathVariable("id") Long id, @RequestBody Curador curador){
        Curador c=dao.findById(id).get();
        c.setNome(curador.getNome());
        c.setSalario(curador.getSalario());
        c.setFormacao(curador.getFormacao());
        return dao.save(c);
    }
    */
    @PutMapping("/alterar/")
    public Curador alterarCurador(@RequestBody Curador curador){
        return dao.save(curador);
    }
    @DeleteMapping("/deletar/{id}")
    public String deletarCurador(@PathVariable("id") Long id){
        dao.deleteById(id);
        return "Curador deletado com sucesso!";
    }
}