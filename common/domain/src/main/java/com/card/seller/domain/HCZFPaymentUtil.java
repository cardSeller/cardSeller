package com.card.seller.domain;

import org.apache.commons.lang3.StringUtils;
import org.springframework.core.io.ResourceLoader;

import java.util.Properties;

/**
 * Created by minjie
 * Date:14-12-31
 * Time:下午2:28
 */
public class HCZFPaymentUtil {

    public static String HCZF_MERNO;  //商号

    public static String MD5_KEY;  //MD5key

    public static String PAYMENT_URL; //支付地址

    public static String RETURN_URL; //ReturnURL

    public static String ADVICE_URL; //AdviceURL

    public static void init(String propertiesFileName) throws ResourceException {
        Properties p = PropertiesUtils.loadProperties(ResourceLoader.CLASSPATH_URL_PREFIX + "/" + propertiesFileName);
        HCZF_MERNO = p.getProperty("hczf.merno");
        MD5_KEY = p.getProperty("md5.key");
        PAYMENT_URL = p.getProperty("payment.url");
        RETURN_URL = p.getProperty("return.url");
        ADVICE_URL = p.getProperty("advice.url");
        if(StringUtils.isBlank(HCZF_MERNO) && StringUtils.isBlank(MD5_KEY) && StringUtils.isBlank(PAYMENT_URL) && StringUtils.isBlank(RETURN_URL) && StringUtils.isBlank(ADVICE_URL)) {
            throw new ResourceException("hczf not config. the properties file is: " + propertiesFileName);
        }
    }
}
