package com.card.seller.dao;

import com.card.seller.dao.hibernate.HibernateSupportDao;
import com.card.seller.domain.User;
import org.springframework.stereotype.Repository;

/**
 * Created by minjie
 * Date:14-11-10
 * Time:下午9:25
 */
@Repository
public class UserDao extends HibernateSupportDao<User, Long> {
}
