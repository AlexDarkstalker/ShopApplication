package com.luxoft.shop.service;

import com.luxoft.shop.domain.customer.Customer;
import com.luxoft.shop.domain.order.Order;
import com.luxoft.shop.domain.product.Product;
import com.luxoft.shop.domain.shop.Shop;

import java.util.List;

/**
 * Created by Ringo on 29.11.2016.
 */
public interface ShopService {

    void addCustomer(Shop shop, Customer customer);
    void addProduct(Shop shop, Product product);
    void addOrder(Shop shop, Order order);

    List<String> showProducts(Shop shop);

    List<String> showOrder(Shop shop);
//    void removeCustomer(Shop shop, Order order);
//    void removeProduct(Shop shop, Product product);
//    void removeOrder(Shop shop, Order order);
}
