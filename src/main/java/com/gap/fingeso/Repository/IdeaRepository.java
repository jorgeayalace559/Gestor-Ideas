package com.gap.fingeso.Repository;

import com.gap.fingeso.Model.Idea;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface IdeaRepository extends MongoRepository<Idea, String> {
     Idea findIdeaById(String id);
     Idea findIdeaByUser(String usuario); //Debo cambiar parametro String a Usuario
}
