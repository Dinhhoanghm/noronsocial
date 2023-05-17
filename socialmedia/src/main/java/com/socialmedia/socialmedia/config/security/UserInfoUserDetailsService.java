package com.socialmedia.socialmedia.config.security;

import com.hm.socialmedia.tables.pojos.User;
import com.socialmedia.socialmedia.repository.UserLogin;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import java.util.ArrayList;
import java.util.List;

public class UserInfoUserDetailsService implements UserDetailsService {
    @Autowired
    private UserLogin userLogin;

    @Override
    public UserDetails loadUserByUsername(String userAccount) throws UsernameNotFoundException {
        User user = userLogin.findUserByUserName(userAccount);
        if (user==null) {
            throw new UsernameNotFoundException("user not found" + userAccount);
        }
        List<GrantedAuthority> authorities = new ArrayList<>();
        SimpleGrantedAuthority simpleGrantedAuthority = new SimpleGrantedAuthority(user.getAuthority());
        authorities.add(simpleGrantedAuthority);
        UserLoginInfo userLoginInfo =new UserLoginInfo(
                user.getAccount(),user.getEmail(),user.getPassword(),
                authorities);
        return userLoginInfo;
    }
}
