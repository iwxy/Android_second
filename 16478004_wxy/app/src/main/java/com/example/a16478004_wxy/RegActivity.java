package com.example.a16478004_wxy;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;


public class RegActivity extends AppCompatActivity {

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reg);


        TextView textView=findViewById(R.id.signIn);
        textView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(RegActivity.this,LoginActivity.class);
                startActivity(intent);
            }
        });

        Button btn1=(Button)findViewById(R.id.signUp);
        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(RegActivity.this,LoginActivity.class);
                startActivity(intent);
            }
        });

    }





}
