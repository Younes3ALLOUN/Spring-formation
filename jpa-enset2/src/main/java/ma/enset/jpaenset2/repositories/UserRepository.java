package ma.enset.jpaenset2.repositories;

import ma.enset.jpaenset2.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User,String> {
    User findUserByUsername(String username);
}
