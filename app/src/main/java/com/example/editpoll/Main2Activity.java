package com.example.editpoll;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

import static com.example.editpoll.DatabaseHelper.COL_ID;
import static com.example.editpoll.DatabaseHelper.COL_SCO;
import static com.example.editpoll.DatabaseHelper.TABLE_NAME;

public class Main2Activity extends AppCompatActivity {

    private DatabaseHelper mHelper;
    private SQLiteDatabase mDb;
    private List<Item> mItemList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        mHelper = new DatabaseHelper(Main2Activity.this);
        mDb = mHelper.getWritableDatabase();

        Button delectButton = findViewById(R.id.delect_button);
        delectButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                new AlertDialog.Builder(Main2Activity.this)
                        .setMessage("ต้องการลบข้อมูลทั่งหมด ใช่หรือไม่")
                        .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {
                                mDb.delete(
                                        TABLE_NAME,
                                        COL_ID + " = ?",
                                        new String[]{String.valueOf(Item._id)}
                                );
                            }
                        })
                        .setNegativeButton("No", null)
                        .show();
                break;
            }
        });
    }

    private void loadPhoneData() {
        Cursor c = mDb.query(TABLE_NAME, null, null, null, null, null, null);

        mItemList = new ArrayList<>();
        while (c.moveToNext()) {
            long id = c.getLong(c.getColumnIndex(COL_ID));
            String score = c.getString(c.getColumnIndex(COL_SCO));

            Item item = new Item(id, score);
            mItemList.add(item);
        }
        c.close();
    }
    private void setupListView() {
        Adapter adapter = new Adapter(
                Main2Activity.this,
                R.layout.activity_item,
                mItemList
        );

        ListView lv = findViewById(R.id.result_list_view);
        lv.setAdapter(adapter);
    }

}
