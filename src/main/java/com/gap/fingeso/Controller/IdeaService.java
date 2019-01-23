package com.gap.fingeso.Controller;

import com.gap.fingeso.Model.Idea;
import com.gap.fingeso.Repository.IdeaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import org.bson.types.ObjectId;

import java.util.List;


@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping(value = "/ideas")
public class IdeaService {


    @Autowired
    private IdeaRepository ideaRepository;

    //******************INDEX*****************************
    @CrossOrigin(origins = "http://localhost:4200")
    @ResponseBody
    @GetMapping("")
    public List<Idea> index()
    {
        return ideaRepository.findAll();
    }


    //******************CREATE******************************
    @CrossOrigin(origins = "http://localhost:4200")
    @ResponseBody
    @RequestMapping(value = "/create", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
    public void create(@RequestBody Idea idea)
    {
        ideaRepository.save(idea);
    }

    //******************SHOW**********************************
    @CrossOrigin(origins = "http://localhost:4200")
    @ResponseBody
    @RequestMapping(value = "/{id}")
    public Idea read(@PathVariable String id) {
        return ideaRepository.findIdeaById(id);
    }

    //*****************UPDATE*********************************
    @CrossOrigin(origins = "http://localhost:4200")
    @ResponseBody
    @RequestMapping(method = RequestMethod.PUT, consumes = MediaType.APPLICATION_JSON_VALUE)
    public void update(@RequestBody Idea idea) {
        ideaRepository.save(idea);
    }

    //*****************DELETE**********************************
    @CrossOrigin(origins = "http://localhost:4200")
    @ResponseBody
    @RequestMapping(value = "/delete/{id}", method = RequestMethod.DELETE)
    public void delete(@PathVariable ("id") String id)
    {
        Idea idea = ideaRepository.findIdeaById(id);
        ideaRepository.delete(idea);
    }
}
