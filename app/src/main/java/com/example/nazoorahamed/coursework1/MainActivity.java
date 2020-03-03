package com.example.nazoorahamed.coursework1;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.os.CountDownTimer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Switch;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Random;

import static com.example.nazoorahamed.coursework1.Savestats.*;

public class MainActivity extends AppCompatActivity {
    private static Button one;
    private static Button two;
    private static Button three;
    private static Button four;
    private static Button five;
    private static Button six;
    private static Button seven;
    private static Button eight;
    private static Button nine;
    private static Button zero;
    private static Button hash;
    private static Button min;
    private static Button del;
    private static Button back;

    private  static TextView answer;
    private static String value;

    private static TextView mainboard;
    private static TextView alert;
    public static int questionNo=0;

    private static Switch hint;



    private static int integer1;
    private static int integer2;
    private static int integer3;
    private static int integer4;
    private static int integer5;
    private static int integer6;

    private static char operator;

    public static boolean level1 =false;
    public static boolean level2 =false;
    public static boolean level3 =false;
    public static boolean level4 =false;
    public static int intlevel =0;


    public static ArrayList quest= new ArrayList();

    public static int score;
    public static int totalscore;
    public static ArrayList scorelist= new ArrayList();


    private static TextView time;
    public static  int counter=10;
    public static boolean isPaused=false;
    private static boolean isCanceled = false;
    private long timeRemaining = 0;
    private final static long countdown =1000;
    private  final static long millies = 12000;

