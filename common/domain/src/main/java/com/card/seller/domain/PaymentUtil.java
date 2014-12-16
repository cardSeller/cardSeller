package com.card.seller.domain;

import org.apache.commons.lang3.StringUtils;
import org.springframework.core.io.ResourceLoader;

import java.util.Properties;

public class PaymentUtil {

    public static String CHINAPAY_VERSION; //版本
    public static String CHINAPAY_MERID;  //商号
    public static String CHINAPAY_MERKEY_FILEPATH; //私有密钥路径
    public static String CHINAPAY_PUBKEY_FILEPATH; //公有密钥
    public static String CHINAPAY_PAYMENT_URL;  //支付地址
    public static String CHINAPAY_REFUND_URL;  //退款地址
    public static String CHINAPAY_QUERY_URL;  //查询地址
    public static String CHINAPAY_BGRETURL;  //应答回调
    public static String CHINAPAY_PAGERETURL; //页面回调
    public static String CHINAPAY_CURYID; //币种


    public static void init(String propertiesFileName) throws ResourceException {
        Properties p = PropertiesUtils.loadProperties(ResourceLoader.CLASSPATH_URL_PREFIX + "/" + propertiesFileName);
        CHINAPAY_VERSION = p.getProperty("chinapay.version");
        CHINAPAY_MERID = p.getProperty("chinapay.merid");
        CHINAPAY_MERKEY_FILEPATH = p.getProperty("chinapay.merkey.filepath");
        CHINAPAY_PUBKEY_FILEPATH = p.getProperty("chinapay.pubkey.filepath");
        CHINAPAY_PAYMENT_URL = p.getProperty("chinapay.payment.url");
        CHINAPAY_REFUND_URL = p.getProperty("chinapay.refund.url");
        CHINAPAY_QUERY_URL = p.getProperty("chinapay.query.url");
        CHINAPAY_BGRETURL = p.getProperty("chinapay.bgreturl");
        CHINAPAY_PAGERETURL = p.getProperty("chinapay.pagereturl");
        CHINAPAY_CURYID = p.getProperty("chinapay.curyid");
        if (StringUtils.isBlank(CHINAPAY_MERID) && StringUtils.isBlank(CHINAPAY_MERKEY_FILEPATH)
                && StringUtils.isBlank(CHINAPAY_PUBKEY_FILEPATH) && StringUtils.isBlank(CHINAPAY_PAYMENT_URL)
                && StringUtils.isBlank(CHINAPAY_REFUND_URL) && StringUtils.isBlank(CHINAPAY_QUERY_URL)
                && StringUtils.isBlank(CHINAPAY_VERSION) && StringUtils.isBlank(CHINAPAY_BGRETURL) && StringUtils.isBlank(CHINAPAY_PAGERETURL)) {
            throw new ResourceException("chinapayment not config. the properties file is: " + propertiesFileName);
        }
    }
}
