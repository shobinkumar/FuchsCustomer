package com.customer.model;

public class ProductListModel {
    String product_name;


    public ProductListModel(String product_name) {
        this.product_name = product_name;
    }

    public String getProduct_name() {
        return product_name;
    }

    public void setProduct_name(String product_name) {
        this.product_name = product_name;
    }
}
