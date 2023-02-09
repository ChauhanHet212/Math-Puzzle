package com.example.mathpuzzle;

import static com.example.mathpuzzle.MainActivity.PUZZLESLIST;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.GridView;

import com.example.mathpuzzle.Adapters.GridAdapter;

public class LevelsActivity extends AppCompatActivity {

    GridView grid;
    GridAdapter gridAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_levels);

        grid = findViewById(R.id.grid);
        gridAdapter = new GridAdapter(LevelsActivity.this, PUZZLESLIST);
        grid.setAdapter(gridAdapter);
    }
}