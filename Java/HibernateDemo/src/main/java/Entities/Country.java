package Entities;

import lombok.Data;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Data
@Entity
@Table(name = "tCountry")
public class Country {
    @Id
    //@GeneratedValue(strategy=GenerationType.TABLE)
    @Column(name = "CO_ID", nullable = false)
    private Integer id;
    @Column(name = "CO_NAME")
    private String name;
    @Column(name = "CO_CAPITAL")
    private String capital;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "US_CO_ID")
    List<User> users = new ArrayList<User>();

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "CU_CO_ID")
    List<Curency> curencies = new ArrayList<Curency>();
}
