package cn.carl.std.cocoadmin.entity.vo;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * @author zhangtao
 * @Title:
 * @Package: cn.carl.std.cocoadmin.entity.vo
 * @Description: 系统权限控制
 * @date 9/8/21 8:47 PM
 */
@Data
public class SysAuthorityVo extends PageCondition implements Serializable {
    private String authorityId;//权限id

    private String authorityName;//权限名称，ROLE_开头，全大写

    private String authorityContent;//权限内容，可访问的url，多个时用,隔开

    private String authorityRemark;//权限描述

    private Date createTime;//创建时间

    private Date updateTime;//修改时间
}
