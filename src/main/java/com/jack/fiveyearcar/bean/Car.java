package com.jack.fiveyearcar.bean;

import org.springframework.stereotype.Component;

@Component
public class Car {

    private int xPosition;
    private int yPosition;
    private String orientation;

    public Car() {
        xPosition=1;
        yPosition=1;
        orientation="north";
    }

    public Car(int xPosition, int yPosition, String orientation) {
        this.xPosition = xPosition;
        this.yPosition = yPosition;
        this.orientation = orientation;
    }

    public int getxPosition() {
        return xPosition;
    }

    public void setxPosition(int xPosition) {
        this.xPosition = xPosition;
    }

    public int getyPosition() {
        return yPosition;
    }

    public void setyPosition(int yPosition) {
        this.yPosition = yPosition;
    }

    public String getOrientation() {
        return orientation;
    }

    public void setOrientation(String orientation) {
        this.orientation = orientation;
    }

    @Override
    public String toString() {
        return "Car{" +
                "xPosition='" + xPosition + '\'' +
                ", yPosition='" + yPosition + '\'' +
                ", orientation='" + orientation + '\'' +
                '}';
    }
}
