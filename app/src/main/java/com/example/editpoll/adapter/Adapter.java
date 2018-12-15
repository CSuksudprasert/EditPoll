package com.example.editpoll.adapter;

import android.content.Context;
import android.content.res.AssetManager;
import android.graphics.drawable.Drawable;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.editpoll.Item;
import com.example.editpoll.R;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import static com.example.editpoll.R.id.score_text_view;

public class Adapter extends ArrayAdapter<Item> {
    private Context mContext;
    private int mResource;
    private List<Item> mItemList;

    public Adapter(@NonNull Context context,
                            int resource,
                            @NonNull List<Item> ItemList) {
        super(context, resource, ItemList);
        this.mContext = context;
        this.mResource = resource;
        this.mItemList = ItemList;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        LayoutInflater inflater = (LayoutInflater) mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View view = inflater.inflate(mResource, parent, false);

        TextView titleTextView = view.findViewById(R.id.score_text_view);

        Item item = mItemList.get(position);
        String score = item.score;

        titleTextView.setText(score);


        return view;
    }
}
