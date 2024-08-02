package com.jpaexample;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import com.jpaexample.repository.UserRepository;
import com.jpaexample.entities.User;

@SpringBootApplication
public class BootjpaExampleApplication {

    public static void main(String[] args) {
        ApplicationContext context = SpringApplication.run(BootjpaExampleApplication.class, args);
        
        UserRepository userRepository = context.getBean(UserRepository.class);
        
        User Users = new User();
        Users.setId(1);
        Users.setName("Tejal kadam");
        Users.setCity("Pune");
        Users.setStatus("I am a Java programmer...");
        
        User savedUser = userRepository.save(Users);
        
        System.out.println(savedUser);
    }
}
