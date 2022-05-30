package ma.enset.jpaenset.repositories;

import ma.enset.jpaenset.entities.Role;
import ma.enset.jpaenset.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepository extends JpaRepository<Role,Long> {
    Role findByRolename(String rolename);
}
