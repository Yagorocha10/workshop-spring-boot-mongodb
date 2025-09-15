package com.aprendendo.workshopmongo.config;

import com.aprendendo.workshopmongo.domain.Post;
import com.aprendendo.workshopmongo.domain.User;
import com.aprendendo.workshopmongo.dto.AuthorDTO;
import com.aprendendo.workshopmongo.repository.PostRepository;
import com.aprendendo.workshopmongo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.TimeZone;

@Configuration
public class Instatiation implements CommandLineRunner {

    @Autowired
    private PostRepository postRepository;

    @Autowired
    private UserRepository userRepository;

    @Override
    public void run(String... args) throws Exception {

        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        sdf.setTimeZone(TimeZone.getTimeZone("GMT"));


        userRepository.deleteAll();
        postRepository.deleteAll();

        User maria = new User(null, "Maria brown", "maria@gmail.com");
        User alex = new User(null, "Alex green", "alex@gmail.com");
        User bob = new User(null, "Bob grey", "bob@gmail.com");

        userRepository.saveAll(Arrays.asList(maria, alex, bob));

        Post post1 = new Post(null, sdf.parse("21/03/2018"), "Partiu viagem!", "Vou viajar para São paulo. Abraços!", new AuthorDTO(maria));
        Post post2 = new Post(null, sdf.parse("23/03/2018"), "Bom dia", "Acordei feliz hoje!", new AuthorDTO(maria));


        userRepository.saveAll(Arrays.asList(maria, alex, bob));
        postRepository.saveAll(Arrays.asList(post1, post2));




    }
}
