package ma.enset.jpaap.Entity;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;
@Entity @Data//ajouter les gitter et les setters
 @NoArgsConstructor// constructeur san parametrs
@AllArgsConstructor // avec parametres

public class Patient {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(length = 50)
    private String nom;
    @Temporal(TemporalType.DATE)// pour lire just la date et pas le temp
    private Date dateNaissance;
    private boolean malade;
    private int score;
}
