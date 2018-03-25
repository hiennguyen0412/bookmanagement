package com.example.hiennv.bookmanagement;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;

import com.example.hiennv.bookmanagement.utils.DBUtils;

public class UpdateActivity extends AppCompatActivity {
    final String DATABASE_NAME = "BookManagement.sqlite";
    EditText edtID, edtName, edtAuthor, edtType, edtPrice;
    ImageView imgUpdate;
    Button btnSave, btnCancel, btnSelect;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update);

        addControls();
        loadToUpdate();

    }

    private void loadToUpdate() {

        Intent intent = getIntent();
        int id = intent.getIntExtra("ID", -1);
        SQLiteDatabase database = DBUtils.initDatabase(this, DATABASE_NAME);
        Cursor cursor = database.rawQuery("SELECT * FROM Book WHERE Book.ID = ?", new String[]{id+""});
        cursor.moveToFirst();

        String name = cursor.getString(1);
        String author = cursor.getString(2);
        String type = cursor.getString(3);
        double price = cursor.getDouble(4);
        byte[] img = cursor.getBlob(5);

        Bitmap bm = BitmapFactory.decodeByteArray(img, 0, img.length);
        imgUpdate.setImageBitmap(bm);

        edtName.setText(name);
        edtAuthor.setText(author);
        edtType.setText(type);
        edtPrice.setText(price+"");

    }

    private void addControls() {
        edtID = findViewById(R.id.edtID);
        edtName = findViewById(R.id.edtName);
        edtAuthor = findViewById(R.id.edtAuthor);
        edtType = findViewById(R.id.edtType);
        edtPrice = findViewById(R.id.edtPrice);

        imgUpdate = findViewById(R.id.imgUpdate);
        btnSelect = findViewById(R.id.btnSelect);
        btnSave = findViewById(R.id.btnSave);
        btnCancel = findViewById(R.id.btnCancel);

    }
}
