package com.luxoft.shop;

import com.luxoft.shop.commander.ShopCommander;

/**
 * Created by Ringo on 27.11.2016.
 */
public class Launcher {
    public static void main(String[] args) {
        ShopCommander.createFromFile();
        System.out.println(ShopCommander.showProducts());
        System.out.println(ShopCommander.showOrders());

    }
}
