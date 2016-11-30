package com.luxoft.shop.service;

import com.luxoft.shop.domain.customer.Customer;
import com.luxoft.shop.domain.order.Order;
import com.luxoft.shop.domain.product.Product;
import com.luxoft.shop.domain.shop.Shop;

import java.util.List;

/**
 * Created by Ringo on 29.11.2016.
 */
public class ShopServiceImpl implements ShopService {
    @Override
    public void addCustomer(Shop shop, Customer customer) {
        shop.addCustomer(customer);
    }

    @Override
    public void addProduct(Shop shop, Product product) {
        shop.addProduct(product);
    }

    @Override
    public void addOrder(Shop shop, Order order) {
        shop.addOrder(order);
    }

    @Override
    public List<String> showProducts(Shop shop) {
        return shop.productsToString();
    }

    @Override
    public List<String> showOrder(Shop shop) {
        return shop.ordersToString();
    }

//    @Override
//    public void removeCustomer(Shop shop, Order order) {
//
//    }
//
//    @Override
//    public void removeProduct(Shop shop, Product product) {
//
//    }
//
//    @Override
//    public void removeOrder(Shop shop, Order order) {
//
//    }
}
