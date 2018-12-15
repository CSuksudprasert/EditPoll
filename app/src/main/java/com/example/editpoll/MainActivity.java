package com.example.editpoll;

import android.content.ContentValues;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.util.ArrayList;
import java.util.List;

import static com.example.editpoll.DatabaseHelper.COL_ID;
import static com.example.editpoll.DatabaseHelper.COL_SCO;
import static com.example.editpoll.DatabaseHelper.TABLE_NAME;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = MainActivity.class.getName();

    private DatabaseHelper mHelper;
    private SQLiteDatabase mDb;
    private List<Item> mItemList;

    EditText subject1editText;
    EditText dayeditText;
    EditText timeeditText;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mHelper = new DatabaseHelper(MainActivity.this);
        mDb = mHelper.getWritableDatabase();


        Button num1Button = findViewById(R.id.num1_button);
        num1Button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                vote();
                Item item = mItemList.get(0);
                String textscore = item.score.toString();
                String newscore = Integer.toString(Integer.valueOf(textscore)+1);
                ContentValues cv = new ContentValues();
                cv.put(COL_SCO,newscore);



                mDb.update(
                        TABLE_NAME,
                        cv,
                        COL_ID + " = ?",
                        new String[]{String.valueOf(1)}
                );
                vote();
            }
        });

        Button num2Button = findViewById(R.id.num2_button);
        num2Button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                vote();
                Item item = mItemList.get(0);
                String textscore = item.score.toString();
                String newscore = Integer.toString(Integer.valueOf(textscore)+1);
                ContentValues cv = new ContentValues();
                cv.put(COL_SCO,newscore);



                mDb.update(
                        TABLE_NAME,
                        cv,
                        COL_ID + " = ?",
                        new String[]{String.valueOf(1)}
                );
                vote();
            }
        });

        Button num3Button = findViewById(R.id.num3_button);
        num3Button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                vote();
                Item item = mItemList.get(0);
                String textscore = item.score.toString();
                String newscore = Integer.toString(Integer.valueOf(textscore)+1);
                ContentValues cv = new ContentValues();
                cv.put(COL_SCO,newscore);



                mDb.update(
                        TABLE_NAME,
                        cv,
                        COL_ID + " = ?",
                        new String[]{String.valueOf(1)}
                );
                vote();
            }
        });

        Button votenoButton = findViewById(R.id.voteno_button);
        votenoButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                vote();
                Item item = mItemList.get(0);
                String textscore = item.score.toString();
                int score =Integer.valueOf(textscore)+1;
                String newscore = Integer.toString(score);
                ContentValues cv = new ContentValues();
                cv.put(COL_SCO,newscore);


                mDb.update(
                        TABLE_NAME,
                        cv,
                        COL_ID + " = ?",
                        new String[]{String.valueOf(1)}
                );
                vote();


            }

        });

        Button selectButton = findViewById(R.id.select_button);
        selectButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, Main2Activity.class);
                startActivity(intent);
            }
        });
    }


    private void vote() {
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



}