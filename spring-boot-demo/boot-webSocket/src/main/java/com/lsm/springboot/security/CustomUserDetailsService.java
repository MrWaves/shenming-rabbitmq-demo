package com.lsm.springboot.security;

import com.lsm.springboot.domain.AdminUser;
import com.lsm.springboot.service.IAdminUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by shenming.li on 2017/6/15.
 */
public class CustomUserDetailsService implements UserDetailsService {

    @Autowired
    private IAdminUserService adminUserServiceImpl;

    @Override
    public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {

        AdminUser user = adminUserServiceImpl.selectByName(userName);

        if (user == null) {

            throw new UsernameNotFoundException("UserName " + userName + " not found");

        }

        List<SimpleGrantedAuthority> authorities = new ArrayList<>();
        authorities.add(new SimpleGrantedAuthority("ROLE_ADMIN"));
        User userDetails = new User(user.getUserName(), user.getPassWord(), authorities);

        return userDetails;

    }
}
