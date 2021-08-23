package cn.carl.std.cocoadmin.constant;

/**
 * @author zhangtao
 * @Title:
 * @Package: cn.carl.comadmin.cocoadmin.constant
 * @Description: 工具类常量
 * @date 2020-11-07 21:39
 */

public class UtilConst {

    /**
     * 加密算法RSA
     */
    public static final String KEY_ALGORITHM = "RSA";

    /**
     * 算法名称/加密模式/数据填充方式
     * 默认：RSA/ECB/PKCS1Padding
     */
    public static final String ALGORITHMS = "RSA/ECB/PKCS1Padding";

    /**
     * Map获取公钥的key
     */
    public static final String PUBLIC_KEY = "publicKey";

    /**
     * Map获取私钥的key
     */
    public static final String PRIVATE_KEY = "privateKey";

    /**
     * RSA最大加密明文大小
     */
    public static final int MAX_ENCRYPT_BLOCK = 117;

    /**
     * RSA最大解密密文大小
     */
    public static final int MAX_DECRYPT_BLOCK = 128;

    /**
     * RSA 位数 如果采用2048 上面最大加密和最大解密则须填写:  245 256
     */
    public static final int INITIALIZE_LENGTH = 1024;

}
