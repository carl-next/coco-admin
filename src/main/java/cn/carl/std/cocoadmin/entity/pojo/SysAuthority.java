package cn.carl.std.cocoadmin.entity.pojo;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

/**
 * @author zhangtao
 * @Title:
 * @Package: cn.carl.std.cocoadmin.entity.pojo
 * @Description: 系统权限控制
 * @date 8/30/21 12:28 AM
 */
@Data
@Entity
@Table(name = "sys_authority")
public class SysAuthority {
    @Id
    private String authorityId;//权限id

    private String authorityName;//权限名称，ROLE_开头，全大写

    private String authorityContent;//权限内容，可访问的url，多个时用,隔开

    private String authorityRemark;//权限描述

    private Date createTime;//创建时间

    private Date updateTime;//修改时间
}
