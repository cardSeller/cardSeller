package com.card.seller.portal.service;

import com.card.seller.dao.DepositDao;
import com.card.seller.domain.DateUtil;
import com.card.seller.domain.Deposit;
import com.card.seller.domain.DepositStatus;
import com.card.seller.portal.domain.SearchPortalDepositRequest;
import com.card.seller.portal.domain.SearchPortalOrderRequest;
import com.google.common.collect.Maps;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Map;

/**
 * Created by minjie
 * Date:14-12-15
 * Time:下午5:23
 */
@Service
public class DepositService {

    @Autowired
    private DepositDao depositDao;

    @Transactional
    public void saveDeposit(Deposit deposit) {
        depositDao.save(deposit);
    }

    @Transactional
    public List<Deposit> getDeposits(SearchPortalDepositRequest searchPortalDepositRequest) {
        Map<String, Object> params = Maps.newHashMap();
        String query = queryString(searchPortalDepositRequest, params);
        return depositDao.getDeposits(query, params, (searchPortalDepositRequest.getPageIndex() - 1) * searchPortalDepositRequest.getPageSize(), searchPortalDepositRequest.getPageSize());
    }

    @Transactional
    public void chinapayVerify(String depositId) {
        Deposit deposit = depositDao.get(Long.valueOf(depositId));
        deposit.setDepositStatus(DepositStatus.DS);
        depositDao.update(deposit);
    }


    private String queryString(SearchPortalDepositRequest request, Map<String, Object> params) {
        StringBuilder builder = new StringBuilder();
        if (request.getMemberId() != null) {
            builder.append(" AND m.id = :memberId");
            params.put("memberId", request.getMemberId());
        }
        if (request.getDepositTimeFrom() != null) {
            builder.append(" AND d.deposit_date>=:depositTimeFrom");
            params.put("depositTimeFrom", DateUtil.withTimeAtStartOfDay(request.getDepositTimeFrom()));
        }
        if (request.getDepositTimeTo() != null) {
            builder.append(" AND d.deposit_date<=:depositTimeTo");
            params.put("depositTimeTo", DateUtil.withTimeAtEndOfDay(request.getDepositTimeTo()));
        }
        return builder.toString();

    }

    @Transactional
    public Long getDepositsTotal(SearchPortalDepositRequest searchPortalDepositRequest) {
        Map<String, Object> params = Maps.newHashMap();
        String query = queryString(searchPortalDepositRequest, params);
        return depositDao.getDepositTotal(query, params);
    }
}
