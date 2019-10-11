package com.example.demo.entity.cloudTest;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;

@Table(name = "error_log")
@Entity
@Data
public class ErrorLog {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "exception_json")
    private String exceptionJson;

    private String message;

    @Column(name = "happend_time")
    private Date happendTime;
}
