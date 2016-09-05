package com.example.lp700.helloworld;

import java.io.Serializable;

/**
 * Created by lp700 on 5/9/2559.
 */
public class CoordinateSerializable implements Serializable{

    private int x, y, z;

    public CoordinateSerializable() {
        this(0, 0, 0);
    }

    public CoordinateSerializable(int x, int y, int z) {
        setX(x);
        setY(y);
        setZ(z);
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public int getZ() {
        return z;
    }

    public void setZ(int z) {
        this.z = z;
    }
}
