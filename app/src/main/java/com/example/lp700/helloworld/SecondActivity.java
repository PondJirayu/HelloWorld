package com.example.lp700.helloworld;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class SecondActivity extends Activity implements View.OnClickListener {

    TextView tvResult;
    int sum = 0;
    Bundle bundle;
    CoordinateSerializable c2;
    CoordinateParcelable c3;
    Button btnOk;
    EditText editTextHola;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        Intent intent = getIntent(); // เปิดซองจดหมาย(intent)
        sum = intent.getIntExtra("result", 0); // เอา result ออกมา(Primitive Type)
        bundle = intent.getBundleExtra("cBundle"); // หยิบซอง Bundle ออกมาจากซอง(intent)
        c2 = (CoordinateSerializable) intent.getSerializableExtra("cSerializable"); // คี่กระดาษ(Serializable)ออกมาได้(Object)
        c3 = intent.getParcelableExtra("cParcelable"); // หยิบกล่องพัสดุ(Parcelable)ออกมาจากซอง(intent)และเปิดกล่องพัสดุออกมาได้(Object)

        // เปิดซอง bundle เอาของที่อยู่ในซองออกมาและประกอบเป็น(Object)
        Coordinate c1 = new Coordinate(bundle.getInt("x"), bundle.getInt("y"), bundle.getInt("z"));
//        c1.setX(bundle.getInt("x"));
//        c1.setY(bundle.getInt("y"));
//        c1.setZ(bundle.getInt("z"));

        initInstances();
    }

    private void initInstances() {
        tvResult = (TextView) findViewById(R.id.tvResult);
        btnOk = (Button) findViewById(R.id.btnOk);
        editTextHola = (EditText) findViewById(R.id.editTextHola);

        tvResult.setText("Result " + sum);

        btnOk.setOnClickListener(this);
    }


    @Override
    protected void onStart() {
        super.onStart();
    }

    @Override
    protected void onResume() {
        super.onResume();
    }

    @Override
    protected void onPause() {
        super.onPause();
    }

    @Override
    protected void onStop() {
        super.onStop();
    }

    @Override
    public void onClick(View v) {
        if (v == btnOk) {
            Intent returnIntent = new Intent(); // สร้างซองจดหมาย ไม่ต้องจ่าหน้าซอง
            returnIntent.putExtra("result", editTextHola.getText().toString()); // เอาของใส่ซอง put extra ใส่ intent
            setResult(RESULT_OK, returnIntent); // ส่ง intent กลับไปจากที่ที่เรียกมา
            finish();
        }
    }
}
