package cn.carl.std.cocoadmin.repository;

import cn.carl.std.cocoadmin.entity.pojo.SysSetting;
import org.springframework.stereotype.Repository;

/**
 * 系统设置  spring jpa
 * 对应表：sys_setting
 */
@Repository
public interface SysSettingRepository extends CommonRepository<SysSetting,String> {
}
