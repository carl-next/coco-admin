package cn.carl.std.cocoadmin.assist;

import cn.carl.std.cocoadmin.entity.vo.SysSettingVo;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author zhangtao
 * @Title: SysSettingAssist
 * @Package: cn.carl.std.cocoadmin.assist
 * @Description: 系统设置助手
 * 系统启动时获取数据库数据，设置到公用静态集合sysSettingMap
 * 更新系统设置时同步更新公用静态集合sysSettingMap
 * @date 3/14/21 7:19 PM
 */

public class SysSettingAssist {
    //使用线程安全的ConcurrentHashMap来存储系统设置
    private static Map<String, SysSettingVo> sysSettingMap = new ConcurrentHashMap<>(8);
    private final static String SYS_SETTING_VO_KEY = "sysSetting";

    /**
     * 从公用静态集合sysSettingMap获取系统设置
     *
     * @return
     */
    public static SysSettingVo getSysSetting() {
        return sysSettingMap.get(SYS_SETTING_VO_KEY);
    }

    /**
     * 更新公用静态集合sysSettingMap
     *
     * @param settingVo
     */
    public static void setSysSettingMap(SysSettingVo settingVo) {
        sysSettingMap.put(SYS_SETTING_VO_KEY, settingVo);
    }

}
