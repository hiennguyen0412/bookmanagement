package com.example.hiennv.bookmanagement;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    final String DATABASE_NAME = "BookDB.sqlite";
    SQLiteDatabase database;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        database = DBUtils.initDatabase(this, DATABASE_NAME);
        Cursor cursor = database.rawQuery("SELECT * FROM Account",null);
        cursor.moveToFirst();
        Toast.makeText(this, cursor.getString(0), Toast.LENGTH_SHORT).show();
    }
}
