package com.workshop.workshopmongo.config;

import com.workshop.workshopmongo.domain.User;
import com.workshop.workshopmongo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import java.util.Arrays;
@Configuration
public class Instantion implements CommandLineRunner {
    @Autowired
    UserRepository userRepository;
    @Override
    public void run(String... args) throws Exception {
        userRepository.deleteAll();
        User user1 = new User(null, "Rafinha", "rafinha_bolado@gmail");
        User user2 = new User(null, "Satoru Gojo", "gojo_sensei@gmail");
        User user3 = new User(null, "Itadori Iuji", "itadori@gmail");
        userRepository.saveAll(Arrays.asList(user1, user2, user3));

    }
}
