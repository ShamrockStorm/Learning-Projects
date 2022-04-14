package Entities;

import lombok.Data;


import javax.persistence.*;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Data
@Entity
@Table(name = "tAccount")
public class Account {
    @Id
    //@GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name = "AC_ID", nullable = false)
    private Integer id;
    @Column(name = "AC_PRODUCT_TYPE")
    private String product_Type;

    @Temporal(TemporalType.DATE)
    @Column(name = "AC_DATE_CREATED")
    private Date date_Created;

    @ManyToMany(cascade = CascadeType.ALL, mappedBy = "accounts")
    private Set<Curency> curencies = new HashSet<Curency>();


    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name ="AC_US_ID")
    public User user;
}
