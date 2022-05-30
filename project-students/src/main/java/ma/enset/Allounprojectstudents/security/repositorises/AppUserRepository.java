package ma.enset.Allounprojectstudents.security.repositorises;


import ma.enset.Allounprojectstudents.security.entities.AppUser;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AppUserRepository extends JpaRepository<AppUser,String> {
    AppUser findByUsername(String username);
}
