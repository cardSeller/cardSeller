package com.card.seller.backoffice.service;

import com.card.seller.dao.UserDao;
import com.card.seller.domain.User;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by minjie
 * Date:14-11-13
 * Time:下午4:00
 */
@Service
public class UserService {

    @Autowired
    private UserDao userDao;

    @Transactional
    public User getUserByName(String username) {
        User user = userDao.findUniqueByCriterion(new Criterion[]{
                Restrictions.eq("name", username),
        });
        return user;
    }
}
