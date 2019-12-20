package com.xxl.job.admin.config;

import org.apache.commons.lang3.StringUtils;
import org.jasypt.util.text.BasicTextEncryptor;

/**
 * @author xiaoyang
 * @date 2019/10/31
 * @time 9:58
 * @since JDK 1.8
 */
public class EncryptorUtils {
    private static final String PASSWD = "hc_platform";

    private static BasicTextEncryptor encryptor = new BasicTextEncryptor();

    static {
        encryptor.setPassword(PASSWD);
    }

    /**
     * 加密
     *
     * @return
     */
    public static String getEncryptionString(String message) {
        if (StringUtils.isBlank(message)) {
            return "";
        }
        try {
            String crymessage = encryptor.encrypt(message);
            return StringUtils.defaultIfBlank(crymessage, "");
        } catch (Exception e) {
            return "";
        }

    }

    /**
     *
     * 说明：解密
     *
     * @param encryptedMessage
     * @return
     *
     */
    public static String getDecryptionString(String encryptedMessage) {
        if (StringUtils.isBlank(encryptedMessage)) {
            return "";
        }
        try {
            String crymessage = encryptor.decrypt(encryptedMessage);
            return StringUtils.defaultIfBlank(crymessage, "");
        } catch (Exception e) {
            return "";
        }
    }


}
