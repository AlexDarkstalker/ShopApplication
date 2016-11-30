package com.luxoft.shop.service;

import com.luxoft.shop.domain.order.Order;
import com.luxoft.shop.domain.product.Product;
import com.luxoft.shop.domain.shop.Shop;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

/**
 * Created by Ringo on 30.11.2016.
 */
public class FileWriteDataService implements WriteDataService {
    private final File fileProduct = new File(".\\files\\feeds.product");
    private final File fileOrders = new File(".\\files\\feeds.order");

    private void writeProduct(FileWriter fw, Product p) throws IOException {
        fw.write("Title="+p.getTitle()+",");
        fw.write("Cost="+p.getCost()+",");
        fw.write("Least="+p.getNumLeast()+",");
        fw.write("Sold="+p.getNumSold());
        fw.write("\n");
        fw.flush();
    }
    @Override
    public void writeProducts(Shop shop) {
        try {
            FileWriter fw = new FileWriter(fileProduct);
            for(Product p: shop.getProducts()){
                writeProduct(fw,p);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void writeOrder(FileWriter fw, Order o) {
        try {
            fw.write(o.getCustomer()+",");
            for(Product p:o.getProductsInOrder().keySet()){
                fw.write(p.getTitle()+",");
                fw.write(p.getCost()+",");
                fw.write(p.getNumLeast()+",");
                fw.write(p.getNumSold()+",");
                fw.write(o.getProductsInOrder().get(p));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    @Override
    public void writeOrders(Shop shop) {
        try {
            FileWriter fw = new FileWriter(fileOrders);
            for(Order o:shop.getOrders()) {
                writeOrder(fw, o);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
