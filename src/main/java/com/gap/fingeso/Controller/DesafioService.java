package com.gap.fingeso.Controller;

import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.gap.fingeso.Model.Desafio;
import com.gap.fingeso.Model.Idea;
import com.gap.fingeso.Repository.DesafioRepository;
import com.gap.fingeso.Repository.IdeaRepository;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping(value = "/desafios")
public class DesafioService {
    @Autowired
    private DesafioRepository desafioRepository;
    @Autowired
    private IdeaRepository ideaRepository;


    //***********************INDEX**************************************
    @GetMapping(value = "/")
    @ResponseBody
    public List<Desafio> findAll(){return desafioRepository.findAll();}

    //***********************CREATE*************************************
    @PostMapping(value = "/create")
    @ResponseBody
    public Desafio create(@RequestBody Desafio resource){
        resource.setFecha(new Date());
        resource.setId("1");
        resource.setIdeas(new ArrayList<>());
        return desafioRepository.save(resource);
    }

    //************************AGREGAR IDEAS******************************
    @PutMapping("/{id}/addIdea")
    @ResponseBody
    public Desafio addIdea(@PathVariable String id, @RequestBody Idea idea){
        idea.setLikes(0);
        idea.setDate(new Date());
        idea.setId("5");
        ideaRepository.save(idea);
        Desafio desafio = desafioRepository.findById(id).orElse(null);
        if(desafio != null){
            List<Idea> ideas = desafio.getIdeas();
            ideas.add(idea);
            desafio.setIdeas(ideas);
            return desafioRepository.save(desafio);
        }
        return null;
    }
}
