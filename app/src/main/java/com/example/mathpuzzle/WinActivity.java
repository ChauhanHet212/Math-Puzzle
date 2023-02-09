package com.example.mathpuzzle;

import static com.example.mathpuzzle.MainActivity.PUZZLESLIST;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class WinActivity extends AppCompatActivity {

    TextView win_level, win_continue, win_main_menu;
    int level;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_win);

        win_level = findViewById(R.id.win_level);
        win_continue = findViewById(R.id.win_continue);
        win_main_menu = findViewById(R.id.win_main_menu);

        level = getIntent().getIntExtra("win_level", 100);

        win_level.setText("PUZZLE " + (level + 1) + " COMPLETED");

        win_continue.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(WinActivity.this, PuzzleActivity.class);
                if (level >= PUZZLESLIST.size() - 1) {
                    intent.putExtra("level", 0);
                } else {
                    intent.putExtra("level", level+1);
                }
                startActivity(intent);
                finish();
            }
        });
        win_main_menu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(WinActivity.this, MainActivity.class));
                finish();
            }
        });
    }
}