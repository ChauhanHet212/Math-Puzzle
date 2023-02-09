package com.example.mathpuzzle.Adapters;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.mathpuzzle.Models.Puzzles;
import com.example.mathpuzzle.PuzzleActivity;
import com.example.mathpuzzle.R;

import java.util.List;

public class GridAdapter extends BaseAdapter {

    Activity activity;
    List<Puzzles> puzzlesList;

    TextView levelBtn;

    public GridAdapter(Activity activity, List<Puzzles> puzzlesList) {
        this.activity = activity;
        this.puzzlesList = puzzlesList;
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
        levelBtn.setText(String.valueOf(i + 1));

        levelBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(activity, PuzzleActivity.class);
                intent.putExtra("level", i);
                activity.startActivity(intent);
                activity.finish();
            }
        });

        return view;
    }
}
