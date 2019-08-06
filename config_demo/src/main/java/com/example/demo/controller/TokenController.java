//package com.example.demo.controller;
//
//import com.example.demo.dto.TokenResult;
//import com.example.demo.entity.cloudTest.AppToken;
//import com.example.demo.entity.cloudTest.AppUserInfo;
//import com.example.demo.repository.cloudTest.AppTokenRepository;
//import com.example.demo.repository.cloudTest.AppUserInfoRepository;
//import io.jsonwebtoken.Jwts;
//import io.jsonwebtoken.SignatureAlgorithm;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.data.jpa.domain.Specification;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RequestMethod;
//import org.springframework.web.bind.annotation.RequestParam;
//import org.springframework.web.bind.annotation.RestController;
//
//import javax.persistence.criteria.CriteriaBuilder;
//import javax.persistence.criteria.CriteriaQuery;
//import javax.persistence.criteria.Predicate;
//import javax.persistence.criteria.Root;
//import java.util.Date;
//import java.util.concurrent.TimeUnit;
//
//@RestController
//@RequestMapping("/jwt")
//public class TokenController {
//    @Autowired
//    private AppTokenRepository appTokenRepository;
//
//    @Autowired
//    private AppUserInfoRepository appUserInfoRepository;
//
//    @RequestMapping(value = "/token",method = {RequestMethod.GET,RequestMethod.POST})
//    public TokenResult tokenResult(@RequestParam String appId,@RequestParam String secret){
//        TokenResult tokenResult = new TokenResult();
//        if (appId==null && appId.trim()==""){
//            tokenResult.setFlag(false);
//            tokenResult.setMsg("AppId 不存在");
//        }else if (secret==null && secret.trim()==""){
//            tokenResult.setFlag(false);
//            tokenResult.setMsg("secret 不存在");
//        }else {
//            AppUserInfo appUserInfo = appUserInfoRepository.findOne(new Specification<AppUserInfo>() {
//                @Override
//                public Predicate toPredicate(Root<AppUserInfo> root, CriteriaQuery<?> criteriaQuery, CriteriaBuilder criteriaBuilder) {
//                    criteriaQuery.where(criteriaBuilder.equal(root.get("appId"),appId));
//                    return null;
//                }
//            });
//            if (appUserInfo==null){
//                tokenResult.setFlag(false);
//                tokenResult.setMsg("AppId"+appId+" 不存在");
//            }else if (!new String(appUserInfo.getSecret()).equals(secret.replace("","+"))){
//                tokenResult.setFlag(false);
//                tokenResult.setMsg("secret"+secret+" 无效");
//            }else{
//              AppToken appToken = appTokenRepository.findOne(new Specification<AppToken>(){
//                  @Override
//                  public Predicate toPredicate(Root<AppToken> root, CriteriaQuery<?> criteriaQuery, CriteriaBuilder criteriaBuilder) {
//                      criteriaQuery.where(criteriaBuilder.equal(root.get("appId"),appId));
//                      return null;
//                  }
//              });
//                String tokenUrl = null;
//               if (appToken==null){
//                   tokenUrl = createToken(appId);
//                   appToken = new AppToken();
//                   appToken.setAppId(appId);
//                   appToken.setToken(tokenUrl);
//                   appToken.setBuildTime(String.valueOf(System.currentTimeMillis()));
//                   appTokenRepository.save(appToken);
//               }else{
//                  Long dbBuildTime = Long.parseLong(appToken.getBuildTime());
//                  Long cruuentTime = System.currentTimeMillis();
//                  Long second = TimeUnit.MILLISECONDS.toSeconds(cruuentTime-dbBuildTime);
//                  if (second>0 && second<7200){
//                      tokenUrl = new String(appToken.getToken());
//                  }else{
//                      tokenUrl = createToken(appId);
//                      appToken = new AppToken();
//                      appToken.setAppId(appId);
//                      appToken.setToken(tokenUrl);
//                      appToken.setBuildTime(String.valueOf(System.currentTimeMillis()));
//                      appTokenRepository.save(appToken);
//                  }
//               }
//                tokenResult.setToken(tokenUrl);
//            }
//        }
//        return tokenResult;
//    }
//
//    private String createToken(String appId){
//        Date nowDate = new Date(System.currentTimeMillis());
//        Date expirenow = new Date(nowDate.getTime()+7200);
//        return Jwts.builder()
//                .setSubject(appId)
//                .setIssuedAt(nowDate)
//                .setIssuer("Jwt Test")
//                .setExpiration(expirenow)
//                .signWith(SignatureAlgorithm.ES256,"TestV1.0")
//                .compact();
//    }
//}
