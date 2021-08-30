package cn.carl.std.cocoadmin.service.impl;

import cn.carl.std.cocoadmin.entity.pojo.User;
import cn.carl.std.cocoadmin.entity.vo.Result;
import cn.carl.std.cocoadmin.entity.vo.UserVo;
import cn.carl.std.cocoadmin.repository.UserRepository;
import cn.carl.std.cocoadmin.service.UserService;
import cn.carl.std.cocoadmin.util.EntityTransformUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.web.authentication.rememberme.PersistentTokenRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;


/**
 * @author zhangtao
 * @Title:
 * @Package: cn.carl.std.cocoadmin.service.impl
 * @Description: 系统用户服务 todo
 * @date 8/30/21 12:10 AM
 */
@Service
@Transactional
public class UserServiceImpl extends CommonServiceImpl<UserVo, User,String> implements UserService {


    @PersistenceContext //容器托管的EntityManager
    private EntityManager entityManager;

    @Autowired
    UserRepository userRepository;

    @Override
    public Result<UserVo> findByLoginName(String userName) {
        return Result.of(EntityTransformUtil.copy(userRepository.findByLoginName(userName), UserVo.class));
    }

    /**
     * 重置初始密码
     * @param userId
     * @return
     */
    @Override
    public Result<UserVo> resetPassword(String userId) {

        return null;
    }

    @Override
    public PersistentTokenRepository getPersistentTokenRepository2() {
        return null;
    }
}
