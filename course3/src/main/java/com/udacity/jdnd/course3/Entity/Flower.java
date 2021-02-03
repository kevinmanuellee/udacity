package com.udacity.jdnd.course3.Entity;

import org.hibernate.annotations.Nationalized;

import javax.persistence.*;

@Entity
//@Table(name = "Plant")
public class Flower extends Plant{

    private String colour;

    // GETTER & SETTER

    public String getColour() {
        return colour;
    }

    public void setColour(String colour) {
        this.colour = colour;
    }

}
