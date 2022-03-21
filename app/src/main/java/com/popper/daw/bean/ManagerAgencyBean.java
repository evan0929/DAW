package com.popper.daw.bean;

public class ManagerAgencyBean {
    private String jName;
    private String time;
    private String name;
    private int progress;

    public ManagerAgencyBean(String jName, String time, String name, int progress) {
        this.jName = jName;
        this.time = time;
        this.name = name;
        this.progress = progress;
    }

    public String getjName() {
        return jName;
    }

    public void setjName(String jName) {
        this.jName = jName;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getProgress() {
        return progress;
    }

    public void setProgress(int progress) {
        this.progress = progress;
    }
}
