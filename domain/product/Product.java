package com.luxoft.shop.domain.product;

/**
 * Created by Ringo on 27.11.2016.
 */
public interface Product {


    String getTitle();

   void setTitle(String title);

    float getCost();

    void setCost(float cost);

    int getNumLeast();

    void setNumLeast(int numLeast) ;

    int getNumSold() ;

    void setNumSold(int numSold) ;

    String toString();
}
