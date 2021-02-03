package com.udacity.jdnd.course3.Entity;

import javax.persistence.Entity;

@Entity
public class Shurb extends Plant{
    private double height;
    private double width;

    //GETTER AND SETTER
    public double getHeight() {
        return height;
    }

    public void setHeight(double height) {
        this.height = height;
    }

    public double getWidth() {
        return width;
    }

    public void setWidth(double width) {
        this.width = width;
    }
}
