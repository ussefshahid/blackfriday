package com.indev.blackfriday;

public class Product{
    private int price;
    private String name;
    private int quantity;
    private float sellingPrince;

    public Product() {
    }

    public Product(int quantity, String name, int price) {
        this.price = price;
        this.name = name;
        this.quantity = quantity;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    boolean isEmpty(){
        return (quantity==0);
    }

    @Override
    public String toString() {
        return "Product{" +
                "price=" + price +
                ", name='" + name + '\'' +
                ", quantity=" + quantity +
                '}';
    }

    public float sells(float percentage){
        return sellingPrince = price*=(5+percentage);
    }

    public int asset(){
        return price*quantity;
    }
}