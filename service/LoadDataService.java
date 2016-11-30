package com.luxoft.shop.service;

import com.luxoft.shop.domain.product.Product;
import com.luxoft.shop.domain.shop.Shop;

/**
 * Created by Ringo on 29.11.2016.
 */
public interface LoadDataService {

    void loadProduct(Shop shop);

    void loadOrder(Shop shop);

    void loadCustomer(Shop shop);
}
