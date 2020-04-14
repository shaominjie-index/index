package com.ianji.jpa;

import lombok.Data;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

@Entity
@Table(name = "tb_user")
@Data
public class User {
    @Id
    @GenericGenerator(name = "idGenerator", strategy = "uuid")
    @GeneratedValue(generator = "idGenerator")
    private String id;
    @Column(name = "sys_name", unique = true, nullable = false, length = 64)
    private String name;

    @Column(name = "sys_password", nullable = false, length = 64)
    private String password;

    @Column(name = "sys_email", length = 64)
    private String email;
}
