package com.card.seller.portal.service;

import com.card.seller.dao.DepositDao;
import com.card.seller.domain.Deposit;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

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
    public List<Deposit> getDepositsByMemberId(Long memberId) {
        return depositDao.getDepositsByMemberId(memberId);
    }
}
