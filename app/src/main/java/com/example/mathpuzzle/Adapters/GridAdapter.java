package com.example.mathpuzzle.Adapters;

import static android.content.Context.MODE_PRIVATE;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.mathpuzzle.Models.Puzzles;
import com.example.mathpuzzle.PuzzleActivity;
import com.example.mathpuzzle.R;

import java.util.List;

public class GridAdapter extends BaseAdapter {

    Activity activity;
    List<Puzzles> puzzlesList;
    SharedPreferences preferences;

    TextView levelBtn;
    ImageView win;

    public GridAdapter(Activity activity, List<Puzzles> puzzlesList) {
        this.activity = activity;
        this.puzzlesList = puzzlesList;
        preferences = activity.getSharedPreferences("preferences", MODE_PRIVATE);
    }

    @Override
    public int getCount() {
        return puzzlesList.size();
    }

    @Override
    public Object getItem(int i) {
        return i;
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        view = LayoutInflater.from(activity).inflate(R.layout.grid_item, viewGroup, false);

        levelBtn = view.findViewById(R.id.levelBtn);
        win = view.findViewById(R.id.win);

        String status = preferences.getString("levelStatus" + i, "pending");
        int lastlevel = preferences.getInt("LastLevel", -1);

        if (status.equals("skip") || i == lastlevel + 1) {
            win.setImageResource(0);
            levelBtn.setText(String.valueOf(i + 1));
            levelBtn.setVisibility(View.VISIBLE);
        }
        if (status.equals("win")) {
            win.setImageResource(R.drawable.tick);
            levelBtn.setText(String.valueOf(i + 1));
            levelBtn.setVisibility(View.VISIBLE);
        }
        if (status.equals("win") || status.equals("skip") || i == lastlevel + 1) {

            levelBtn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent intent = new Intent(activity, PuzzleActivity.class);
                    intent.putExtra("level", i);
                    activity.startActivity(intent);
                    activity.finish();
                }
            });

        }
        return view;
    }
}
