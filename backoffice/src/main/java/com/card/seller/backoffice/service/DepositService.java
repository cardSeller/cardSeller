package com.card.seller.backoffice.service;

import com.card.seller.backoffice.domain.SearchDepositRequest;
import com.card.seller.dao.DepositDao;
import com.card.seller.domain.DateUtil;
import com.card.seller.domain.Deposit;
import com.card.seller.domain.DepositManageSearch;
import com.google.common.collect.Maps;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Map;

/**
 * Created by minjie
 * Date:14-12-20
 * Time:下午4:02
 */
@Service
public class DepositService {

    @Autowired
    private DepositDao depositDao;

    public List<Deposit> getAllDeposits() {
        return depositDao.getAll();
    }

    @Transactional
    public Long getDepositsTotal(SearchDepositRequest searchDepositRequest) {
        Map<String, Object> params = Maps.newHashMap();
        String query = queryString(searchDepositRequest, params);
        return depositDao.getDepositTotal(query, params);
    }

    @Transactional
    public List<DepositManageSearch> getDeposits(SearchDepositRequest searchDepositRequest) {
        Map<String, Object> params = Maps.newHashMap();
        String query = queryString(searchDepositRequest, params);
        return depositDao.getDeposits(query, params, (searchDepositRequest.getPageIndex() - 1) * searchDepositRequest.getPageSize(), searchDepositRequest.getPageSize());
    }

    private String queryString(SearchDepositRequest request, Map<String, Object> params) {
        StringBuilder builder = new StringBuilder();
        if (StringUtils.isNotBlank(request.getMemberName())) {
            builder.append(" AND UPPER(m.name) like :memberName");
            params.put("memberName", "%" + request.getMemberName().toUpperCase() + "%");
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
}
