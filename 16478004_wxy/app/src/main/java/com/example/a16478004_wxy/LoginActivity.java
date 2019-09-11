package com.example.a16478004_wxy;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import androidx.appcompat.app.AppCompatActivity;

public class LoginActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
    }

    public boolean onCreateOptionsMenu(Menu menu){
        getMenuInflater().inflate(R.menu.menu_login,menu);
        return true;
    }

    public boolean onOptionsItemSelected(MenuItem item){
        switch (item.getItemId()){
            case R.id.action_1:
                Intent in = new Intent();
                in.setClass(LoginActivity.this,UserActivity.class);
                startActivity(in);
                break;
            case R.id.action_2:
                Intent ins = new Intent();
                ins.setClass(LoginActivity.this,NewsActivity.class);
                startActivity(ins);
                break;
            default:
        }
        return super.onOptionsItemSelected(item);
    }

}
