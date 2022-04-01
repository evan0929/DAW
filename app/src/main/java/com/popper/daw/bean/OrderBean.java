package com.popper.daw.bean;

public class OrderBean {
    private String code;
    private String name;
    private int number;
    private int money;
    private int price;

    public OrderBean(String code, String name, int number, int money, int price) {
        this.code = code;
        this.name = name;
        this.number = number;
        this.money = money;
        this.price = price;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public int getMoney() {
        return money;
    }

    public void setMoney(int money) {
        this.money = money;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }
}
