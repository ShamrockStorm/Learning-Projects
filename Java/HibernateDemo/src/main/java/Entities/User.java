package Entities;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "tUser")
public class User {
    @Id
    //@GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name = "US_ID", nullable = false)
    private Integer id;
    @Column(name = "US_TYPE")
    private String type;
    @Column(name ="US_NAME")
    private String name;

    @OneToOne(mappedBy = "user")
    @JoinColumn(name ="AC_US_ID")
    private Account account;

    @ManyToOne
    @JoinColumn(name = "US_CO_ID")
    private Country country;
}

