package com.gap.fingeso.Repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.web.bind.annotation.CrossOrigin;
import com.gap.fingeso.Model.Desafio;
@CrossOrigin(origins = "http://localhost:4200")
public interface DesafioRepository extends MongoRepository<Desafio, String> {
}
