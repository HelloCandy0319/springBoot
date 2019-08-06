package com.example.demo.entity.cloudTest;

import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name = "app_user_infos")
@Data
public class AppUserInfo {
    @Column(name = "app_id")
    @Id
    private String id;

    private byte[] secret;

    private int status;

    @Column(name = "request_count")
    private Long requestCount;

    @Column(name = "bind_ip")
    private String bindIp;

    private String mark;
}
