package com.card.seller.portal.service;

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

    @Transactional
    public ItemPrice getItemPriceById(Long itemPriceId) {
        return itemPriceDao.get(itemPriceId);
    }

    @Transactional
    public Item getItemById(Long itemId) {
        return itemDao.get(itemId);
    }

    @Transactional
    public List<Item> getHomeItems() {
        return itemDao.getItemsByPosition("HOME");
    }

    @Transactional
    public List<Item> getItemsByInitial(String begin, String end) {
        return itemDao.getItemsByInitial(begin, end);
    }
}
