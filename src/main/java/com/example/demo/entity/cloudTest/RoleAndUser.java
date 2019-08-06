package com.example.demo.entity.cloudTest;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;


@Table(name = "role_user")
@Data
@Entity
public class RoleAndUser implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

  @Column(name = "role_id")
  private Long roleId;

  @Column(name = "user_id")
  private Long userId;

//    @ManyToOne
//   private User user;

}
