package cn.carl.std.cocoadmin.util;

import org.apache.tomcat.util.codec.binary.Base64;
import org.bouncycastle.jce.provider.BouncyCastleProvider;

import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.spec.SecretKeySpec;
import java.nio.charset.StandardCharsets;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.NoSuchProviderException;
import java.security.SecureRandom;
import java.util.Random;


/**
 * @author zhangtao
 * @Title: AesUtil
 * @Package: cn.carl.std.cocoadmin.util
 * @Description: Aes加密工具
 * 高级加密标准(AES,Advanced Encryption Standard)
 * 最常见的 对称加密算法 (微信小程序加密传输就是用这个加密算法的)。
 * 对称加密算法也就是加密和解密用相同的密钥
 * 详见：https://blog.csdn.net/qq_28205153/article/details/55798628
 * @date 3/9/21 9:12 PM
 */

public class AesUtil {
    /**
     * 加密算法AES
     */
    private final static String KEY_ALGORITHM = "AES";

    /**
     * key的长度，key size: must be equal to 128[AES-128], 192[AES-192] or 256[AES-256]
     * 传入时需要16、24、36
     * 这里采用 AES-128
     */
    private static final Integer KEY_LENGTH = 16 * 8;

    /**
     * 算法名称/加密模式/数据填充方式
     * 默认：AES/ECB/PKCS5Padding
     */
    private static final String ALGORITHMS = "AES/ECB/PKCS5Padding";


    /**
     * 不能在代码中创建
     * JceSecurity.getVerificationResult 会将其put进 private static final Map<Provider,Object>中，导致内存缓便被耗尽
     */
    private static final BouncyCastleProvider PROVIDER = new BouncyCastleProvider();

    /**
     * 后端AES的key，由静态代码块赋值
     */
    public static String key;

    static {
        key = getKey();
    }

    /**
     * 获取动态生产的随机加密key
     */
    public static String getKey() {
        StringBuilder uid = new StringBuilder();
        //16位强随机数
        Random random = new SecureRandom();
        for (int i = 0; i < KEY_LENGTH / 8; i++) {
            ////产生0-2的3位随机数
            int type = random.nextInt(3);
            switch (type) {
                case 0:
                    //0-9的随机数
                    uid.append(random.nextInt(10));
                    break;
                case 1:
                    //ASCII在65-90之间为大写,获取大写随机
                    uid.append((char) (random.nextInt(25) + 65));
                    break;
                case 2:
                    //ASCII在97-122之间为小写，获取小写随机
                    uid.append((char) (random.nextInt(25) + 97));
                    break;
                default:
                    break;
            }
        }
        return uid.toString();
    }

    /**
     * 加密
     *
     * @param content    加密内容
     * @param encryptKey 加密key
     * @return
     */
    public static String encrypt(String content, String encryptKey) throws NoSuchPaddingException, NoSuchAlgorithmException, NoSuchProviderException, InvalidKeyException, BadPaddingException, IllegalBlockSizeException {
        //设置Cipher对象
        Cipher cipher = Cipher.getInstance(ALGORITHMS, PROVIDER);
        cipher.init(Cipher.ENCRYPT_MODE, new SecretKeySpec(encryptKey.getBytes(), KEY_ALGORITHM));

        //调用doFinal
        // 转base64
        return Base64.encodeBase64String(cipher.doFinal(content.getBytes(StandardCharsets.UTF_8)));
    }

    /**
     * 解密
     *
     * @param ecryptContent 加密内容
     * @param decryptKey    解密key
     * @return
     * @throws NoSuchPaddingException
     * @throws NoSuchAlgorithmException
     * @throws BadPaddingException
     * @throws IllegalBlockSizeException
     * @throws InvalidKeyException
     */
    public static String decrypt(String ecryptContent, String decryptKey) throws NoSuchPaddingException, NoSuchAlgorithmException, BadPaddingException, IllegalBlockSizeException, InvalidKeyException {
        //base64格式的key字符串转byte
        byte[] decodeBase64 = Base64.decodeBase64(ecryptContent);

        //设置Cipher对象
        Cipher cipher = Cipher.getInstance(ALGORITHMS, PROVIDER);
        cipher.init(Cipher.DECRYPT_MODE, new SecretKeySpec(decryptKey.getBytes(), KEY_ALGORITHM));

        //调用doFinal解密
        return new String(cipher.doFinal(decodeBase64));
    }

}
