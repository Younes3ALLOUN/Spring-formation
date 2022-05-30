package ma.enset.jpaenset.srvices;

import ma.enset.jpaenset.entities.Role;
import ma.enset.jpaenset.entities.User;
import ma.enset.jpaenset.repositories.RoleRepository;
import ma.enset.jpaenset.repositories.UserRepository;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.UUID;

@Service
@Transactional
public class UserServiceImpl implements IUserService {
    private UserRepository userRepository;
    private RoleRepository roleRepository;

    public UserServiceImpl(UserRepository userRepository, RoleRepository roleRepository) {
        this.userRepository = userRepository;
        this.roleRepository = roleRepository;
    }

    @Override
    public User addNewUser(User user) {
        user.setUserid(UUID.randomUUID().toString());

        return userRepository.save(user);
    }

    @Override
    public Role addRole(Role role) {
        return roleRepository.save(role);
    }

    @Override
    public User findUserByUserName(String username) {
        return userRepository.findByUsername(username);
    }

    @Override
    public Role findUserByRoleName(String rolename) {
        return roleRepository.findByRolename(rolename);
    }

    @Override
    public void addRoleTOUser(String username, String rolename) {
        User user=findUserByUserName(username);
        Role role=findUserByRoleName(rolename);
        if(user.getRoles()!=null){
            user.getRoles().add(role);
            role.getUsers().add(user);
        }


    }

    @Override
    public User authentificate(String username, String pswd) {
        User user= userRepository.findByUsername(username);
        if(user==null) throw new RuntimeException("problem d'authentification");
        if(user.getPassword().equals(pswd)){
            return user;
        }
        throw new RuntimeException("problem d'authentification");
    }
}
