package com.luxoft.shop.commander;

import com.luxoft.shop.view.ShopDialogUI;

import java.awt.*;
import java.util.List;

/**
 * Created by Ringo on 30.11.2016.
 */
public class ViewCommander implements ViewCommanderInterface{

    public final ShopDialogUI userInterface = new ShopDialogUI();

    public void makeVisible(boolean bool) {
        userInterface.setMinimumSize(new Dimension(600, 400));
        userInterface.setVisible(bool);
    }
    @Override
    public void showProducts(List<String> strings) {
        userInterface.showProducts(strings);
    }

    @Override
    public void showOrders(List<String> strings) {
        userInterface.showOrders(strings);
    }
}
