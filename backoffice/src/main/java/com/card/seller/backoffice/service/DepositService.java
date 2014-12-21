package com.card.seller.backoffice.service;

import com.card.seller.dao.DepositDao;
import com.card.seller.domain.Deposit;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

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
}
