package com.sda.testingbasics.air;

public class Airplane {

    private int height;

    public Airplane() {
        this(0);
    }

    private Airplane(int height) {
        this.height = height;
    }

    public void ascent(int delta) {
        if(delta > 0) {
            height += delta;
        }
    }

    public void descent(int delta) {
        if(delta > 0) {
            if(delta > height) {
                height = 0;
                return;
            }
            height -= delta;
        }
    }

    public int getHeight() {
        return height;
    }
}
