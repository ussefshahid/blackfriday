package com.indev.blackfriday;

public class Product{
    private int price;
    private String name;
    private int quantity;
    private int FIXED_QTE =5;

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

    public int asset(){
        return price*quantity;
    }

    public float sellPackage(float percentage, int double_quantity){
        quantity -= FIXED_QTE*double_quantity;
        return price*double_quantity*FIXED_QTE*(1+percentage);
    }
}