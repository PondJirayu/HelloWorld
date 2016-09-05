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
        sum = intent.getIntExtra("result", 0); // เอา result ออกมา
        bundle = intent.getBundleExtra("cBundle"); // หยิบ Bundle ออกมาจาก intent
        c2 = (CoordinateSerializable) intent.getSerializableExtra("cSerializable"); // คี่กระดาษ(Serializable)ได้ object ออกมา

        Coordinate c1 = new Coordinate(bundle.getInt("x"), bundle.getInt("y"), bundle.getInt("z")); // เปิดซอง bundle เอาของที่อยู่ในซองออกมา
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
