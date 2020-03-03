package com.example.nazoorahamed.coursework1;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;


import static com.example.nazoorahamed.coursework1.MainActivity.*;

public class startview extends AppCompatActivity {

    private static Button start;
    private static Button conti;
    private static Button about;
    private static Button exit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_startview);
        start();
    }

    public void start(){
        start = findViewById(R.id.start);

        start.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Toast.makeText(startview.this,"Select a level",
                        Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(getApplicationContext(),levelview.class);

                startActivity(intent);
                finish();

            }
        });


        exit = findViewById(R.id.exit);

        exit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AlertDialog.Builder builder = new AlertDialog.Builder(startview.this);

                builder.setTitle("Confirm");
                builder.setMessage("Are you sure you want to exit the game?");

                builder.setPositiveButton("YES", new DialogInterface.OnClickListener() {

                    public void onClick(DialogInterface dialog, int which) {
                        // Do nothing but close the dialog
                        finish();
                        System.exit(0);

                    }
                });

                builder.setNegativeButton("NO", new DialogInterface.OnClickListener() {

                    @Override
                    public void onClick(DialogInterface dialog, int which) {


                        dialog.dismiss();
                    }
                });

                AlertDialog alert = builder.create();
                alert.show();
            }
        });

        conti = findViewById(R.id.conti);
        conti.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(),MainActivity.class);
                startActivity(intent);

                questionNo =3;
                quest.add("12+3");
                quest.add("15*3");
                quest.add("23-3");
                scorelist.add(16);
                scorelist.add(23);
                scorelist.add(25);

                level2 =false;
                level3 =false;
                level4=false;
                level1 =true;
                finish();


            }
        });


    }



    @Override
    public void onBackPressed() {

        AlertDialog.Builder builder = new AlertDialog.Builder(startview.this);

        builder.setTitle("Confirm");
        builder.setMessage("Are you sure you want to exit the game?");

        builder.setPositiveButton("YES", new DialogInterface.OnClickListener() {

            public void onClick(DialogInterface dialog, int which) {
                // Do nothing but close the dialog
                finish();
                System.exit(0);

            }
        });

        builder.setNegativeButton("NO", new DialogInterface.OnClickListener() {

            @Override
            public void onClick(DialogInterface dialog, int which) {


                dialog.dismiss();
            }
        });

        AlertDialog alert = builder.create();
        alert.show();
    }
}
