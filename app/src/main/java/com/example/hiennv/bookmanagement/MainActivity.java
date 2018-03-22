package com.example.hiennv.bookmanagement;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.hiennv.bookmanagement.utils.DBUtils;

public class MainActivity extends AppCompatActivity {
    final String DATABASE_NAME = "BookDB.sqlite";
    SQLiteDatabase database;
    EditText edtUsername;
    EditText edtPassword;
    Button btnLogin;
    Button btnRegister;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        database = DBUtils.initDatabase(this, DATABASE_NAME);
        Cursor cursor = database.rawQuery("SELECT * FROM Account",null);
        cursor.moveToFirst();
        Toast.makeText(this, cursor.getString(0), Toast.LENGTH_SHORT).show();

        edtUsername = this.findViewById(R.id.edtUsername);
        edtPassword = this.findViewById(R.id.edtPassword);
        btnLogin = this.findViewById(R.id.btnLogin);
        btnRegister = this.findViewById(R.id.btnRegister);

        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String username = edtUsername.getText().toString();
                String password = edtPassword.getText().toString();


            }
        });

        btnRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent;
                intent = new Intent(MainActivity.this, RegisterActivity.class);
                startActivity(intent);

            }
        });
    }



}
