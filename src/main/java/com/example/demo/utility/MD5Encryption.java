package com.example.demo.utility;

public class MD5Encryption {

    public static String tokenEncryption(String timestamp,String userId,String nonce,String token){
        return timestamp+nonce+userId+token;
    }
}
