package com.luxoft.shop.domain.product;

/**
 * Created by Ringo on 29.11.2016.
 */
public class Toy implements Product {
    private String title;
    private float cost;
    private int numLeast;
    private int numSold;

    @Override
    public String getTitle() {
        return title;
    }

    @Override
    public void setTitle(String title) {
        this.title = title;
    }

    @Override
    public float getCost() {
        return cost;
    }

    @Override
    public void setCost(float cost) {
        this.cost = cost;
    }

    @Override
    public int getNumLeast() {
        return numLeast;
    }

    @Override
    public void setNumLeast(int numLeast) {
        this.numLeast = numLeast;
    }

    @Override
    public int getNumSold() {
        return numSold;
    }

    @Override
    public void setNumSold(int numSold) {
        this.numSold = numSold;
    }

    @Override
    public String toString() {
        return title + " $" + String.valueOf(cost) + " " + numLeast + " " + numSold + "\n";
    }
}
