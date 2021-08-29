package cn.carl.std.cocoadmin.controller;

import cn.carl.std.cocoadmin.assist.SysSettingAssist;
import cn.carl.std.cocoadmin.entity.vo.SysSettingVo;
import cn.carl.std.cocoadmin.service.SysSettingService;
import cn.carl.std.cocoadmin.util.ErrorUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.ApplicationRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletResponse;
import java.net.InetAddress;
import java.net.UnknownHostException;

/**
 * @author zhangtao
 * @Title: IndexControoler
 * @Package: cn.carl.std.cocoadmin.controller
 * @Description:
 * @date 3/7/21 12:49 AM
 */
@Slf4j
@Configuration
@RequestMapping("/")
@Controller
public class IndexController {

    // ModelAndView attributeName
    private static final String SYS_KEY = "sys";
    private static final String LOGIN_USER_KEY = "loginUser";
    private static final String MENULIST_KEY = "menuList";
    private static final String S_MENULIST_KEY = "shortcutMenuList";
    private static final String RS_PUB_KEY = "publicKey";

    @Value(value = "${server.servlet.context-path}")
    private String contextPath;
    @Value(value = "${server.port}")
    private int port;

    @Autowired
    SysSettingService sysSettingService;


    /**
     * 启动成功后执行 加载系统设置
     *
     * @return
     */
    @Bean
    public ApplicationRunner applicationRunner() {

        return applicationArguments -> {
            try {
                //获取数据库中 系统设置信息 放入map中
                SysSettingVo sysSettingVo = sysSettingService.get("1").getData();
                SysSettingAssist.setSysSettingMap(sysSettingVo);
                //获取本机内网IP
                log.info("启动成功：" + "http://" + InetAddress.getLocalHost().getHostAddress() + ":" + port + contextPath);
            } catch (UnknownHostException e) {
                log.error(ErrorUtil.errorInfoToString(e));
            }
        };
    }

    /**
     * 首页
     *
     * @param httpServletResponse
     */
    @GetMapping("")
    public void index(HttpServletResponse httpServletResponse) {
        //重定向
        try {
            httpServletResponse.sendRedirect("/index");
        } catch (Exception e) {
            //ignore
            log.error("首页加载失败:\n" + e.getMessage());
        }
    }

    /**
     * todo 信息填充
     *
     * @return ModelAndView
     */
    @GetMapping("index")
    public ModelAndView index() {
        ModelAndView modelAndView = new ModelAndView("index");
        //系统信息
        modelAndView.addObject(SYS_KEY, SysSettingAssist.getSysSetting());
        //登录用户信息

        //登录用户系统菜单信息

        //登录用户快捷菜单信息

        //后端公钥信息

        return modelAndView;
    }

    /**
     * todo 信息填充
     *
     * @return ModelAndView
     */
    @GetMapping("loginPage")
    public ModelAndView login() {
        ModelAndView modelAndView = new ModelAndView("login");
        //系统信息
        modelAndView.addObject(SYS_KEY, SysSettingAssist.getSysSetting());
        //后端公钥信息

        return modelAndView;
    }

}
