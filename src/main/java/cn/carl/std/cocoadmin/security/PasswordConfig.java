package cn.carl.std.cocoadmin.security;

import cn.carl.std.cocoadmin.util.Md5Util;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

/**
 * @author zhangtao
 * @Title:
 * @Package: cn.carl.std.cocoadmin.security
 * @Description: 密码处理  todo
 * @date 9/8/21 8:35 PM
 */
@Component
public class PasswordConfig implements PasswordEncoder {
    @Override
    public String encode(CharSequence charSequence) {
        return Md5Util.getMD5(charSequence.toString());
    }

    @Override
    public boolean matches(CharSequence charSequence, String passWord) {
        //password [charSequence是用户输入的密码，password是存库的密码]
        return passWord.contentEquals(encode(charSequence));
    }
}
