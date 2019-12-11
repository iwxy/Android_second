package edu.pxxy.wxy;

import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import edu.pxxy.wxy.bean.Food;
import edu.pxxy.wxy.dao.impl.FoodDaoImpl;

public class FoodAddActivity extends AppCompatActivity {

    private EditText ed_foodName, ed_foodPrice, ed_count;
    private Button btn_insert;
    MyDBOpenHelper openHelper;
    SQLiteDatabase sqLiteDatabase;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.food_add);
        openHelper = new MyDBOpenHelper(this);
        sqLiteDatabase = openHelper.getReadableDatabase();
        initView();
    }

    private void initView() {
        ed_foodName = findViewById(R.id.food_name);
        ed_foodPrice = findViewById(R.id.food_price);
        ed_count = findViewById(R.id.food_count);
        btn_insert = findViewById(R.id.btn_insert);
        btn_insert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String foodName = ed_foodName.getText().toString().trim();
                String foodPrice = ed_foodPrice.getText().toString().trim();
                String count = ed_count.getText().toString().trim();
                FoodDaoImpl foodDaoImpl = new FoodDaoImpl();
                Food food = new Food();
                food.setFoodName(foodName);
                food.setFoodPrice(Double.parseDouble(foodPrice));
                food.setCount(Integer.parseInt(count));
                foodDaoImpl.insertFood(food,sqLiteDatabase);
                sendBroadcast(new Intent("main_receiver"));
                Toast.makeText(FoodAddActivity.this,"添加成功",Toast.LENGTH_SHORT).show();
                ed_foodName.setText("");
                ed_foodPrice.setText("");
                ed_count.setText("");
            }
        });
    }

}
