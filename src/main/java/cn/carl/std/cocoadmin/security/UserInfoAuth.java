package cn.carl.std.cocoadmin.security;

import cn.carl.std.cocoadmin.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

/**
 * @author zhangtao
 * @Title:
 * @Package: cn.carl.std.cocoadmin.security
 * @Description: 登录用户信息认证
 * @date 8/29/21 11:50 PM
 */
@Component
public class UserInfoAuth implements UserDetailsService {
    @Autowired
    UserService userService;

    @Override
    public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {

        return null;
    }
}
