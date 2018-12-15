package com.example.editpoll;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class Item {
    public static String score;
    public final long _id;

    public Item(long _id, String score){
        this._id = _id;
        this.score = score;

    }
}
