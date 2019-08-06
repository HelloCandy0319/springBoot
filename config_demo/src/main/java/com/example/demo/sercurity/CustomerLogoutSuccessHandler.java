//package com.example.demo.sercurity;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.core.Authentication;
//import org.springframework.security.oauth2.common.OAuth2AccessToken;
//import org.springframework.security.oauth2.provider.token.TokenStore;
//import org.springframework.security.web.authentication.logout.LogoutSuccessHandler;
//import org.springframework.stereotype.Component;
//
//import javax.servlet.ServletException;
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//import java.io.IOException;
//@Component
//public class CustomerLogoutSuccessHandler implements LogoutSuccessHandler {
//
//    private static final String BEARER = "bearer";
//    private static final String AUTHENTICATION="authentication";
//    @Autowired
//    private TokenStore tokenStore;
//
//    @Override
//    public void onLogoutSuccess(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Authentication authentication) throws IOException, ServletException {
//       String token = httpServletRequest.getHeader(AUTHENTICATION);
//       if (token!=null && token.startsWith(BEARER)){
//           OAuth2AccessToken oAuth2AccessToken = tokenStore.readAccessToken(token.split("")[0]);
//           if (oAuth2AccessToken!=null){
//               tokenStore.removeAccessToken(oAuth2AccessToken);
//           }
//       }
//    }
//}
