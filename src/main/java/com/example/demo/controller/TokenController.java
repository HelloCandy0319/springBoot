package com.example.demo.controller;

import com.example.demo.dto.TokenResult;
import com.example.demo.entity.cloudTest.AppToken;
import com.example.demo.entity.cloudTest.User;
import com.example.demo.repository.cloudTest.AppTokenRepository;
import com.example.demo.repository.cloudTest.UserRepository;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.Date;
import java.util.concurrent.TimeUnit;

@RestController
@RequestMapping("/jwt")
public class TokenController {
    @Autowired
    private AppTokenRepository appTokenRepository;

    @Autowired
    private UserRepository userRepository;

    @GetMapping("/token")
    public TokenResult token(@RequestParam(name = "appId") String appId){
        TokenResult tokenResult = new TokenResult();
        if (appId==null || appId.trim().equals("")){
            tokenResult.setFlag(false);
            tokenResult.setMsg("token 不存在");
        }else {
           User user = userRepository.findByUsername(appId);
            if (user == null){
                tokenResult.setFlag(false);
                tokenResult.setMsg("appId 用户 不存在");
            }else {
               AppToken appToken = appTokenRepository.findByAppId(user.getId()+"");
               String token = null;
               if (appToken == null){
                   // 创建token 写入数据库
                 token = CreateToken(user.getId()+"",user.getUsername());
                 AppToken newAppToken =  new AppToken();
                 newAppToken.setAppId(user.getId()+"");
                 newAppToken.setToken(token);
                 newAppToken.setBuildTime(String.valueOf(System.currentTimeMillis()));
                 appTokenRepository.save(newAppToken);
               }else {
                   //判断数据库中的token是否过期。没有的话 就返回数据库中的token即可
                   //过期重新生成token
                   Long tokenTime = Long.valueOf(appToken.getBuildTime());
                   Long cruentTime = System.currentTimeMillis();
                   Long second = TimeUnit.MILLISECONDS.toSeconds(cruentTime-tokenTime);
                   if (second>0 && second<= 72000000){
                       token = appToken.getToken();
                   }else {
                       token = CreateToken(user.getId()+"",user.getUsername());
                       appToken.setToken(token);
                       appToken.setBuildTime(String.valueOf(System.currentTimeMillis()));
                       appTokenRepository.save(appToken);
                   }
               }
                tokenResult.setToken(token);
            }
        }
        return tokenResult;
    }
    
    /**
     * 生成token
     * 解释每个方法的参数
     * @param appId
     * @return
     */
    private String CreateToken(String appId,String appName){
        Date now = new Date(System.currentTimeMillis());
        Date expiration = new Date(now.getTime()+ 72000000);
        return Jwts
                .builder()
                .setSubject(appId)          //面向用户AppId
                .setIssuedAt(now)
                .setIssuer("Cindy")   // 该JWT的签发者
                .setExpiration(expiration)
                .signWith(SignatureAlgorithm.HS256,"TokenTest"+appId)       //签名算法  两个参数分别是签名算法和自定义的签名Key（盐）
                .compact();
    }
}
