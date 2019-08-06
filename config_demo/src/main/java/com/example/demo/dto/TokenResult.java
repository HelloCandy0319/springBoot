package com.example.demo.dto;

import lombok.Data;

@Data
public class TokenResult {
    private boolean flag = true;
    private String msg="";
    private String token="";
}
