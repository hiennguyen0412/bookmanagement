package com.example.hiennv.bookmanagement;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;

import com.example.hiennv.bookmanagement.utils.DBUtils;

public class AddActivity extends AppCompatActivity {

    final String DATABASE_NAME = "BookManagement.sqlite";
    final int REQUEST_CHOOSE_PHOTO = 321;
    EditText edtID, edtName, edtAuthor, edtType, edtPrice;
    ImageView imgAdd;
    Button btnSave, btnCancel, btnSelect;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add);
    }

    /**
     * add book into database
     * @return
     */
    private int addBook(){
        //Mapping layout into Activity
        edtID = findViewById(R.id.edtID);
        edtName = findViewById(R.id.edtName);
        edtAuthor = findViewById(R.id.edtAuthor);
        edtType = findViewById(R.id.edtType);
        edtPrice = findViewById(R.id.edtPrice);

        imgAdd = findViewById(R.id.imgAdd);
        btnSelect = findViewById(R.id.btnSelect);
        btnSave = findViewById(R.id.btnSave);
        btnCancel = findViewById(R.id.btnCancel);

        SQLiteDatabase database = DBUtils.initDatabase(this, DATABASE_NAME);
        Cursor cursor = database.rawQuery("SELECT * FROM Book", null);
        return 1;
    }
}
