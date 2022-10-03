package com.tdt.android.trieuphumobile;

import android.app.Activity;
import android.graphics.Color;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.List;

/**
 * Created by Tu on 28-Apr-17.
 */

public class CustomAdapter extends ArrayAdapter {
    private Activity context;
    private int id;
    private List<ScoreItem> listScore;

    public CustomAdapter(Activity context, int resource, List<ScoreItem> listScore) {
        super(context, resource, listScore);
        this.context = context;
        this.id = resource;
        this.listScore = listScore;
    }

    @NonNull
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = context.getLayoutInflater();
        convertView = inflater.inflate(id, null);

        ScoreItem item = listScore.get(position);
        TextView order = (TextView) convertView.findViewById(R.id.order);
        TextView score = (TextView) convertView.findViewById(R.id.score);
        TextView date = (TextView) convertView.findViewById(R.id.date);

        order.setText(item.getName());
        score.setText(Integer.toString(item.getScore()));
        date.setText(item.getDate());
        order.setTextColor(Color.WHITE);
        score.setTextColor(Color.WHITE);
        date.setTextColor(Color.WHITE);

        return convertView;
    }
}
