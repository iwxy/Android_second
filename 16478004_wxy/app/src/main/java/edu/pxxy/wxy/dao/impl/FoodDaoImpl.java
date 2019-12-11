package edu.pxxy.wxy.dao.impl;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;
import java.util.List;

import edu.pxxy.wxy.bean.Food;
import edu.pxxy.wxy.dao.FoodDao;

public class FoodDaoImpl implements FoodDao {


    @Override
    public List<Food> findAllFood(SQLiteDatabase sqLiteDatabase) {
        List<Food> foodList = new ArrayList<>();
        Cursor cursor = sqLiteDatabase.rawQuery("select * from food",null);
        while(cursor.moveToNext()){
            String foodName = cursor.getString(cursor.getColumnIndex("foodname"));
            Double foodPrice = cursor.getDouble(cursor.getColumnIndex("foodprice"));
            Integer count = cursor.getInt(cursor.getColumnIndex("count"));
            Food food = new Food();
            food.setFoodName(foodName);
            food.setFoodPrice(foodPrice);
            food.setCount(count);
            foodList.add(food);
        }
        cursor.close();
        return foodList;
    }

    @Override
    public List<Food> findFoodByName(String foodName,SQLiteDatabase sqLiteDatabase) {
        List<Food> foodList = new ArrayList<>();
        Cursor cursor = sqLiteDatabase.rawQuery("select * from food where foodname =?",null);
        while(cursor.moveToNext()){
            //  String foodName = cursor.getString(cursor.getColumnIndex("foodname"));
            Double foodPrice = cursor.getDouble(cursor.getColumnIndex("foodprice"));
            Integer count = cursor.getInt(cursor.getColumnIndex("count"));
            Food food = new Food();
            food.setFoodName(foodName);
            food.setFoodPrice(foodPrice);
            food.setCount(count);
            foodList.add(food);
        }
        cursor.close();
        return foodList;
    }

    @Override
    public Long insertFood(Food food,SQLiteDatabase sqLiteDatabase) {
        ContentValues cv = new ContentValues();
        cv.put("foodname",food.getFoodName());
        cv.put("foodprice",food.getFoodPrice());
        Long i = sqLiteDatabase.insert("food",null,cv);
        return i;
    }

    @Override
    public int deleteFood(String foodName,SQLiteDatabase sqLiteDatabase) {
        //添加修改条件
        String whereClause = "foodname=?";
        //添加修改参数
        String[] whereArgs = {foodName};
        //修改，并返回影响行数
        int i = sqLiteDatabase.delete("food",whereClause,whereArgs);
        return i;

    }

    @Override
    public int updateFoodPrice(String foodName,SQLiteDatabase sqLiteDatabase,double foodPrice) {
        ContentValues cv = new ContentValues();
        cv.put("foodprice",foodPrice);
        String whereClause = "foodname=?";
        String[] whereArgs = {foodName};
        int i = sqLiteDatabase.update("food",cv,whereClause,whereArgs);
        return i;
    }
}
