package com.example.nazoorahamed.coursework1;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import static com.example.nazoorahamed.coursework1.MainActivity.*;

public class score_acticity extends AppCompatActivity {

    static Button done;
    static TextView score1;
    static TextView score2;
    static TextView score3;
    static TextView score4;
    static TextView score5;
    static TextView score6;
    static TextView score7;
    static TextView score8;
    static TextView score9;
    static TextView score10;
    static TextView finalscore;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_score_acticity);

        score();
    }

    public void score(){
        done = findViewById(R.id.score_bt);
        score1 =findViewById(R.id.score_view1);
        score2 =findViewById(R.id.score_view2);
        score3 =findViewById(R.id.score_view3);
        score4 =findViewById(R.id.score_view4);
        score5 =findViewById(R.id.score_view5);
        score6 =findViewById(R.id.score_view6);
        score7 =findViewById(R.id.score_view7);
        score8 =findViewById(R.id.score_view8);
        score9 =findViewById(R.id.score_view9);
        score10 =findViewById(R.id.score_view10);
        finalscore =findViewById(R.id.score_view11);


        score1.setText(String.valueOf(quest.get(0))+"               "+scorelist.get(0));
        score2.setText(String.valueOf(quest.get(1))+"               "+scorelist.get(1));
        score3.setText(String.valueOf(quest.get(2))+"               "+scorelist.get(2));
        score4.setText(String.valueOf(quest.get(3))+"               "+scorelist.get(3));
        score5.setText(String.valueOf(quest.get(4))+"               "+scorelist.get(4));
        score6.setText(String.valueOf(quest.get(5))+"               "+scorelist.get(5));
        score7.setText(String.valueOf(quest.get(6))+"               "+scorelist.get(6));
        score8.setText(String.valueOf(quest.get(7))+"               "+scorelist.get(7));
        score9.setText(String.valueOf(quest.get(8))+"               "+scorelist.get(8));
        score10.setText(String.valueOf(quest.get(9))+"              "+scorelist.get(9));

        finalscore.setText("Your Total Score is"+String.valueOf(totalscore));




        done.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(),startview.class);
                questionNo=0;
                isPaused=true;
                quest.clear();
                scorelist.clear();
                finish();
                startActivity(intent);
            }
        });
    }


}
