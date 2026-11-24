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

import br.edu.ifsp.scl.rede_museu.model.dao.PremioDAO;
import br.edu.ifsp.scl.rede_museu.model.domain.Premio;

@RestController
@RequestMapping("/premios")
public class PremioController {

    @Autowired
    private PremioDAO dao;

    @GetMapping("/listar")
    public List<Premio> getPremios(){
        return dao.findAll();
    }

    @GetMapping("/listar/{id}")
    public Premio getPremio(@PathVariable("id") Long id){
        Premio p = null;

        if ( dao.existsById(id) ){
            p = dao.findById(id).get();
        }

        return p;
    }

    @PostMapping("/inserir/")
    public Premio inserirMuseu(@RequestBody Premio premio){
        return dao.save(premio);
    }
    /*
    @PutMapping("/alterar/{id}")
    public Premio alterarPremio(@PathVariable("id") Long id, @RequestBody Premio premio){
        Premio p=dao.findById(id).get();
        p.setTitulo(premio.getTitulo());
        p.setAno(premio.getAno());
        p.setHonorifico(premio.getHonorifico());
        p.setExposicao(premio.getExposicao());
        return dao.save(p);
    }
    */
    @PutMapping("/alterar/")
    public Premio alterarPremio(@RequestBody Premio premio){
        return dao.save(premio);
    }
    @DeleteMapping("/deletar/{id}")
    public String deletarPremio(@PathVariable("id") Long id){
        dao.deleteById(id);
        return "Prêmio deletado com sucesso!";
    }
}