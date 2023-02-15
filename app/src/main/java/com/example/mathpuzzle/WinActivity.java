package com.example.mathpuzzle;

import static com.example.mathpuzzle.MainActivity.PUZZLESLIST;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class WinActivity extends AppCompatActivity {

    TextView win_level, win_continue, win_main_menu;
    ImageView sharePuzzle;
    int level;

    int[] shareImg = {R.drawable.share1, R.drawable.share2, R.drawable.share3, R.drawable.share4, R.drawable.share5,
            R.drawable.share6, R.drawable.share7, R.drawable.share8, R.drawable.share9, R.drawable.share10,
            R.drawable.share11, R.drawable.share12, R.drawable.share13, R.drawable.share14, R.drawable.share15,
            R.drawable.share16, R.drawable.share17, R.drawable.share18, R.drawable.share19, R.drawable.share20};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_win);

        win_level = findViewById(R.id.win_level);
        win_continue = findViewById(R.id.win_continue);
        win_main_menu = findViewById(R.id.win_main_menu);
        sharePuzzle = findViewById(R.id.sharePuzzle);

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
        sharePuzzle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Intent.ACTION_SEND);
                intent.setType("image/*");
                Uri uri = Uri.parse(MediaStore.Images.Media.insertImage(getContentResolver(),
                        BitmapFactory.decodeResource(getResources(), shareImg[level]), null, null));
                intent.putExtra(Intent.EXTRA_STREAM, uri);
                startActivity(Intent.createChooser(intent, "share via"));
            }
        });
    }
}