package org.enset.jpaenset;

import org.enset.jpaenset.entities.Role;
import org.enset.jpaenset.entities.User;
import org.enset.jpaenset.service.UserService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.stream.Stream;

@SpringBootApplication
public class JpaEnsetApplication {

    public static void main(String[] args) {
        SpringApplication.run(JpaEnsetApplication.class, args);
    }

    @Bean
    CommandLineRunner start(UserService userService){
        return args -> {
            User u=new User();
            u.setNom("ABDELGHANI");
            u.setUserName("NAIRI");
            u.setPassword("abdo2024");
            userService.addNewUser(u);

            User u2=new User();
            u2.setNom("soumia");
            u2.setUserName("admin");
            u2.setPassword("12345678");
            userService.addNewUser(u2);

            Stream.of("Student","Admin","User").forEach(r->{
                Role r1=new Role();
                r1.setRoleName(r);
                userService.addNewRole(r1);
            });

            userService.addRoleToUser("nairi","Student");
            userService.addRoleToUser("nairi","User");
            userService.addRoleToUser("admin","Admin");
            userService.addRoleToUser("admin","User");

            try{
                User user=userService.authenticate("nairi","abdo2024");
                System.out.println(user.getUserId());
                System.out.println(user.getUserName());
                System.out.println("Roles :");
                user.getRoles().forEach(r->{
                    System.out.println(r.getRoleName());
                });
            }
            catch (Exception e){
                e.printStackTrace();
            }
        };
    }

}