    private static int i;
    public static int z;
    private static int attempt=1;
    private static int maxattempt=4;
    private static boolean answerd =false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        numbers();
        boo();
        timer();
        //level1Questions();



    }

    public void numbers(){

        one = findViewById(R.id.one);
        two = findViewById(R.id.two);
        three = findViewById(R.id.three);
        four = findViewById(R.id.four);
        five = findViewById(R.id.five);
        six = findViewById(R.id.six);
        seven = findViewById(R.id.seven);
        eight = findViewById(R.id.eight);
        nine = findViewById(R.id.nine);
        zero = findViewById(R.id.zero);
        hash = findViewById(R.id.hash);
        min = findViewById(R.id.min);
        del = findViewById(R.id.del);
        back = findViewById(R.id.back);

        answer = findViewById(R.id.answer);
        value="";






        one.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                value = value+"1";
                answer.setText(value);

            }
        });
        two.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                value = value+"2";
                answer.setText(value);

            }
        });
        three.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                value = value+"3";
                answer.setText(value);

            }
        });
        four.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                value = value+"4";
                answer.setText(value);
            }
        });
        five.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                value = value+"5";
                answer.setText(value);
            }
        });
        six.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                value = value+"6";
                answer.setText(value);

            }
        });
        seven.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                value = value+"7";
                answer.setText(value);

            }
        });
        eight.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                value = value+"8";
                answer.setText(value);

            }
        });
        nine.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                value = value+"9";
                answer.setText(value);

            }
        });
        zero.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                value = value+"0";
                answer.setText(value);
            }
        });



        del.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if(value !=null && value.length()>0) {
                    if(value.substring(0,1).equals("-")){
                        value = value.substring(1);
                        value = value.substring(0, value.length() - 1);
                        min.setEnabled(true);
                        answer.setText(value);
                    }else {


                        value = value.substring(0, value.length() - 1);
                        answer.setText(value);
                    }
                        if(value.isEmpty()){
                            value ="";
                            min.setEnabled(true);
                        }



                }


            }
        });

        min.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                    if(value.isEmpty()){
                        value ="-0";
                        answer.setText(value);
                        min.setEnabled(false);
                    }else {
                        value = "-" + value;
                        answer.setText(value);
                        min.setEnabled(false);
                    }

            }
        });

        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);

                builder.setTitle("Confirm");
                builder.setMessage("Are you sure you want save this game?");

                builder.setPositiveButton("YES", new DialogInterface.OnClickListener() {

                    public void onClick(DialogInterface dialog, int which) {
                        savecurrent(intlevel,questionNo,quest,scorelist);

                        isPaused=true;
                        questionNo =0;

                        Intent intent = new Intent(getApplicationContext(),startview.class);
                        startActivity(intent);
                        intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                        intent.putExtra("EXIT", true);

                        finish();


                    }
                });

                builder.setNegativeButton("NO", new DialogInterface.OnClickListener() {

                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        isPaused=true;
                        questionNo =0;

                        Intent intent = new Intent(getApplicationContext(),startview.class);
                        startActivity(intent);
                        intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                        intent.putExtra("EXIT", true);

                        finish();



                    }
                });

                AlertDialog alert = builder.create();
                alert.show();


                builder.setNeutralButton("Cancel", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {

                    }
                });
            }
        });

    }

    @Override
    public void onBackPressed() {
        AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);

        builder.setTitle("Confirm");
        builder.setMessage("Are you sure you want to exit the game?");

        builder.setPositiveButton("YES", new DialogInterface.OnClickListener() {

            public void onClick(DialogInterface dialog, int which) {

                Intent intent = new Intent(getApplicationContext(),startview.class);
                startActivity(intent);
                intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                intent.putExtra("EXIT", true);
                finish();



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


    public void boo() {
        if (level1) {
            autoquestion();
            intlevel=intlevel+1;

        } else {
            if (level2) {
                autolevel2();
                intlevel=intlevel+2;
            } else {
                if (level3) {
                    autolevel3();
                    intlevel=intlevel+3;
                }
                if (level4){
                    autolevel4();
                    intlevel=intlevel+4;
                }
            }
        }
    }



    public void autoquestion(){
        Random randomnumber = new Random();


        hint = findViewById(R.id.hint);
        boolean switchstatus = hint.isChecked();

         integer1 = randomnumber.nextInt(15);
         integer2 = randomnumber.nextInt(25);
         integer3 = randomnumber.nextInt(50);
         integer4 = randomnumber.nextInt(75);
         integer5 = randomnumber.nextInt(100);
         integer6 = randomnumber.nextInt(100);

        operator = randomoperator(randomnumber.nextInt(3));


        mainboard = findViewById(R.id.mainboard);
        alert = findViewById(R.id.alert);

        alert.setText("");
        mainboard.setText(mainbordquestion(integer1,integer2,operator));
        quest.add("Q"+questionNo+1+")  "+mainbordquestion(integer1,integer2,operator));

        questionNo++;
        TextView qno;
        qno = findViewById(R.id.qno);
        qno.setText(String.valueOf(questionNo));
        z=z+1;



        hash =findViewById(R.id.hash);
        hash.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {



                if (questionNo>10){
                    Intent intent =new Intent(getApplicationContext(),score_acticity.class);
                    startActivity(intent);

                }else
                if (value != "" || !value.isEmpty()) {
                    int intvalue = Integer.parseInt(value);
                    if (intvalue == answercalculate(integer1, integer2, operator) ) {


                        String remain = time.getText().toString();
                        alert.setText("Correct");

                        int intremain = Integer.parseInt(remain);


                        score = 100/(10-intremain);
                        scorelist.add(score);
                        totalscore =totalscore+score;


                        mainboard.setText("");
                        alert.setTextColor(Color.parseColor("#008000"));
                        isPaused=true;
                        answerd=true;
                        answer.setText(value);
                        value="";
                        answer.setText(value);

                        min.setEnabled(true);


                    } else {
                        alert.setText("wrong");
                        alert.setTextColor(Color.parseColor("#FF0000"));
                        answer.setText(value);
                        value="";
                        answer.setText(value);
                        min.setEnabled(true);
                        score =0;
                        scorelist.add(score);
                        totalscore =totalscore+score;
                        answerd =true;


                    }
                }
                else {
                    if(!answerd){
                        score =0;
                        scorelist.add(score);
                    }
                    if(!isPaused){
                        isPaused = true;
                        time.setText("");
                        answer.setText("");
                        mainboard.setText("");
                        alert.setText("press # for next");


                    }else {
                        if(questionNo ==10){
                            Intent intent =new Intent(getApplicationContext(),score_acticity.class);
                            startActivity(intent);
                        }else
                            time.setText("");
                        answer.setText("?");
                        autoquestion();
                        timer();
                        alert.setText("");
                    }
                }
            }
        });



    }
    public void autolevel2(){
        Random randomnumber = new Random();


        hint = findViewById(R.id.hint);
        boolean switchstatus = hint.isChecked();

        integer1 = randomnumber.nextInt(15);
        integer2 = randomnumber.nextInt(25);
        integer3 = randomnumber.nextInt(50);
        integer4 = randomnumber.nextInt(75);
        integer5 = randomnumber.nextInt(100);
        integer6 = randomnumber.nextInt(100);

        operator = randomoperator(randomnumber.nextInt(3));


        mainboard = findViewById(R.id.mainboard);
        alert = findViewById(R.id.alert);

        alert.setText("");
        mainboard.setText(mainbordquestionlevel2(integer1,integer2,integer3,operator));
        quest.add("Q"+questionNo+1+")  "+mainbordquestionlevel2(integer1,integer2,integer3,operator));

        questionNo++;
        TextView qno;
        qno = findViewById(R.id.qno);
        qno.setText(String.valueOf(questionNo));
        z=z+1;



        hash =findViewById(R.id.hash);
        hash.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {



                if (questionNo>10){
                    Intent intent =new Intent(getApplicationContext(),score_acticity.class);
                    startActivity(intent);

                }else
                if (value != "" || !value.isEmpty()) {
                    int intvalue = Integer.parseInt(value);
                    if (intvalue == answercalculatelevel2(integer1, integer2,integer3, operator) ) {
                        String remain = time.getText().toString();

                        int intremain = Integer.parseInt(remain);


                        score = 100/(10-intremain);
                        scorelist.add(score);
                        totalscore =totalscore+score;



                        alert.setText("Corrent");
                        mainboard.setText("");
                        alert.setTextColor(Color.parseColor("#008000"));
                        isPaused=true;
                        answerd=true;
                        answer.setText(value);
                        value="";
                        answer.setText(value);

                        min.setEnabled(true);

                    } else {
                        alert.setText("wrong");
                        alert.setTextColor(Color.parseColor("#FF0000"));
                        answer.setText(value);
                        value="";
                        answer.setText(value);
                        min.setEnabled(true);

                        score =0;
                        scorelist.add(score);
                        totalscore =totalscore+score;
                        answerd =true;

                    }
                }
                else {
                    if(!answerd){
                        score =0;
                        scorelist.add(score);
                    }

                    if(!isPaused){
                        isPaused = true;
                        answer.setText("");
                        mainboard.setText("");
                        alert.setText("press # for next");

                    }else {
                        if(questionNo ==10){
                            Intent intent =new Intent(getApplicationContext(),score_acticity.class);
                            startActivity(intent);
                        }else
                            answer.setText("?");
                        autolevel2();
                        timer();
                        alert.setText("");
                    }
                }
            }
        });
    }

    public void autolevel3(){
        Random randomnumber = new Random();


        hint = findViewById(R.id.hint);
        boolean switchstatus = hint.isChecked();

        integer1 = randomnumber.nextInt(15);
        integer2 = randomnumber.nextInt(25);
        integer3 = randomnumber.nextInt(50);
        integer4 = randomnumber.nextInt(75);
        integer5 = randomnumber.nextInt(100);
        integer6 = randomnumber.nextInt(100);

        operator = randomoperator(randomnumber.nextInt(3));


        mainboard = findViewById(R.id.mainboard);
        alert = findViewById(R.id.alert);

        alert.setText("");
        mainboard.setText(mainbordquestionlevel3(integer1,integer2,integer3,integer4,operator));
        quest.add("Q"+questionNo+1+")  "+mainbordquestionlevel3(integer1,integer2,integer3,integer4,operator));

        questionNo++;
        TextView qno;
        qno = findViewById(R.id.qno);
        qno.setText(String.valueOf(questionNo));
        z=z+1;



        hash =findViewById(R.id.hash);
        hash.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {



                if (questionNo>10){
                    Intent intent =new Intent(getApplicationContext(),score_acticity.class);
                    startActivity(intent);

                }else
                if (value != "" || !value.isEmpty()) {
                    int intvalue = Integer.parseInt(value);
                    if (intvalue == answercalculatelevel3(integer1, integer2,integer3,integer4, operator) ) {


                        String remain = time.getText().toString();

                        int intremain = Integer.parseInt(remain);


                        score = 100/(10-intremain);
                        scorelist.add(score);
                        totalscore =totalscore+score;

                        alert.setText("Corrent");
                        mainboard.setText("");
                        alert.setTextColor(Color.parseColor("#008000"));
                        isPaused=true;
                        answerd=true;
                        answer.setText(value);
                        value="";
                        answer.setText(value);

                        min.setEnabled(true);

                    } else {
                        alert.setText("wrong");
                        alert.setTextColor(Color.parseColor("#FF0000"));
                        answer.setText(value);
                        value="";
                        answer.setText(value);
                        min.setEnabled(true);

                        score =0;
                        scorelist.add(score);
                        totalscore =totalscore+score;
                        answerd =true;

                    }
                }
                else {
                    if(!answerd){
                        score =0;
                        scorelist.add(score);
                    }

                    if(!isPaused){
                        isPaused = true;
                        answer.setText("");
                        mainboard.setText("");
                        alert.setText("press # for next");

                    }else {
                        if(questionNo ==10){
                            Intent intent =new Intent(getApplicationContext(),score_acticity.class);
                            startActivity(intent);
                        }else
                            answer.setText("?");
                        autolevel3();
                        timer();
                        alert.setText("");
                    }
                }
            }
        });
    }

    public void autolevel4(){
        Random randomnumber = new Random();


        hint = findViewById(R.id.hint);
        boolean switchstatus = hint.isChecked();

        integer1 = randomnumber.nextInt(15);
        integer2 = randomnumber.nextInt(25);
        integer3 = randomnumber.nextInt(50);
        integer4 = randomnumber.nextInt(75);
        integer5 = randomnumber.nextInt(100);
        integer6 = randomnumber.nextInt(100);

        operator = randomoperator(randomnumber.nextInt(3));


        mainboard = findViewById(R.id.mainboard);
        alert = findViewById(R.id.alert);

        alert.setText("");
        mainboard.setText(mainbordquestionlevel4(integer1,integer2,integer3,integer4,integer5,operator));
        quest.add("Q"+questionNo+1+")  "+mainbordquestionlevel4(integer1,integer2,integer3,integer4,integer5,operator));



        questionNo++;
        TextView qno;
        qno = findViewById(R.id.qno);
        qno.setText(String.valueOf(questionNo));
        z=z+1;



        hash =findViewById(R.id.hash);
        hash.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {



                if (questionNo>10){
                    Intent intent =new Intent(getApplicationContext(),score_acticity.class);
                    startActivity(intent);

                }else
                if (value != "" || !value.isEmpty()) {
                    int intvalue = Integer.parseInt(value);
                    if (intvalue == answercalculatelevel4(integer1, integer2,integer3,integer4,integer5, operator) ) {

                        String remain = time.getText().toString();

                        int intremain = Integer.parseInt(remain);


                        score = 100/(10-intremain);
                        scorelist.add(score);
                        totalscore =totalscore+score;



                        mainboard.setText("");
                        alert.setTextColor(Color.parseColor("#008000"));
                        isPaused=true;
                        answerd=true;
                        answer.setText(value);
                        value="";
                        answer.setText(value);

                        min.setEnabled(true);

                    } else {
                        alert.setText("wrong");
                        score =0;
                        scorelist.add(score);
                        alert.setTextColor(Color.parseColor("#FF0000"));
                        answer.setText(value);
                        value="";
                        answer.setText(value);
                        min.setEnabled(true);

                        score =0;
                        scorelist.add(score);
                        totalscore =totalscore+score;
                        answerd =true;

                    }
                }
                else {
                    if(!answerd){
                        score =0;
                        scorelist.add(score);
                    }

                    if(!isPaused){
                        isPaused = true;
                        answer.setText("");
                        mainboard.setText("");
                        alert.setText("press # for next");

                    }else {
                        if(questionNo ==10){
                            Intent intent =new Intent(getApplicationContext(),score_acticity.class);
                            startActivity(intent);
                        }else
                            answer.setText("?");
                        autolevel4();
                        timer();
                        alert.setText("");
                    }
                }
            }
        });
    }





    public void timer(){
        isPaused = false;
        isCanceled = false;
        time = findViewById(R.id.timecount);
        long millisInFuture = 10000; //10 seconds
        long countDownInterval = 1000; //1 second

        new CountDownTimer(millisInFuture,countDownInterval){
            public void onTick(long millisUntilFinished){
                //do something in every tick
                if(isPaused || isCanceled)
                {
                    //If the user request to cancel or paused the
                    //CountDownTimer we will cancel the current instance
                    cancel();
                    time.setText("");

                }
                else {
                    //Display the remaining seconds to app interface
                    //1 second = 1000 milliseconds
                    time.setText("" + millisUntilFinished / 1000);
                    //Put count down timer remaining time in a variable
                    timeRemaining = millisUntilFinished;
                }
            }
            public void onFinish(){
                if (level1) {
                    autoquestion();
                } else {
                    if (level2) {
                        autolevel2();
                    } else {
                        if (level3) {
                            autolevel3();
                        }
                        if (level4){
                            autolevel4();
                        }
                    }
                }
                timer();


            }
        }.start();

    }

    public static char randomoperator(int a) {
        switch (a) {
            case 0:
                return '+';
            case 1:
                return '-';
            case 2:
                return '*';
            case 3:
                return '/';
            default:
                return 'x';
        }
    }
    public static String mainbordquestion(int integer1,int integer2,char operator){
        return integer1 +""+operator+""+integer2;
    }

    public static int answercalculate(int integer1,int integer2,char operator){
        switch (operator){
            case '+': return integer1 + integer2;
            case '-': return integer1 - integer2;
            case '*': return integer1 * integer2;
            case '/': return integer1 / integer2;
            default: return -1;
        }
    }
    public static int answercalculatelevel2(int integer1,int integer2,int integer3,char operator){
        switch (operator){
            case '+': return integer1 + integer2 / integer3;
            case '-': return integer1 - integer2 * integer3;
            case '*': return integer1 * integer2 - integer3;
            case '/': return integer1 / integer2 + integer3;
            default: return -1;
        }
    }
    public static String mainbordquestionlevel2(int integer1,int integer2,int integer3,char operator){

        switch (operator){
            case '+': return integer1 +"+"+ integer2 +"/"+ integer3;
            case '-': return integer1 +"-"+ integer2 +"*"+ integer3;
            case '*': return integer1 +"*"+ integer2 +"-"+ integer3;
            case '/': return integer1 +"/"+ integer2 +"+"+ integer3;
            default: return null;
        }


    }
    public static int answercalculatelevel3(int integer1,int integer2,int integer3,int integer4,char operator){
        switch (operator){
            case '+': return integer1 + integer2 / integer3 -integer4;
            case '-': return integer1 - integer2 * integer3 +integer4;
            case '*': return integer1 * integer2 - integer3 /integer4;
            case '/': return integer1 / integer2 + integer3 *integer4;
            default: return -1;
        }
    }
    public static String mainbordquestionlevel3(int integer1,int integer2,int integer3,int integer4,char operator) {

        switch (operator) {
            case '+':
                return integer1 + "+" + integer2 + "/" + integer3 + "-" + integer4;
            case '-':
                return integer1 + "-" + integer2 + "*" + integer3 + "+" + integer4;
            case '*':
                return integer1 + "*" + integer2 + "-" + integer3 + "/" + integer4;
            case '/':
                return integer1 + "/" + integer2 + "+" + integer3 + "*" + integer4;
            default:
                return null;
        }
    }
    public static int answercalculatelevel4(int integer1,int integer2,int integer3,int integer4,int integer5,char operator){
        switch (operator){
            case '+': return integer1 + integer2 / integer3 -integer4 +integer5;
            case '-': return integer1 - integer2 * integer3 +integer4 -integer5;
            case '*': return integer1 * integer2 - integer3 /integer4 *integer5;
            case '/': return integer1 / integer2 + integer3 *integer4 /integer5;
            default: return -1;
        }
    }
    public static String mainbordquestionlevel4(int integer1,int integer2,int integer3,int integer4,int integer5,char operator){

        switch (operator){
            case '+': return integer1 +"+"+ integer2 +"/"+ integer3 +"-"+integer4 +"+"+integer5;
            case '-': return integer1 +"-"+ integer2 +"*"+ integer3 +"+"+integer4 +"-"+integer5;
            case '*': return integer1 +"*"+ integer2 +"-"+ integer3 +"/"+integer4 +"*"+integer5;
            case '/': return integer1 +"/"+ integer2 +"+"+ integer3 +"*"+integer4 +"/"+integer5;
            default: return null;
        }


    }

}
