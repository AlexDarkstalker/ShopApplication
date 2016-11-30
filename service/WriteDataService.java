package com.luxoft.shop.service;

import com.luxoft.shop.domain.order.Order;
import com.luxoft.shop.domain.shop.Shop;

/**
 * Created by Ringo on 29.11.2016.
 */
public interface WriteDataService {
    void writeProducts(Shop shop);
    void writeOrders(Shop shop);

}
