package cn.carl.std.cocoadmin.security;

import cn.carl.std.cocoadmin.entity.vo.SysUserAuthorityVo;
import cn.carl.std.cocoadmin.entity.vo.UserVo;
import cn.carl.std.cocoadmin.service.SysUserAuthorityService;
import cn.carl.std.cocoadmin.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import java.util.List;

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
    @Autowired
    SysUserAuthorityService sysUserAuthorityService;


    @Override
    public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
        //查询用户
        UserVo userVo=userService.findByLoginName(userName).getData();
        //查询权限
        List<SysUserAuthorityVo> sysUserAuthorityVoList=sysUserAuthorityService.findByUserId(userVo.getUserId()).getData();
        StringBuilder authorityList=new StringBuilder();
        for(int i=0;i<sysUserAuthorityVoList.size();i++){
            SysUserAuthorityVo sysUserAuthorityVo=sysUserAuthorityVoList.get(i);
            authorityList.append(sysUserAuthorityVo.getSysAuthority().getAuthorityName());
            if(i!=sysUserAuthorityVoList.size()-1){
                authorityList.append(",");
            }
        }

        if(StringUtils.isEmpty(userVo.getUserId())){
            userVo.setLoginName("查无此用户");
            userVo.setPassword("查无此用户");
        }

        // 封装用户信息，并返回。参数分别是：用户名，密码，用户权限
        return new User(userVo.getLoginName(), userVo.getPassword(), AuthorityUtils.commaSeparatedStringToAuthorityList(authorityList.toString()));

    }
}
