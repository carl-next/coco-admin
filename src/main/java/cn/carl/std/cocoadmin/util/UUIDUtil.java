package cn.carl.std.cocoadmin.util;

import java.util.UUID;

/**
 * @author zhangtao
 * @Title:
 * @Package: cn.carl.std.cocoadmin.util
 * @Description: uuid
 * @date 8/23/21 9:50 PM
 */

public class UUIDUtil {
    /**
     * 32位uuid
     * @return
     */
    public static String getUUID(){
        return UUID.randomUUID().toString().trim().replaceAll("-", "");
    }
}
