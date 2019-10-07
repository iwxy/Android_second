package com.example.a16478004_wxy;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

public class LoginActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        Button btn=(Button)findViewById(R.id.signIn);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EditText username=findViewById(R.id.username);
                EditText password=findViewById(R.id.password);
                String name=username.getText().toString();
                String ps=password.getText().toString();
                Intent intent=new Intent(LoginActivity.this,WeixinActivity.class);
                Bundle bundle=new Bundle();
                bundle.putString("name",name);
                bundle.putString("password",ps);
                intent.putExtras(bundle);
                startActivity(intent);
            }
        });

    }


}
