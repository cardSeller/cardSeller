package com.card.seller.backoffice.service;

import com.card.seller.dao.ItemDao;
import com.card.seller.dao.ItemPriceDao;
import com.card.seller.domain.Item;
import com.card.seller.domain.ItemPrice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by minjie
 * Date:14-12-11
 * Time:下午9:24
 */
@Service
public class ItemService {

    @Autowired
    private ItemDao itemDao;

    @Autowired
    private ItemPriceDao itemPriceDao;

    @Transactional
    public List<Item> getAllItems() {
        return itemDao.getAll();
    }

    @Transactional
    public List<ItemPrice> getAllItemPrices() {
        return itemPriceDao.getAll();
    }

    @Transactional
    public List<ItemPrice> getItemPricesByItemId(Long itemId) {
        return itemPriceDao.getItemPriceListByItemId(itemId);
    }

}
