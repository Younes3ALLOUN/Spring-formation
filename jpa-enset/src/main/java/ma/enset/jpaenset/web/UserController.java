package ma.enset.jpaenset.web;

import ma.enset.jpaenset.entities.User;
import ma.enset.jpaenset.srvices.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import javax.websocket.server.PathParam;
@RestController
public class UserController {
    @Autowired
    private IUserService iUserService;
    @GetMapping("/users/{username}")
    public User user(@PathVariable String username){
        User user=iUserService.findUserByUserName(username);
        return user;

    }
}
