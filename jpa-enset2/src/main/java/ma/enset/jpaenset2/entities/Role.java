package ma.enset.jpaenset2.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
@Entity
@Data @AllArgsConstructor @NoArgsConstructor
public class Role {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long roleid;
    @Column(name = "DESCRIPTION",length = 50)
    private String desc;
    @Column(unique = true)
    private String rolename;
    @ManyToMany(mappedBy = "roles", fetch = FetchType.EAGER)
    private List<User> users=new ArrayList<>();
}
