package com.popper.daw.bean;

public class RemakeBean {
    private String name;
    private String time;
    private String info;

    public RemakeBean(String name, String time, String info) {
        this.name = name;
        this.time = time;
        this.info = info;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }
}
