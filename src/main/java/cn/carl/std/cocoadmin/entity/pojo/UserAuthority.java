package cn.carl.std.cocoadmin.entity.pojo;

import lombok.Data;
import org.hibernate.annotations.NotFound;
import org.hibernate.annotations.NotFoundAction;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

/**
 * @author zhangtao
 * @Title:
 * @Package: cn.carl.std.cocoadmin.entity.pojo
 * @Description: 系统用户权限
 * @date 8/30/21 12:25 AM
 */
@Data
@Entity
@Table(name = "sys_user_authority")
public class UserAuthority implements Serializable {
    @Id
    private String userAuthorityId;//用户权限表id

    private String userId;//用户id

    private String authorityId;//权限id

    private Date createTime;//创建时间

    private Date updateTime;//修改时间

    //https://blog.csdn.net/yu870646595/article/details/51064634
    //https://www.cnblogs.com/jpfss/p/11059629.html
    //https://www.cnblogs.com/boywwj/p/8092915.html
    @OneToOne //一对一关联查询
    @JoinColumn(name = "userId",referencedColumnName = "userId", insertable = false, updatable = false)
    @NotFound(action= NotFoundAction.IGNORE)
    private User user;//用户

    @OneToOne
    @JoinColumn(name = "authorityId",referencedColumnName = "authorityId", insertable = false, updatable = false)
    @NotFound(action= NotFoundAction.IGNORE)
    private SysAuthority sysAuthority;//权限
}
