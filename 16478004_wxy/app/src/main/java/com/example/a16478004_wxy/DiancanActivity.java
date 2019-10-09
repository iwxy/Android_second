package com.example.a16478004_wxy;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class DiancanActivity extends AppCompatActivity {

    Button btn_commit;
    CheckBox cb_xcr, cb_hsdf, cb_djt, cb_xbc, cb_hsyk, cb_pjy;
    RadioGroup rg;
    RadioButton rb_cheap, rb_noCheap;
    Integer totalPrice;
    EditText address;
    EditText youHuiQuan;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_diancan);
        initEvent();
    }

    private void initEvent() {
        btn_commit = findViewById(R.id.commit);
        cb_xcr = findViewById(R.id.xcr);
        cb_hsdf = findViewById(R.id.hsdf);
        cb_djt = findViewById(R.id.djt);
        cb_xbc = findViewById(R.id.xbc);
        cb_hsyk = findViewById(R.id.hsyk);
        cb_pjy = findViewById(R.id.pjy);
        rg = findViewById(R.id.rg);
        rb_cheap = findViewById(R.id.cheap);
        rb_noCheap = findViewById(R.id.noCheap);
        address = findViewById(R.id.address);
        youHuiQuan = findViewById(R.id.youhuiquan);

        rg.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {
                switch (i) {
                    case R.id.cheap:
                        youHuiQuan.setVisibility(View.VISIBLE);
                        break;
                    case R.id.noCheap:
                        youHuiQuan.setVisibility(View.GONE);
                        break;
                }
            }
        });

        btn_commit.setOnClickListener(new View.OnClickListener() {

            public void onClick(View view) {

                if (rb_cheap.isChecked()) {
                    String youHuiQuan1 = youHuiQuan.getText().toString();
                    if (youHuiQuan1.isEmpty()) {
                        Toast.makeText(getApplicationContext(), "请输入优惠券号", Toast.LENGTH_SHORT).show();
                        return;
                    }

                }

                String address1 = address.getText().toString();
                if (address1.isEmpty()) {
                    Toast.makeText(getApplicationContext(), "请输入地址", Toast.LENGTH_SHORT).show();
                } else {
                    totalPrice=new Integer(0);
                    if(cb_xcr.isChecked()){
                        totalPrice+=30;
                    }
                    if(cb_hsdf.isChecked()){
                        totalPrice+=8;
                    }
                    if(cb_djt.isChecked()){
                        totalPrice+=20;
                    }
                    if(cb_xbc.isChecked()){
                        totalPrice+=6;
                    }
                    if(cb_hsyk.isChecked()){
                        totalPrice+=15;
                    }
                    if(cb_pjy.isChecked()){
                        totalPrice+=16;
                    }
                    Toast.makeText(getApplicationContext(), "总价为："+totalPrice+"元", Toast.LENGTH_SHORT).show();
                }

            }

        });


    }


}
