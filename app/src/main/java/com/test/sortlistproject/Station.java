package com.test.sortlistproject;

public class Station {
    private String name;
    private int fromIkebukuro;
    private int alphabetOrder;
    boolean express;

    public Station(){

    }
    public Station(String n, int f, int a, boolean e){
        this.name = n;
        this.fromIkebukuro = f;
        this.alphabetOrder = a;
        this.express = e;
    }

    public String getName() {
        return name;
    }

    public int getFromIkebukuro() {
        return fromIkebukuro;
    }

    public int getAlphabetOrder() {
        return alphabetOrder;
    }

    public boolean isExpress() {
        return express;
    }
}
