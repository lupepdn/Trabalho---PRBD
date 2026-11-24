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

import br.edu.ifsp.scl.rede_museu.model.dao.ExposicaoDAO;
import br.edu.ifsp.scl.rede_museu.model.domain.Exposicao;


@RestController
@RequestMapping("/exposicoes")
public class ExposicaoController {

    @Autowired
    private ExposicaoDAO dao;

    @GetMapping("/listar")
    public List<Exposicao> getExposicoes(){
        return dao.findAll();
    }

    @GetMapping("/listar/{id}")
    public Exposicao getExposicao(@PathVariable("id") Long id){
        Exposicao p = null;

        if ( dao.existsById(id) ){
            p = dao.findById(id).get();
        }

        return p;
    }

    @PostMapping("/inserir/")
    public Exposicao inserirExposicao(@RequestBody Exposicao exposicao){
        return dao.save(exposicao);
    }
    /*
    @PutMapping("/alterar/{id}")
    public Exposicao alterarExposicao(@PathVariable("id") Long id, @RequestBody Exposicao exposicao){
        Exposicao e=dao.findById(id).get();
        e.setTitulo(exposicao.getTitulo());
        e.setCurador(exposicao.getCurador());
        e.setDescricao(exposicao.getDescricao());
        e.setData_inicio(exposicao.getData_inicio());
        e.setData_termino(exposicao.getData_termino());
        e.setMuseu(exposicao.getMuseu());
        return dao.save(e);
    }
    */
    @PutMapping("/alterar/")
    public Exposicao alterarExposicao(@RequestBody Exposicao exposicao){
        return dao.save(exposicao);
    }
    @DeleteMapping("/deletar/{id}")
    public String deletarExposicao(@PathVariable("id") Long id){
        dao.deleteById(id);
        return "Exposição deletada com sucesso!";
    }
}