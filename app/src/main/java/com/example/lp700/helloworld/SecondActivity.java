package com.example.lp700.helloworld;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class SecondActivity extends Activity {

    TextView tvResult;
    int sum = 0;
    Bundle bundle;
    CoordinateSerializable c2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        Intent intent = getIntent(); // เปิดซองจดหมาย
        sum = intent.getIntExtra("result", 0); // เอา result ออกมา (Primitive Type)
        bundle = intent.getBundleExtra("cBundle"); // หยิบ Bundle ออกมาจาก intent (Object)
        c2 = (CoordinateSerializable) intent.getSerializableExtra("cSerializable"); // คี่กระดาษ(Serializable)ได้ object ออกมา (Object)

        // เปิดซอง bundle เอาของที่อยู่ในซองออกมา และประกอบเป็น Object
        Coordinate c1 = new Coordinate(bundle.getInt("x"), bundle.getInt("y"), bundle.getInt("z"));
//        c1.setX(bundle.getInt("x"));
//        c1.setY(bundle.getInt("y"));
//        c1.setZ(bundle.getInt("z"));
        initInstances();
    }

    private void initInstances() {
        tvResult = (TextView) findViewById(R.id.tvResult);
        tvResult.setText("Result " + sum);
    }
}
