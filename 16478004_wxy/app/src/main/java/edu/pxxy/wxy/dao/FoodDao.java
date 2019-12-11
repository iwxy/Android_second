package edu.pxxy.wxy.dao;

import android.database.sqlite.SQLiteDatabase;

import java.util.List;

import edu.pxxy.wxy.bean.Food;

public interface FoodDao {

    //查询所有数据
    List<Food> findAllFood(SQLiteDatabase sqLiteDatabase);
    //通过名字查询菜品信息
    List<Food> findFoodByName(String foodName,SQLiteDatabase sqLiteDatabase);
    //插入菜品信息
    Long insertFood(Food food,SQLiteDatabase sqLiteDatabase);
    //删除菜品信息
    int deleteFood(String foodName,SQLiteDatabase sqLiteDatabase);
    //更新菜品信息
    int updateFoodPrice(String foodName,SQLiteDatabase sqLiteDatabase,double foodPrice);

}
