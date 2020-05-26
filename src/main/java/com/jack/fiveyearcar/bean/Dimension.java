package com.jack.fiveyearcar.bean;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class Dimension {

    private int xBorder;
    private int yBorder;

    public Dimension(){

    }

    public Dimension(int xBorder, int yBorder) {
        this.xBorder = xBorder;
        this.yBorder = yBorder;
    }

    public int getxBorder() {
        return xBorder;
    }

    public void setxBorder(int xBorder) {
        this.xBorder = xBorder;
    }

    public int getyBorder() {
        return yBorder;
    }

    public void setyBorder(int yBorder) {
        this.yBorder = yBorder;
    }

    @Override
    public String toString() {
        return "Dimension{" +
                "xBorder=" + xBorder +
                ", yBorder=" + yBorder +
                '}';
    }
}
