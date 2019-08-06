package com.example.demo.entity.cloudTest;

import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name = "app_token")
@Data
public class AppToken
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String token;

    @Column(name = "app_id")
    private String appId;

    @Column(name = "build_time")
    private String buildTime;

}
