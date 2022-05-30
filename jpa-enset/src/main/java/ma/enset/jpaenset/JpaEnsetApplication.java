package ma.enset.jpaenset;

import ma.enset.jpaenset.entities.Role;
import ma.enset.jpaenset.entities.User;
import ma.enset.jpaenset.srvices.IUserService;
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
    CommandLineRunner start(IUserService iUserService){
        return args -> {
            User u1=new User();
            u1.setUsername("user1");
            u1.setPassword("123456");
            iUserService.addNewUser(u1);

            User u2=new User();
            u2.setUsername("admin");
            u2.setPassword("123456");
            iUserService.addNewUser(u2);

            Stream.of("student","user","admin","visitor").forEach(r->{
                Role role1 =new Role();
                role1.setRolename(r);
                iUserService.addRole(role1);

            });

           iUserService.addRoleTOUser("user1","student");
            iUserService.addRoleTOUser("user1","user");
            iUserService.addRoleTOUser("admin","admin");
             iUserService.addRoleTOUser("admin","visitor");


             try{
                 User user=iUserService.authentificate("user1","123456");
                 System.out.println(user.getUserid());
                 System.out.println(user.getUsername());
                 System.out.println("Roles=>");
                 user.getRoles().forEach(r->{
                     System.out.println("role : "+r.getRolename());
                 });
             }catch (Exception e){
                 e.printStackTrace();

             }


        };
    }

}
