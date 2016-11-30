package com.luxoft.shop;

import com.luxoft.shop.commander.ShopCommander;
import com.luxoft.shop.commander.ShopCommanderInterface;
import com.luxoft.shop.commander.ViewCommander;
import com.luxoft.shop.commander.ViewCommanderInterface;

/**
 * Created by Ringo on 27.11.2016.
 */
public class Launcher {
    public static void main(String[] args) {
        ShopCommanderInterface shopCommandInterface = new ShopCommander();
        ViewCommanderInterface shopViewInterface = new ViewCommander();
        shopCommandInterface.createFromFile();
        shopViewInterface.showProducts(shopCommandInterface.showProducts());
        shopViewInterface.makeVisible(true);
        //System.out.println(shopCommandInterface.showProducts());
        //System.out.println(shopCommandInterface.showOrders());

    }
}
