package com.luxoft.shop.domain.order;

import com.luxoft.shop.domain.customer.Customer;
import com.luxoft.shop.domain.product.Product;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Ringo on 28.11.2016.
 */
public class Order {
    private Customer customer;
    private Map<Product, Integer> productsInOrder;


    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public Map<Product, Integer> getProductsInOrder() {
        return productsInOrder;
    }

    public void setProductsInOrder(Map<Product, Integer> productsInOrder) {
        this.productsInOrder = productsInOrder;
    }


    public Order() {
        this.productsInOrder = new HashMap<>();
    }

    public void addProduct(Product product, int numProduct) {
        int oldNum;
        if(productsInOrder.containsKey(product)) {
            oldNum = productsInOrder.get(product);
            productsInOrder.replace(product, oldNum, oldNum + numProduct);
        }
        else
            productsInOrder.put(product, numProduct);
    }


    @Override
    public String toString() {
        StringBuilder strBld = new StringBuilder();
        strBld.append(customer.toString());
        strBld.append(productsInOrder.toString());
        return strBld.toString();
    }
}
