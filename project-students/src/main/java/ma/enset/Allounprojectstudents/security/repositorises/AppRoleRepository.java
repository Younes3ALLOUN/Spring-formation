package ma.enset.Allounprojectstudents.security.repositorises;


import ma.enset.Allounprojectstudents.security.entities.AppRole;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AppRoleRepository extends JpaRepository<AppRole,Long> {
    AppRole findByRolename(String rolename);
}
