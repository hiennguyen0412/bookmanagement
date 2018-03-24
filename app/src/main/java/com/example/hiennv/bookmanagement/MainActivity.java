package com.example.hiennv.bookmanagement;

import android.app.Activity;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.hiennv.bookmanagement.model.Account;
import com.example.hiennv.bookmanagement.utils.DBManager;
import com.example.hiennv.bookmanagement.utils.DBUtils;

public class MainActivity extends AppCompatActivity {

    SQLiteDatabase database;
    EditText edtUsername;
    EditText edtPassword;
    Button btnLogin;
    Button btnRegister;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        edtUsername = this.findViewById(R.id.edtUsername);
        edtPassword = this.findViewById(R.id.edtPassword);
        btnLogin = this.findViewById(R.id.btnLogin);
        btnRegister = this.findViewById(R.id.btnRegister);

        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(MainActivity.this, "Login successfully", Toast.LENGTH_SHORT).show();
                Intent i = new Intent(MainActivity.this, HomeActivity.class);
                startActivity(i);
            }
        });

        btnRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent1 = new Intent(MainActivity.this, RegisterActivity.class);
                startActivity(intent1);

            }
        });
    }


}
