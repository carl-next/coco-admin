package cn.carl.std.cocoadmin.security;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

/**
 * @author zhangtao
 * @Title:
 * @Package: cn.carl.std.cocoadmin.security
 * @Description: todo Web安全控制
 * @date 8/25/21 11:29 PM
 *
 * 1.WebSecurityConfigurerAdapter: 自定义Security策略
 * 2.AuthenticationManagerBuilder: 自定义认证策略
 * 3.@EnableWebSecurity: 开启WebSecurity模式
 *
 * Spring Security的两个主要目标是“认证”和“授权”(访问控制)。
 * “认证”(Authentication)
 * "授权”(Authorization)
 * 这个概念是通用的,而不是只在Spring Security中存在。
 *
 */
@EnableWebSecurity //开启WebSecurity模式
public class CocoSecurityConfig extends WebSecurityConfigurerAdapter{

    /**
     * todo 认证
     * @param auth
     * @throws Exception
     */
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        super.configure(auth);
    }

    /**
     * todo 授权
     * @param http
     * @throws Exception
     */
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        super.configure(http);
    }

}
