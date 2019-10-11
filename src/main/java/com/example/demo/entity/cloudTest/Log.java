package com.example.demo.entity.cloudTest;

import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Date;

@Entity
@Table(name = "log")
@Data
public class Log {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "client_url")
    private String clientUrl;

    private String method;

    @Column(name = "param_data")
    private String paramData;

    @Column(name = "begin_time")
    private Date beginTime;

    @Column(name = "return_time")
    private Date returnTime;

    @Column(name = "user_id")
    private Long userId;

}
