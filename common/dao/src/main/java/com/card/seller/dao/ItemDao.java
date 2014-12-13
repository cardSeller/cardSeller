package com.card.seller.dao;

import com.card.seller.dao.hibernate.HibernateSupportDao;
import com.card.seller.domain.Item;
import org.springframework.stereotype.Repository;

/**
 * Created by minjie
 * Date:14-12-11
 * Time:下午5:33
 */
@Repository
public class ItemDao extends HibernateSupportDao<Item, Long> {
}
