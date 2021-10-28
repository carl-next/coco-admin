package cn.carl.std.cocoadmin.security;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.session.SessionInformation;
import org.springframework.security.core.session.SessionRegistry;
import org.springframework.stereotype.Component;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * @author zhangtao
 * @Title:
 * @Package: cn.carl.std.cocoadmin.security
 * @Description: 验证码处理模块： 校验账号、密码前，先进行验证码处理，需要在这里进行登录解密操作
 * todo
 * @date 10/10/21 9:30 PM
 */
@Slf4j
@Component
public class CaptchaFilterConfig implements Filter {

    @Value("${captcha.enable}")
    private boolean captchaEnable;
    @Value("${server.servlet.context-path:}")
    private String contextPath;

    @SuppressWarnings("SpringJavaInjectionPointsAutowiringInspection")
    @Autowired
    private SessionRegistry sessionRegistry;

    private static final String SPRING_SECURITY_CONTEXT_KEY = "SPRING_SECURITY_CONTEXT";

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    // todo
    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        HttpServletResponse response = (HttpServletResponse) servletResponse;
        HttpSession session = request.getSession();
        // 注：详情可在SessionManagementFilter中进行断点调试查看
        // security框架会在session的attribute存储登录信息，
        // 先从session.getAttribute(this.springSecurityContextKey)中获取登录用户信息
        // ，如果没有，再从本地上下文SecurityContextHolder.getContext().getAuthentication()获取，
        // 因此想要强制用户下线得进行如下操作
        // 另外，虽然重启了服务，sessionRegistry.getAllSessions()为空，
        // 但之前的用户session未过期同样能访问系统，也是这个原因
        SessionInformation sessionInformation = sessionRegistry.getSessionInformation(session.getId());
        if (sessionInformation == null && session.getAttribute(SPRING_SECURITY_CONTEXT_KEY) != null) {
            //直接输出js脚本跳转强制用户下线
            response.setContentType("text/html;charset=UTF-8");
            response.getWriter().print("<script type='text/javascript'>window.location.href = '" + contextPath + "/logout'</script>");
        }


    }

    @Override
    public void destroy() {

    }
}
