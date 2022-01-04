package com;

public class MyTank extends Tank{

    public MyTank(int x, int y, int direct, int speed) {
        super(x, y, direct, speed);
    }
    private int type = 1;

    public int getType() {
        return type;
    }
}