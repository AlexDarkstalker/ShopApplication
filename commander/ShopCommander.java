package com.luxoft.shop.commander;

import com.luxoft.shop.domain.shop.Shop;
import com.luxoft.shop.service.FileLoadDataService;
import com.luxoft.shop.service.LoadDataService;
import com.luxoft.shop.service.ShopService;
import com.luxoft.shop.service.ShopServiceImpl;

import java.util.List;

/**
 * Created by Ringo on 29.11.2016.
 */
public class ShopCommander {
    public static final Shop shop = new Shop();

    public static void createFromFile() {
        LoadDataService serv = new FileLoadDataService();
        serv.loadProduct(shop);
        serv.loadOrder(shop);
    }

    public static List<String> showProducts() {
        ShopService serv = new ShopServiceImpl();
        return serv.showProducts(shop);
    }

    public static List<String> showOrders() {
        ShopService serv = new ShopServiceImpl();
        return serv.showOrder(shop);
    }
}
