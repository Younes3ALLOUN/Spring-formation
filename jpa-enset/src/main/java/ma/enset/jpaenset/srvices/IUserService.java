package ma.enset.jpaenset.srvices;

import ma.enset.jpaenset.entities.Role;
import ma.enset.jpaenset.entities.User;

public interface IUserService {
    User addNewUser(User user);
    Role addRole (Role role);
    User findUserByUserName(String username);
    Role findUserByRoleName(String rolename);
    void addRoleTOUser(String username,String rolename);
    User authentificate(String username,String pswd);
}
