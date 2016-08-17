package com.example.lp700.helloworld;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Html;
import android.text.method.LinkMovementMethod;
import android.view.KeyEvent;
import android.view.inputmethod.EditorInfo;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main); //inflate

        final TextView tvHello = (TextView)findViewById(R.id.tvHello);
        final EditText editTextHello = (EditText)findViewById(R.id.edittextHello);

        tvHello.setMovementMethod(LinkMovementMethod.getInstance()); // ทำให้ลิ้งค์สามารถคลิกได้
        tvHello.setText(Html.fromHtml("<b>He<u>ll</u>o</b> <i><u>World</u></i> <font color=\"#fafafa\">La la la</font> <a href=\"http://www.nuuneoi.com\">http://nuuneoi.com</a>"));

        editTextHello.setOnEditorActionListener(new TextView.OnEditorActionListener() {
            @Override
            public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {
                if(actionId == EditorInfo.IME_ACTION_DONE){
                    // Copy text in EditText to TextView
                    tvHello.setText(editTextHello.getText());
                    return true;
                }
                return false;
            }
        });
    }
}
