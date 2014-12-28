package com.card.seller.dao;

import com.card.seller.dao.hibernate.HibernateSupportDao;
import com.card.seller.domain.Deposit;
import com.google.common.collect.Maps;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

/**
 * Created by minjie
 * Date:14-12-15
 * Time:下午4:29
 */
@Repository
public class DepositDao extends HibernateSupportDao<Deposit, Long> {
    public List<Deposit> getDepositsByMemberId(Long memberId) {
        Map<String, Object> map = Maps.newHashMap();
        map.put("memberId", memberId);
        return findByQuery("from " + Deposit.class.getName() + " where memberId=:memberId", map);
    }
}
