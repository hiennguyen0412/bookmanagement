package com.example.hiennv.bookmanagement;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.hiennv.bookmanagement.model.Book;

import java.util.ArrayList;

/**
 * Created by hiennv on 23/03/2018.
 */

public class AdapterBook extends BaseAdapter {
    Activity context;
    ArrayList<Book> list;

    public AdapterBook(Activity context, ArrayList<Book> list) {
        this.context = context;
        this.list = list;
    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public Object getItem(int i) {
        return null;
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View row = inflater.inflate(R.layout.listview_row, null);
        TextView txtID = row.findViewById(R.id.txtID);
        TextView txtName = row.findViewById(R.id.txtName);
        TextView txtPrice = row.findViewById(R.id.txtPrice);
        ImageView imgHDD = row.findViewById(R.id.imgHinhDaiDien);
        Button btnEdit = row.findViewById(R.id.btnEdit);
        Button btnDel = row.findViewById(R.id.btnDel);

        Book book = list.get(i);
        txtID.setText(book.getId()+"");
        txtName.setText(book.getName());
        txtPrice.setText(book.getPrice()+"");
        Bitmap bm = BitmapFactory.decodeByteArray(book.getImage(),0,book.getImage().length);
        imgHDD.setImageBitmap(bm);

        btnEdit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(context, UpdateActivity.class);
                context.startActivity(intent);
            }
        });
        return row;
    }

    @Nullable
    @Override
    public CharSequence[] getAutofillOptions() {
        return new CharSequence[0];
    }

    
}
