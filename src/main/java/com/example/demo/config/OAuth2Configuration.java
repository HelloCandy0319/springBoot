//package com.example.demo.config;
//
//import com.example.demo.sercurity.CustomAuthenticationEntryPoint;
//import com.example.demo.sercurity.CustomerLogoutSuccessHandler;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.beans.factory.annotation.Qualifier;
//import org.springframework.context.EnvironmentAware;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.core.env.Environment;
//import org.springframework.security.authentication.AuthenticationManager;
//import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//import org.springframework.security.oauth2.config.annotation.web.configuration.AuthorizationServerConfigurerAdapter;
//import org.springframework.security.oauth2.config.annotation.web.configuration.EnableAuthorizationServer;
//import org.springframework.security.oauth2.config.annotation.web.configuration.ResourceServerConfigurerAdapter;
//import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerEndpointsConfigurer;
//import org.springframework.security.oauth2.provider.token.TokenStore;
//import org.springframework.security.oauth2.provider.token.store.JdbcTokenStore;
//
//import javax.sql.DataSource;
//
//@Configuration
//public class OAuth2Configuration {
//
//       @Autowired
//       CustomAuthenticationEntryPoint customAuthenticationEntryPoint;
//       @Autowired
//       CustomerLogoutSuccessHandler customerLogoutSuccessHandler;
//
//    protected class ResourceServerConfiguration extends ResourceServerConfigurerAdapter {
//        @Override
//        public void configure(HttpSecurity http) throws Exception {
//            http
//                    .exceptionHandling()
//                    .authenticationEntryPoint(customAuthenticationEntryPoint)
//                    .and()
//                    .logout()
//                    .logoutUrl("/oauth/logout")
//                    .logoutSuccessHandler(customerLogoutSuccessHandler)
//                    .and()
//                    .authorizeRequests();
//        }
//    }
//    @Configuration
//    @EnableAuthorizationServer
//    protected class AuthenticationServerConfig extends AuthorizationServerConfigurerAdapter implements EnvironmentAware {
//      @Autowired
//      private DataSource dataSource;
//        @Bean
//       public TokenStore tokenStore(){
//           return new JdbcTokenStore(dataSource);
//       }
//
//       @Autowired
//       @Qualifier("authenticationManager")
//       private AuthenticationManager authenticationManager;
//
//
//        @Override
//        public void setEnvironment(Environment environment) {
//        }
//
//        @Override
//        public void configure(AuthorizationServerEndpointsConfigurer endpoints) throws Exception {
//           endpoints.tokenStore(tokenStore()).authenticationManager(authenticationManager);
//        }
//    }
//}
