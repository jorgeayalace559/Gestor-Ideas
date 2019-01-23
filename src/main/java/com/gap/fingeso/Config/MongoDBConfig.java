package com.gap.fingeso.Config;

import com.gap.fingeso.Model.Idea;
import com.gap.fingeso.Repository.IdeaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

import java.util.Date;

@EnableMongoRepositories(basePackageClasses = IdeaRepository.class)
@Configuration
public class MongoDBConfig {
    //{
/*
   //@Bean
    CommandLineRunner commandLineRunner(UsuarioRepository usersRepository){
        return  strings -> {
            usersRepository.save(new Usuario(1, "Paty", 0));
            usersRepository.save(new Usuario(2, "Cris", 0));
            usersRepository.save(new Usuario(3, "Mauri", 0));
            usersRepository.save(new Usuario(4, "Persona", 1));
        };
    }
    */
    @Bean
    CommandLineRunner commandLineRunner( IdeaRepository ideasRepository) {

        Idea idea1 = new Idea("ceiocrjo",new Date());

        return strings -> {
            ideasRepository.save(idea1);
            ideasRepository.save(new Idea("perro",new Date()));
        };
    }
/*
  // @Bean
    CommandLineRunner commandLineRunner(RetosRepository retosRepository)
    {
        Usuario user1 = new Usuario(1, "Paty", 0);
        Usuario user2 = new Usuario(2, "Fernando", 0);
        Usuario user3 = new Usuario(3, "Cris", 1);
        Usuario user4 = new Usuario(4, "Mauri", 1);

        Comentario comentario1 = new Comentario(1, "Muy buena tu idea, estoy totalmente de acuerdo, te apoyo.", user1);
        Comentario comentario2 = new Comentario(2, "Sería bueno que agregaras el área en que va enfocado.", user2);
        Comentario comentario3 = new Comentario(3, "No me convence del todo.", user3);
        Comentario comentario4 = new Comentario(4, "Escribiste mal retos, pusiste restos.", user4);

        List<Comentario> listaComentarios = new ArrayList<>();
        listaComentarios.add(comentario1);
        listaComentarios.add(comentario2);
        listaComentarios.add(comentario3);
        listaComentarios.add(comentario4);



        List<Idea> listaIdeas = new ArrayList<>();
        listaIdeas.add(idea1);
        listaIdeas.add(idea2);
        listaIdeas.add(idea3);
        return strings -> {
            retosRepository.save(new Reto(1, "Titulo ejemplo en reto 1", "Este texto corresponde al ejemplo 1 de un reto.", "Área deInnovación en minería.", listaIdeas));
        };
    }
*/
//}
/*
    @Bean
    CommandLineRunner commandLineRunner(ComentariosRepository comentariosRepository)
    {
        Users user1 = new Users(1, "Paty", 0);
        Users user2 = new Users(2, "Fernando", 0);
        Users user3 = new Users(3, "Cris", 1);
        Users user4 = new Users(4, "Mauri", 1);

        return strings -> {
            comentariosRepository.save(new Comentarios(1, "Muy buena tu idea, estoy totalmente de acuerdo, te apoyo.", user1));
            comentariosRepository.save(new Comentarios(2, "Sería bueno que agregaras el área en que va enfocado.", user2));
            comentariosRepository.save(new Comentarios(3, "No me convence del todo.", user3));
            comentariosRepository.save(new Comentarios(4, "Escribiste mal retos, pusiste restos.", user4));        };
    }
}*/
}