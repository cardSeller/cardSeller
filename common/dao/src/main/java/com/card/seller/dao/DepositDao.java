package com.card.seller.dao;

import com.card.seller.dao.hibernate.HibernateSupportDao;
import com.card.seller.domain.Deposit;
import org.springframework.stereotype.Repository;

/**
 * Created by minjie
 * Date:14-12-15
 * Time:下午4:29
 */
@Repository
public class DepositDao extends HibernateSupportDao<Deposit, Long> {
}
