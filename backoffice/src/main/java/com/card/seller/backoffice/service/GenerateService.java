package com.card.seller.backoffice.service;

import com.card.seller.backoffice.constant.BoConstant;
import com.card.seller.domain.DateUtil;
import org.apache.shiro.crypto.RandomNumberGenerator;
import org.apache.shiro.crypto.SecureRandomNumberGenerator;
import org.apache.shiro.crypto.hash.Sha256Hash;
import org.apache.shiro.util.ByteSource;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.inject.Inject;
import java.util.Date;

/**
 * User: rojack.min
 * Date: 14-3-5
 * Time: 上午10:43
 */
@Service
public class GenerateService {

    public ByteSource generateUserSalt() {
        RandomNumberGenerator rng = new SecureRandomNumberGenerator();
        ByteSource salt = rng.nextBytes();
        return salt;
    }


    public String generatEncryptPassWord(String password, ByteSource salt) {
        return new Sha256Hash(password, salt, BoConstant.HASH_INTERATIONS).toBase64();
    }

//    @Inject
//    private OrdersDao ordersDao;
//
//    @Transactional
//    public String generateOrderNumber(Date date) {
//        Long todayCount = ordersDao.countByDate(date);
//        String dateStr = DateUtil.dateToString("yyyyMMdd", date);
//        Long suffix = 1L;
//        if (todayCount > 0) {
//            suffix = todayCount + 1;
//        }
//        return "D" + dateStr + String.format("%04d", suffix);
//    }
}
