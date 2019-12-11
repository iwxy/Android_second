package edu.pxxy.wxy;

import androidx.appcompat.app.AppCompatActivity;

import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.widget.ListView;

import java.util.List;

import edu.pxxy.wxy.adapter.FoodAdapter;
import edu.pxxy.wxy.bean.Food;
import edu.pxxy.wxy.dao.impl.FoodDaoImpl;

public class MainActivity extends AppCompatActivity {

    //gitHub地址：https://github.com/iwxy/Android_second.git

    MyDBOpenHelper openHelper;
    SQLiteDatabase sqLiteDatabase;
    private ListView listView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //创建数据库
        openHelper = new MyDBOpenHelper(this);
        sqLiteDatabase = openHelper.getReadableDatabase();
        //initData();
       //查询所有数据
        List<Food> foodList  = new FoodDaoImpl().findAllFood(sqLiteDatabase);
        //int i  = new FoodDaoImpl().deleteFood("紫菜蛋汤",sqLiteDatabase);
        listView  = findViewById(R.id.ls_food);
        listView.setAdapter(new FoodAdapter(this,foodList));

    }
    private void initData() {
        sqLiteDatabase.beginTransaction();
        try{
            sqLiteDatabase.execSQL("insert into food(foodname,foodprice,count)values('小炒肉',20,2)");
            sqLiteDatabase.execSQL("insert into food(foodname,foodprice,count)values('青椒肉丝',24,1)");
            sqLiteDatabase.execSQL("insert into food(foodname,foodprice,count)values('西红柿炒鸡蛋',12,3)");
            sqLiteDatabase.execSQL("insert into food(foodname,foodprice,count)values('红烧鱼头',8,0)");
            sqLiteDatabase.execSQL("insert into food(foodname,foodprice,count)values('红烧猪蹄',25,4)");
            sqLiteDatabase.execSQL("insert into food(foodname,foodprice,count)values('红烧鱼块',18,2)");
            sqLiteDatabase.execSQL("insert into food(foodname,foodprice,count)values('紫菜蛋汤',10,1)");
            sqLiteDatabase.setTransactionSuccessful();
        }finally {
            sqLiteDatabase.endTransaction();
        }
    }
}
