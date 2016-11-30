package com.luxoft.shop.commander;

import java.util.List;

/**
 * Created by Ringo on 30.11.2016.
 */
public interface ShopCommanderInterface {
    public void createFromFile();

    public List<String> showProducts();

    public List<String> showOrders();

}
