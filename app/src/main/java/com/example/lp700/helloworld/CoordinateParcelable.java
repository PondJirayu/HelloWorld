package com.example.lp700.helloworld;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by lp700 on 5/9/2559.
 */
public class CoordinateParcelable implements Parcelable{

    private int x, y, z;

    public CoordinateParcelable() {
        this(0, 0, 0);
    }

    public CoordinateParcelable(int x, int y, int z) {
        setX(x);
        setY(y);
        setZ(z);
    }

    // แปลงกระดาษเป็น Object
    protected CoordinateParcelable(Parcel in) {
        x = in.readInt();
        y = in.readInt();
        z = in.readInt();
    }

    public static final Creator<CoordinateParcelable> CREATOR = new Creator<CoordinateParcelable>() {
        @Override
        public CoordinateParcelable createFromParcel(Parcel in) {
            return new CoordinateParcelable(in);
        }

        @Override
        public CoordinateParcelable[] newArray(int size) {
            return new CoordinateParcelable[size];
        }
    };

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

    @Override
    public int describeContents() {
        return 0;
    }

    // แปลง Object เป็นกระดาษ
    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(x);
        dest.writeInt(y);
        dest.writeInt(z);
    }
}
