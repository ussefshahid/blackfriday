package com.indev.blackfriday;

import java.util.ArrayList;
import java.util.List;

public class Company {
    private float FIXED_PERCENTAGE = 0.20f;
    private List<Product> productList;
    private int total_sells=0;
    private int DOUBLE_QUANTITY=1;

    public Company(){
        init();
    }

    public void init(){
        productList=new ArrayList<>();
    }

    public float sells(String capsule) {
        Product product=getByName(capsule);
        if(product.isEmpty()) throw new RuntimeException();

        float soldProduct=product.sellPackage(FIXED_PERCENTAGE, DOUBLE_QUANTITY);

        setTotalSells(soldProduct);
        return soldProduct;
    }

    public void stock(int quantity, String capsule, int QUANTITY) {
        productList.add(new Product(quantity, capsule, QUANTITY));
    }

    public Company to(int i) {
        return this;
    }

    public float computeBenefit() {
        return 0;
    }

    public int totalAssets() {
        DOUBLE_QUANTITY=1;
        FIXED_PERCENTAGE=0.2f;

        System.out.println(total_sells+" / "+productList+" ###");
        return total_sells+this.productList.stream()
                .mapToInt(product -> product.asset())
                .sum();
    }

    public Company blackFriday() {
        DOUBLE_QUANTITY=2;
        FIXED_PERCENTAGE=0.1f;

        return this;
    }

    private Product getByName(String name){
        return productList.stream()
                .filter(product -> product.getName().equals(name))
                .findFirst()
                .orElse(null);
    }

    private void setTotalSells(float mount){
        total_sells+=mount;
    }
}
