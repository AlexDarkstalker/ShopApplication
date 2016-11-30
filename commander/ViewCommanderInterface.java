package com.luxoft.shop.commander;

import java.util.List;

/**
 *
 * Created by Ringo on 30.11.2016.
 */
public interface ViewCommanderInterface {

    public void makeVisible(boolean bool);

    void showProducts(List<String> strings);

    void showOrders(List<String> strings);

    
}
