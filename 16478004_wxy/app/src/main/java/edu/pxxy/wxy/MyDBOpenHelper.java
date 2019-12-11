package edu.pxxy.wxy;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class MyDBOpenHelper extends SQLiteOpenHelper {
    public  static String DB_NAME = "wxy.db";
    public static  int DB_VERSION = 1;

    public MyDBOpenHelper(Context context){
        super(context,DB_NAME,null,DB_VERSION);
    }

    private static final String DATABASE_CREATE = "CREATE TABLE food (_id integer primary key autoincrement,foodname text,foodprice real,count integer)";
    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL(DATABASE_CREATE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }
}

