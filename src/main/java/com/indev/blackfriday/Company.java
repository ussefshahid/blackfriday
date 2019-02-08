package com.indev.blackfriday;

import java.util.ArrayList;
import java.util.List;

public class Company {
    private static final int FIXED_QTE = 5;
    private static float FIXED_PERCENTAGE = 0.20f;
    private List<Product> productList;
    private int total_sells=0;
    private int DOUBLE_PRICE=1;

    public Company(){
        init();
    }

    public void init(){
        productList=new ArrayList<Product>();
    }

    public float sells(String capsule) {
        Product product=getByName(capsule);
        if(product.isEmpty()) throw new RuntimeException();
        product.setQuantity(product.getQuantity()- FIXED_QTE);

        setTotalSells(product.getPrice()*DOUBLE_PRICE*FIXED_QTE*(1+FIXED_PERCENTAGE));
        return product.getPrice()*DOUBLE_PRICE*FIXED_QTE*(1+FIXED_PERCENTAGE);
    }

    public void stock(int quantity, String capsule, int price) {
        productList.add(new Product(quantity, capsule, price));
    }

    public Company to(int i) {
        return this;
    }

    public float computeBenefit() {
        return 0;
    }

    public int totalAssets() {
        return total_sells+this.productList.stream()
                .mapToInt(product -> product.getPrice()*product.getQuantity())
                .sum();
    }

    public Company blackFriday() {
//        FIXED_PERCENTAGE=0.1f;
//        DOUBLE_PRICE=2;
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
