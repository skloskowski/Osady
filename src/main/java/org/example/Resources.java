package org.example;

public abstract class Resources {
    /***
     * returns name of resource
     * @return name of a resource
     */
    public String getName() {
        return name;
    }
    private String name;
    public Resources(String name){
        this.name = name;
    }
}
