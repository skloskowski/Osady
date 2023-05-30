package org.example;

public abstract class Resources {
    public String getName() {
        return name;
    }

    private String name;
    public Resources(String name){
        this.name = name;
    }
}
