package cn.carl.std.cocoadmin.controller;

import cn.carl.std.cocoadmin.util.ErrorUtil;
import lombok.extern.slf4j.Slf4j;
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

    @Value(value = "${server.servlet.context-path}")
    private String contextPath;
    @Value(value = "${server.port}")
    private int port;

    /**
     * 启动成功后执行 加载系统设置
     *
     *
     * @return
     */
    @Bean
    public ApplicationRunner applicationRunner() {

        return applicationArguments -> {
            try {

                //获取本机内网IP
                log.info("启动成功：" + "http://" + InetAddress.getLocalHost() + ":" + port + contextPath);
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
        }
    }

    /**
     * @return
     */
    @GetMapping("index")
    public ModelAndView index() {
        ModelAndView modelAndView = new ModelAndView("index");
        return modelAndView;
    }

    @GetMapping("login")
    public ModelAndView login() {
        ModelAndView modelAndView = new ModelAndView("login");
        return modelAndView;
    }

}
