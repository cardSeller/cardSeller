package com.card.seller.dao;

import com.card.seller.dao.hibernate.HibernateSupportDao;
import com.card.seller.domain.Deposit;
import com.card.seller.domain.DepositManageSearch;
import com.card.seller.domain.Orders;
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

    public List<DepositManageSearch> getDeposits(String queryString, Map<String, Object> params, int offset, int fetchSize) {
        StringBuilder builder = new StringBuilder();
        builder.append("select d.id as id,d.member_id as memberId,d.total as total,d.deposit_date as depositDate,d.deposit_status as depositStatus,d.deposit_type as depositType,d.deposit_type as depositTypeEN,null as member ");
        builder.append("from deposit d ");
        builder.append("inner join member m on m.id=d.member_id ");
        builder.append("where 1=1 ");
        builder.append(queryString);
        builder.append(" order by d.deposit_date desc");
        return findBySQLQuery(builder.toString(), null, DepositManageSearch.class, params, offset, fetchSize);
    }

    public Long getDepositTotal(String queryString, Map<String, Object> params) {
        StringBuilder builder = new StringBuilder();
        builder.append("select d.id as id,d.member_id as memberId,d.total as total,d.deposit_date as depositDate,d.deposit_status as depositStatus,d.deposit_type as depositType,d.deposit_type as depositTypeEN,null as member ");
        builder.append("from deposit d ");
        builder.append("inner join member m on m.id=d.member_id ");
        builder.append("where 1=1 ");
        builder.append(queryString);
        builder.append(" order by d.deposit_date desc");
        List<Orders> list = findBySQLQuery(builder.toString(), null, DepositManageSearch.class, params);
        if (list == null) {
            return 0L;
        }
        return Long.valueOf(list.size());
    }
}
