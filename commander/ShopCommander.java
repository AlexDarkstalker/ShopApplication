package com.luxoft.shop.commander;

import com.luxoft.shop.domain.shop.Shop;
import com.luxoft.shop.service.FileLoadDataService;
import com.luxoft.shop.service.LoadDataService;
import com.luxoft.shop.service.ShopService;
import com.luxoft.shop.service.ShopServiceImpl;

import java.util.List;

/**
 *
 * Created by Ringo on 29.11.2016.
 */
public class ShopCommander implements ShopCommanderInterface{
    public final Shop shop = new Shop();

    public void createFromFile() {
        LoadDataService serv = new FileLoadDataService();
        serv.loadProduct(shop);
        serv.loadOrder(shop);
    }

    public List<String> showProducts() {
        ShopService serv = new ShopServiceImpl();
        return serv.showProducts(shop);
    }

    public List<String> showOrders() {
        ShopService serv = new ShopServiceImpl();
        return serv.showOrder(shop);
    }
}
