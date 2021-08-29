package cn.carl.std.cocoadmin.repository;

import cn.carl.std.cocoadmin.entity.pojo.User;
import org.springframework.stereotype.Repository;

/**
 * 系统用户信息  spring jpa
 * 对应表：sys_user
 */
@Repository
public interface UserRepository extends CommonRepository<User,String> {
    User findByLoginName(String userName);
}
