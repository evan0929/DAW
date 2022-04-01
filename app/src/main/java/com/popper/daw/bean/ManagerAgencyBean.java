package com.popper.daw.bean;

public class ManagerAgencyBean {
    private String jName;
    private String money;
    private String name;
    private String level;
    private String city;

    public ManagerAgencyBean(String jName, String money, String name, String level, String city) {
        this.jName = jName;
        this.money = money;
        this.name = name;
        this.level = level;
        this.city = city;
    }

    public String getjName() {
        return jName;
    }

    public void setjName(String jName) {
        this.jName = jName;
    }

    public String getMoney() {
        return money;
    }

    public void setMoney(String money) {
        this.money = money;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLevel() {
        return level;
    }

    public void setLevel(String level) {
        this.level = level;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }
}
