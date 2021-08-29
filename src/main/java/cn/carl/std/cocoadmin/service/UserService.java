package cn.carl.std.cocoadmin.service;

import cn.carl.std.cocoadmin.entity.pojo.User;
import cn.carl.std.cocoadmin.entity.vo.Result;
import cn.carl.std.cocoadmin.entity.vo.UserVo;
import org.springframework.security.web.authentication.rememberme.PersistentTokenRepository;


/**
 * 系统用户服务
 */
public interface UserService extends CommonService<UserVo, User,String> {
    Result<UserVo> findByLoginName(String userName);
    Result<UserVo> resetPassword(String userId);
    PersistentTokenRepository getPersistentTokenRepository2();
}
