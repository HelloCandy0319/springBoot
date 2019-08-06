package com.example.demo.entity.cloudTest;

import com.example.demo.validator.jpa.FlagValidator;
import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

@Table(name = "user")
@Entity
@Data
public class User implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotNull
    private String username;
    @NotNull
    private String password;

    private Integer age;

    @Transient
    @FlagValidator(values = "1,2,3")
    private String flag;

//    @Transient
//    @ManyToOne
//    RoleAndUser roleAndUser;

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", age=" + age +
                ", flag='" + flag + '\'' +
                '}';
    }

}
