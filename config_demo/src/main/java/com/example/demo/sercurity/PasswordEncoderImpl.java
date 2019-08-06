package com.example.demo.sercurity;

import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;

public class PasswordEncoderImpl implements PasswordEncoder{
    @Override
    public String encode(CharSequence charSequence) {
        return charSequence.toString();
    }

    /**
     * 登录后 比对密码
     * @param charSequence
     * @param s
     * @return
     * @throws UsernameNotFoundException
     */
    @Override
    public boolean matches(CharSequence charSequence, String s) throws UsernameNotFoundException {
        boolean result = s.equals(charSequence.toString());
        if (!result){
            throw new UsernameNotFoundException("用户名或者密码错误");
        }
        return result;
    }
}
