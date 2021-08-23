package cn.carl.std.cocoadmin.util;

import java.io.PrintWriter;
import java.io.StringWriter;

/**
 * @author zhangtao
 * @Title: ErrorUtil
 * @Package: cn.carl.std.cocoadmin.util
 * @Description: Error log Util
 * @date 3/10/21 12:18 AM
 */

public class ErrorUtil {

    /**
     * Exception出错的栈信息转成字符串 用于打印到日志中
     * @param e
     * @return
     */
    public static String errorInfoToString(Throwable e){
        //try-with-resources
        try(StringWriter sw=new StringWriter(); PrintWriter pw= new PrintWriter(sw)){
            e.printStackTrace(pw);
            pw.flush();
            sw.flush();
            return sw.toString();
        }catch (Exception ignored){
            throw new RuntimeException(ignored.getMessage(),ignored);
        }
    }
}
