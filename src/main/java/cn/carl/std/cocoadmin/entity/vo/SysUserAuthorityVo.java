package cn.carl.std.cocoadmin.entity.vo;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * @author zhangtao
 * @Title:
 * @Package: cn.carl.std.cocoadmin.entity.vo
 * @Description: 系统用户权限VO
 * @date 9/8/21 8:45 PM
 */
@Data
public class SysUserAuthorityVo extends PageCondition implements Serializable {
    private String userAuthorityId;//用户权限表id

    private String userId;//用户id

    private String authorityId;//权限id

    private UserVo sysUser;//用户

    private SysAuthorityVo sysAuthority;//权限

    private Date createTime;//创建时间

    private Date updateTime;//修改时间

    private String authorityIdList;//新增、修改用户权限时权限id集合
}
