package com.luxoft.shop.service;

import com.luxoft.shop.domain.customer.Customer;
import com.luxoft.shop.domain.order.Order;
import com.luxoft.shop.domain.product.Product;
import com.luxoft.shop.domain.product.Toy;
import com.luxoft.shop.domain.shop.Shop;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.*;

/**
 *
 * Created by Ringo on 29.11.2016.
 */
public class FileLoadDataService implements LoadDataService {

    private final File fileProduct = new File(".\\files\\feeds.product");
    private final File fileOrders = new File(".\\files\\feeds.order");

    private List<Product> loadProductData() throws FileNotFoundException {
        List<Product> products = new ArrayList<>();
        Map<String,String> map = new HashMap<>();
        Scanner scan = createScan(fileProduct);
        String line;
        while(scan.hasNext()) {
            line = scan.nextLine();
            String[] newLines = line.split(",");
            for(String str: newLines) {
                map.put(str.split("=")[0], str.split("=")[1]);
            }
            Product product = parseProductData(map);
            products.add(product);
        }
        return products;
    }

    private Scanner createScan(File file) throws FileNotFoundException {
        return new Scanner(new BufferedInputStream(new FileInputStream(file)));
    }

    private Product parseProductData(Map<String, String> map) {
        Product product = new Toy();
        product.setTitle(map.get("Title"));
        product.setCost(Float.parseFloat(map.get("Cost")));
        product.setNumLeast(Integer.parseInt(map.get("Least")));
        product.setNumSold(Integer.parseInt(map.get("Sold")));
        return product;
    }

    private List<Order> loadOrderData() throws FileNotFoundException {
        List<Order> orders = new ArrayList<>();
        //Map<String,String> map = new HashMap<>();
        List<String> data = new ArrayList<>();
        Scanner scan = createScan(fileOrders);
        String line;
        while(scan.hasNext()) {
            line = scan.nextLine();
            String[] newLines = line.split(",");
            for(String str: newLines) {
                data.add(str);
            }
            Order order = parseOrderData(data);
            orders.add(order);
        }
        return orders;
    }

    private Order parseOrderData(List<String> data) {
        Order order = new Order();

        Map<Product, Integer> prodsInOrderFromFile = new HashMap<>();
        order.setCustomer(new Customer(data.get(0)));
        for(int i = 1; i < data.size(); i+=5)
        {
            Product product = new Toy();
            product.setTitle(data.get(i));
            product.setCost(Float.valueOf(data.get(i+1)));
            product.setNumLeast(Integer.valueOf(data.get(i+2)));
            product.setNumSold(Integer.valueOf(data.get(i+3)));
            order.addProduct(product, Integer.valueOf(data.get(i+4)));
        }

        return order;
    }

    private void loadProductsToShop(Shop shop, List<Product> products) {
        for(Product p : products)
            shop.addProduct(p);
    }

    private void loadOrdersToShop(Shop shop, List<Order> orders) {
        for(Order o : orders)
            shop.addOrder(o);
    }
    @Override
    public void loadProduct(Shop shop) {
        try {
            loadProductsToShop(shop, loadProductData());
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

    }

    @Override
    public void loadOrder(Shop shop) {
        try {
            loadOrdersToShop(shop, loadOrderData());
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void loadCustomer(Shop shop) {

    }
}
