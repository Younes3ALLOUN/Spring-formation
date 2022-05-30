
package ma.enset.Allounprojectstudents.security.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data @AllArgsConstructor @NoArgsConstructor
public class AppRole {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long roleid;
    @Column(unique = true)
    private String rolename;
    private String descriprion;
   /* @ManyToMany(mappedBy = "appRoles",fetch = FetchType.LAZY)
    private List<AppUser> appUsers=new ArrayList<>();*/
}
