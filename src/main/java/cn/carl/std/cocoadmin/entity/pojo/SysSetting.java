package cn.carl.std.cocoadmin.entity.pojo;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;
import java.util.Date;

/**
 * @author zhangtao
 * @Title: SysSetting
 * @Package: cn.carl.std.cocoadmin.entity.pojo
 * @Description: SysSetting pojo
 * @date 3/14/21 9:39 PM
 */
@Entity
@Table(name = "sys_setting")
@Data
public class SysSetting implements Serializable {
    @Id
    private String id;//表id 主键

    private String sysName;//系统名称

    private String sysLogo;//系统logo图标

    private String sysBottomText;//系统底部信息

    private String sysColor;//系统颜色

    private String sysNoticeText;//系统公告

    private String sysApiEncrypt;//API加密 Y/N

    private Date createTime;//创建时间

    private Date updateTime;//修改时间

    private String userInitPassword;//用户管理：初始、重置密码
}
