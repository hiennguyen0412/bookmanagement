package com.example.hiennv.bookmanagement;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

import com.example.hiennv.bookmanagement.model.Book;
import com.example.hiennv.bookmanagement.utils.DBUtils;

import java.util.ArrayList;

public class HomeActivity extends AppCompatActivity {
    final String DATABASE_NAME = "BookManagement.sqlite";
    SQLiteDatabase database;

    ListView listView;
    ArrayList<Book> list;
    AdapterBook adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        addControls();
        readData();
    }

    private void addControls() {
        listView = findViewById(R.id.listView);
        list = new ArrayList<>();
        adapter = new AdapterBook(this, list);
        listView.setAdapter(adapter);
    }

    private void readData(){
        database = DBUtils.initDatabase(this, DATABASE_NAME);
        Cursor cursor = database.rawQuery("SELECT * FROM Book", null);
        list.clear();
        for(int i = 0; i <cursor.getCount();i++){
            cursor.moveToPosition(i);
            int id = cursor.getInt(0);
            String name = cursor.getString(1);
            String author = cursor.getString(2);
            String type = cursor.getString(3);
            Double price = cursor.getDouble(4);
            byte[] image = cursor.getBlob(5);
            list.add(new Book(id, name, author,type,price,image));

        }
        adapter.notifyDataSetChanged();
    }

}
