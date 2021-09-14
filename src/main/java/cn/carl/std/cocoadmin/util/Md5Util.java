package cn.carl.std.cocoadmin.util;

import lombok.extern.slf4j.Slf4j;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;

/**
 * @author zhangtao
 * @Title:
 * @Package: cn.carl.std.cocoadmin.util
 * @Description:
 * @date 9/14/21 11:58 PM
 */
@Slf4j
public class Md5Util {
    /**
     * 生成MD5加密串
     */
    public static String getMD5(String message) {
        String md5 = "";
        try {
            //创建一个md5算法对象
            MessageDigest md = MessageDigest.getInstance("MD5");
            byte[] messageByte = message.getBytes(StandardCharsets.UTF_8);
            //获得MD5字节数组,16*8=128位
            byte[] md5Byte = md.digest(messageByte);
            //转换为16进制字符串
            md5 = ByteUtil.bytesToHex(md5Byte);
        } catch (Exception e) {
            //输出到日志文件中
            log.error(ErrorUtil.errorInfoToString(e));
        }
        return md5;
    }
}
