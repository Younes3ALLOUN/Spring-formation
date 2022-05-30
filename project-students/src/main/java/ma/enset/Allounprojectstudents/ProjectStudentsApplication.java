package ma.enset.Allounprojectstudents;

import ma.enset.Allounprojectstudents.entities.Genre;
import ma.enset.Allounprojectstudents.entities.Student;
import ma.enset.Allounprojectstudents.repositories.StudentRepository;
import ma.enset.Allounprojectstudents.security.services.SecurityService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.Date;

@SpringBootApplication
public class ProjectStudentsApplication {

    public static void main(String[] args) {
        SpringApplication.run(ProjectStudentsApplication.class, args);
    }


    @Bean
    PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }

    //@Bean
    CommandLineRunner commandLineRunner(StudentRepository studentRepository){
        return args -> {
                for (int i = 0; i < 10; i++) {
                Student student=new Student(null,"younes","alloun","younesallon@gmail.com",new Date(), Genre.Male,true);
                studentRepository.save(student);
                Student student1=new Student(null,"amal","salmi","amal@gmail.com",new Date(), Genre.Female,true);
                studentRepository.save(student1);
                Student student2=new Student(null,"hamza","eshaymi","hamza@gmail.com",new Date(), Genre.Male,false);
                studentRepository.save(student2);
                Student student3=new Student(null,"khadija","mansouri","khadija@gmail.com",new Date(), Genre.Female,true);
                studentRepository.save(student3);
            }

        };
    }
    //@Bean
    CommandLineRunner saveUser(SecurityService securityService){
        return args -> {
            securityService.saveNewUser("amine","1234","1234");
            securityService.saveNewUser("ahmed","1234","1234");
            securityService.saveNewUser("younes","1234","1234");
            securityService.saveNewRole("USER","");
            securityService.saveNewRole("ADMIN","");

            securityService.addRoleToUser("amine","USER");
            securityService.addRoleToUser("younes","ADMIN");
            securityService.addRoleToUser("ahmed","USER");
            securityService.addRoleToUser("younes","USER");
        };
    }

}
