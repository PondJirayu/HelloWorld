package com.example.lp700.helloworld;

import android.content.Intent;
import android.graphics.Point;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Html;
import android.text.method.LinkMovementMethod;
import android.util.Log;
import android.view.Display;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.inputmethod.EditorInfo;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    EditText editText1, editText2;
    TextView tvResult, tvDivideByZero;
    Button btnCalculate, btnClear;
    RadioGroup rgOperator;
    CheckBox cbAgree;
    Switch switchOnOff;
    ImageButton imageButton1,imageButton2;
    CustomViewGroup viewGroup1, viewGroup2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main); // Inflate

        initInstances();

        Display display = getWindowManager().getDefaultDisplay();
        Point size = new Point();
        display.getSize(size);
        int width = size.x;
        int height = size.y;
        Toast.makeText(MainActivity.this,
                "Width =" + width + ", Height =" + height,
                Toast.LENGTH_SHORT)
                .show();
    }

    private void initInstances() {
        editText1 = (EditText) findViewById(R.id.editText1);
        editText2 = (EditText) findViewById(R.id.editText2);
        tvResult = (TextView) findViewById(R.id.tvEqual);
        btnCalculate = (Button) findViewById(R.id.btnCalculate);
        rgOperator = (RadioGroup) findViewById(R.id.rgOperator);
        tvDivideByZero = (TextView) findViewById(R.id.tvDivideByZero);
        cbAgree = (CheckBox) findViewById(R.id.cbAgree);
        btnClear = (Button) findViewById(R.id.btnClear);
        switchOnOff = (Switch) findViewById(R.id.switchOnOff);
        imageButton1 = (ImageButton) findViewById(R.id.imageButton1);
        imageButton2 = (ImageButton) findViewById(R.id.imageButton2);
        viewGroup1 = (CustomViewGroup) findViewById(R.id.viewGroup1);
        viewGroup2 = (CustomViewGroup) findViewById(R.id.viewGroup2);

//        viewGroup1.setButtonText("Hello");
//        viewGroup2.setButtonText("World");

        btnCalculate.setOnClickListener(this);
        btnClear.setOnClickListener(this);
        imageButton1.setOnClickListener(this);
        imageButton2.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if(v == imageButton1){
            Toast.makeText(MainActivity.this,
                    "Image Button1",
                    Toast.LENGTH_SHORT)
                    .show();
        }
        if(v == imageButton2){
            Toast.makeText(MainActivity.this,
                    "Image Button2",
                    Toast.LENGTH_SHORT)
                    .show();
        }
        if (v == btnClear) {
            editText1.setText("0");
            editText2.setText("0");
            tvResult.setText("= 0");
            cbAgree.setChecked(false);
            switchOnOff.setChecked(false);
//            switchOnOff.setVisibility(Switch.VISIBLE); // "VISIBLE" แสดง View
//            switchOnOff.setVisibility(Switch.GONE);    // "GONE" ซ่อน View A -> และขยับ View B แทนที่ View A
//            switchOnOff.setVisibility(Switch.INVISIBLE);  // "INVISIBLE" ซ่อน View A -> แต่ไม่ขยับ View B แทนที่ View A
            if (switchOnOff.getVisibility() == Switch.VISIBLE)
                switchOnOff.setVisibility(Switch.INVISIBLE);
            else
                switchOnOff.setVisibility(Switch.VISIBLE);

            Toast.makeText(MainActivity.this,
                    "ล้างข้อมูลแล้ว",
                    Toast.LENGTH_SHORT)
                    .show();
        }
        if (v == btnCalculate && cbAgree.isChecked() && switchOnOff.isChecked()) {
//            cbAgree.setChecked(false);
            int val1 = 0, val2 = 0, sum = 0;

            try {
                val1 = Integer.parseInt(editText1.getText().toString()); // getText return string + style ต้องแปลงเป็น string ด้วยคำสั่ง toString()
            } catch (NumberFormatException e) {
            }
            try {
                val2 = Integer.parseInt(editText2.getText().toString());
            } catch (NumberFormatException e) {
            }

            // Check Operator
            switch (rgOperator.getCheckedRadioButtonId()) {
                case R.id.rbPlus:
                    tvDivideByZero.setText("");
                    sum = val1 + val2;
                    break;
                case R.id.rbMinus:
                    tvDivideByZero.setText("");
                    sum = val1 - val2;
                    break;
                case R.id.rbMultiply:
                    tvDivideByZero.setText("");
                    sum = val1 * val2;
                    break;
                case R.id.rbDivide:
                    try {
                        sum = val1 / val2;
                        tvDivideByZero.setText("");
                    } catch (ArithmeticException e) {
                        tvDivideByZero.setText("Divide by Zero");
                    }
                    break;
            }
            tvResult.setText(sum + "");

            Log.d("Calculation", "Result = " + sum);
            Toast.makeText(MainActivity.this,
                    "Result = " + sum,
                    Toast.LENGTH_LONG)
                    .show();


            // การยิง intent
            Intent intent = new Intent(MainActivity.this, SecondActivity.class); // สร้างจดหมาย จ่าหน้าซอง (create intent)
            intent.putExtra("result", sum); // ใส่ของ(primitive type)ในซองจดหมายใหญ่(intent)

            // Bundle Lab
            Coordinate c1 = new Coordinate(5, 10, 20);
//            c1.setX(5);
//            c1.setY(10);
//            c1.setY(20);
            Bundle bundle = new Bundle();
            bundle.putInt("x", c1.getX());
            bundle.putInt("y", c1.getY());
            bundle.putInt("z", c1.getZ());
            intent.putExtra("cBundle", bundle); // ใส่ซองจดหมายเล็ก(bundle)ในซองจดหมายใหญ่(intent)

            // Serializable Lab
            CoordinateSerializable c2 = new CoordinateSerializable(5, 10, 20);
//            c2.setX(5);
//            c2.setY(10);
//            c2.setZ(20);
            intent.putExtra("cSerializable", c2);

            // Parcelable Lab
            CoordinateParcelable c3 = new CoordinateParcelable(5, 10, 20);
//            c3.setX(5);
//            c3.setY(10);
//            c3.setZ(20);
            intent.putExtra("cParcelable", c3); // ใส่กล่องพัสดุ(parcel)ในซองจดหมายใหญ่(intent)

            startActivity(intent); // ส่งจดหมาย(send intent)
        }
    }

    // Inflate Options Menu from res/menu/menu_main.xml
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    // Handling click events
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle item selection
        switch (item.getItemId()) {
            case R.id.action_settings:
                Toast.makeText(MainActivity.this,
                        "Settings",
                        Toast.LENGTH_SHORT)
                        .show();
                return true;
            case R.id.action_help:
                Toast.makeText(MainActivity.this,
                        "Help",
                        Toast.LENGTH_SHORT)
                        .show();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
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
}

