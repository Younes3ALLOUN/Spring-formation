package ma.enset.Allounprojectstudents.security.services;


import ma.enset.Allounprojectstudents.security.entities.AppRole;
import ma.enset.Allounprojectstudents.security.entities.AppUser;

public interface SecurityService {
    AppUser saveNewUser(String username, String password, String rePassword);
    AppRole saveNewRole(String rolename, String desciption);
    void addRoleToUser(String username,String rolename);
    void removeRoleFromUser(String username,String rolename);
    AppUser laodByUUsername(String username);

}
