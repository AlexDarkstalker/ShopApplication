package com.luxoft.shop.domain.shop;

import com.luxoft.shop.domain.customer.Customer;
import com.luxoft.shop.domain.order.Order;
import com.luxoft.shop.domain.product.Product;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Ringo on 27.11.2016.
 */
public class Shop implements Shopable {
    private List<Customer> customers;
    private List<Product> products;
    private List<Order> orders;

    public Shop() {
        this.customers = new ArrayList<>();
        this.products = new ArrayList<>();
        this.orders = new ArrayList<>();
    }

    public void addCustomer(Customer customer) {
        this.customers.add(customer);
    }

    public void addProduct(Product product) {
        if(this.products.contains(product)) {
            Product addingProduct = products.get(products.indexOf(product));
            int oldNum = addingProduct.getNumLeast();
            addingProduct.setNumLeast(oldNum + product.getNumLeast());
        }
        else
            this.products.add(product);

    }

    public List<Order> getOrders() {
        return orders;
    }

    public List<Product> getProducts() {

        return products;
    }

    public void addOrder(Order order) {
        this.orders.add(order);
    }

    @Override
    public String toString() {
        return this.customers.toString() + this.products.toString();
    }

    public List<String> productsToString() {
        List<String> productStrings = new ArrayList<>();
        for(Product p: products)
            productStrings.add(p.toString());
        return productStrings;
    }

    public List<String> ordersToString() {
        List<String> orderStrings = new ArrayList<>();
        for(Order o : orders)
            orderStrings.add(o.toString());
        return orderStrings;
    }
}
