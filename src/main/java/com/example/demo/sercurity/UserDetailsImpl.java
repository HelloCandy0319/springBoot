package com.example.demo.sercurity;

import com.example.demo.controller.TokenController;
import com.example.demo.dto.TokenResult;
import com.example.demo.entity.cloudTest.RoleAndUser;
import com.example.demo.entity.cloudTest.User;
import com.example.demo.repository.cloudTest.RoleAndUserRepository;
import com.example.demo.repository.cloudTest.UserRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;


@Service
public class UserDetailsImpl implements UserDetailsService {
    private static final Logger logger = LoggerFactory.getLogger(UserDetailsImpl.class);

    @Autowired
    private RoleAndUserRepository roleAndUserRepository;
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private TokenController tokenController;

    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        System.out.println("用户姓名：：："+s);
        User user = userRepository.findByUsername(s);
        logger.info("查找用户");
        if (user==null){
            throw new UsernameNotFoundException("用户不存在！");
        }
            UserDetails userDetails = new UserDetails() {
            @Override
            public Collection<? extends GrantedAuthority> getAuthorities() {
                logger.info("获取用户权限");
                List<RoleAndUser> roleAndUsers = roleAndUserRepository.findByUserId(user.getId());
                List<GrantedAuthority> authorities = new ArrayList<>();
                if (roleAndUsers!=null){
                    for (RoleAndUser roleAndUser: roleAndUsers){
                        authorities.add(new SimpleGrantedAuthority(roleAndUser.getRoleId()+""));
                    }
                }
                return authorities;
            }

            @Override
            public String getPassword() {
                return user.getPassword();
            }

            @Override
            public String getUsername() {
                return user.getUsername();
            }

                /**
                 * 用户账户信息过期
                 * @return
                 */
            @Override
            public boolean isAccountNonExpired() {
                return true;
            }

                /**
                 * 锁用户
                 * @return
                 */
            @Override
            public boolean isAccountNonLocked() {
                return true;
            }

                /**
                 * 用户凭据过期
                 * @return
                 */
            @Override
            public boolean isCredentialsNonExpired() {
                return true;
            }

                /**
                 * 用户不可用
                 * @return
                 */
            @Override
            public boolean isEnabled() {
                return true;
            }
        };


        return userDetails;
    }
}
