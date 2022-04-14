package Entities;

import lombok.Data;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Data
@Entity
@Table(name = "tCurency")
public class Curency {
    @Id
    //@GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name = "CU_ID" , nullable = false)
    private Integer id;

    @Column(name = "CU_ISO")
    private long ISO;

    @Column(name = "CU_NAME")
    private String name;

    @Column(name = "CU_CODE")
    private String code;

    @ManyToOne
    @JoinColumn(name = "CU_CO_ID")
    private Country country;

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name="tCurency_tAccount", joinColumns = @JoinColumn(name = "CA_CU_ID"),
            inverseJoinColumns = @JoinColumn(name = "CA_AC_ID"))
    private Set<Account> accounts = new HashSet<Account>();
}
