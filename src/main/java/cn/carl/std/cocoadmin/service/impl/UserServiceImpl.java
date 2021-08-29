package cn.carl.std.cocoadmin.service.impl;

import cn.carl.std.cocoadmin.entity.pojo.User;
import cn.carl.std.cocoadmin.entity.vo.Result;
import cn.carl.std.cocoadmin.entity.vo.UserVo;
import cn.carl.std.cocoadmin.service.UserService;
import org.springframework.security.web.authentication.rememberme.PersistentTokenRepository;
import org.springframework.stereotype.Service;

/**
 * @author zhangtao
 * @Title:
 * @Package: cn.carl.std.cocoadmin.service.impl
 * @Description: 系统用户服务
 * @date 8/30/21 12:10 AM
 */
@Service
public class UserServiceImpl extends CommonServiceImpl<UserVo, User,String> implements UserService {
    @Override
    public Result<UserVo> findByLoginName(String userName) {
        return null;
    }

    @Override
    public Result<UserVo> resetPassword(String userId) {
        return null;
    }

    @Override
    public PersistentTokenRepository getPersistentTokenRepository2() {
        return null;
    }
}
