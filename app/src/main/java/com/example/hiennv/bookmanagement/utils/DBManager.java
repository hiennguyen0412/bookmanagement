package com.example.hiennv.bookmanagement.utils;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import com.example.hiennv.bookmanagement.MainActivity;
import com.example.hiennv.bookmanagement.model.Account;

/**
 * Created by hiennv on 22/03/2018.
 */

public class DBManager extends SQLiteOpenHelper {
    public static final String DATABASE_NAME ="BookDB";


    public static Context context;

    public DBManager(Context context) {
        super(context, DATABASE_NAME,null, 1);
        Log.d("DBManager", "DBManager: ");
        this.context = context;
    }
    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {

    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }

    public boolean checkLogin(Account acc){
        String selectQuery = "SELECT  * FROM  Account WHERE Username = "+acc.getUserName()
                +" AND Password = "+acc.getPassWord() ;

        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);

        if (cursor.moveToFirst()) {
            return true;
        }
        cursor.close();
        db.close();
        return false;
    }

    /*
  Get Count Student in Table Student
   */
    public int getStudentsCount() {
        String countQuery = "SELECT  * FROM Account" ;
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery(countQuery, null);
        cursor.close();

        // return count
        return cursor.getCount();
    }

    public static void main(String[] args) {
        DBManager db = new DBManager(context);
        int  a = db.getStudentsCount();
        System.out.println(a);
    }
}
