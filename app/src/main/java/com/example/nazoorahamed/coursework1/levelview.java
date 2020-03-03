package com.example.nazoorahamed.coursework1;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import static com.example.nazoorahamed.coursework1.MainActivity.*;
public class levelview extends AppCompatActivity {
    private static Button novice;
    private static Button easy;
    private static Button medium;
    private static Button guru;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_levelview);
        level();

    }
    public void level(){
        novice = findViewById(R.id.level1);
        easy = findViewById(R.id.level2);
        medium = findViewById(R.id.level3);
        guru = findViewById(R.id.level4);


        novice.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(),MainActivity.class);
                startActivity(intent);
                level2 =false;
                level3 =false;
                level4=false;
                level1 =true;
                finish();
            }
        });

        easy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(),MainActivity.class);
                startActivity(intent);
                level2 =true;

                level3 =false;
                level4=false;
                level1 =false;
                finish();

            }
        });

        medium.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(),MainActivity.class);
                startActivity(intent);
                level2 =false;

                level3 =true;
                level4=false;
                level1 =false;
                finish();
            }
        });

        guru.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(),MainActivity.class);
                startActivity(intent);
                level2 =false;

                level3 =false;
                level4=true;
                level1 =false;
                finish();
            }
        });

    }

}
