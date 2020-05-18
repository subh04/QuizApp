package com.example.quizapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    final String SCORE_KEY="SCORE";
    final String INDEX_KEY="INDEX";




    private TextView tv;
    private Button btnTrue;
    private Button btnFalse;
    private int arrInd=0;
    private ProgressBar pb;
    private TextView tv2;
    private int userScore;




    //creating array of the object
    private QuizModel[] quesCollection=new QuizModel[]{
            new QuizModel(R.string.q1,false),
            new QuizModel(R.string.q2,true),
            new QuizModel(R.string.q3,false),
            new QuizModel(R.string.q4,true),
            new QuizModel(R.string.q5,false),
            new QuizModel(R.string.q6,true),
            new QuizModel(R.string.q7,false),
            new QuizModel(R.string.q8,true),
            new QuizModel(R.string.q9,false),
            new QuizModel(R.string.q10,true),


    };

    final int USER_PROGRESS= (int) Math.ceil(100.0/quesCollection.length);

    @Override
    protected void onCreate(Bundle savedInstanceState) {



        if(savedInstanceState!=null){
            userScore=savedInstanceState.getInt(SCORE_KEY);
            arrInd=savedInstanceState.getInt(INDEX_KEY);



        }
        else {
            userScore=0;
            arrInd=0;
        }

        Toast.makeText(getApplicationContext(),"onCreate called",Toast.LENGTH_SHORT).show();



        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        pb=findViewById(R.id.quizPB);
        tv2=findViewById(R.id.txtQuizStats);
        tv2.setText(userScore+"");







       tv=findViewById(R.id.txtQues);
       tv.setText(quesCollection[arrInd].getmQuestion());



        btnTrue=findViewById(R.id.btnTrue);
        View.OnClickListener myClickListener=new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                checkAnswer(true);

                changeQuestionOnButtonClick();


            }
        };
        btnTrue.setOnClickListener(myClickListener);
        btnFalse=findViewById(R.id.btnFalse);

        btnFalse.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                checkAnswer(false);
                changeQuestionOnButtonClick();


            }
        });
        //QuizModel model=new QuizModel(R.string.q1,true);
    }
    private void changeQuestionOnButtonClick()
    {
        arrInd=(arrInd+1)%quesCollection.length;

        if(arrInd==0){
            AlertDialog.Builder quizAlert=new AlertDialog.Builder(this);//context means the current state of the application
            quizAlert.setCancelable(false);
            quizAlert.setTitle("QUIZ HAS FINISHED");
            quizAlert.setMessage("your score is "+userScore);
            //CREATING ON CLICK LISTENER FOR DIALOGUE INTERFACE IN BELOW LINE
            quizAlert.setPositiveButton("Finish the quiz", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    finish();

                }
            });
            quizAlert.show();
        }

        tv.setText(quesCollection[arrInd].getmQuestion());
        pb.incrementProgressBy(USER_PROGRESS);
        tv2.setText(userScore+" is your score");
    }
    private void checkAnswer(boolean userGuess)
    {
        boolean correctAns=quesCollection[arrInd].ismAnswer();
        if(userGuess==correctAns)
        {
            Toast.makeText(getApplicationContext(),R.string.correct_toast_message,Toast.LENGTH_SHORT).show();
            userScore=userScore+1;
        }
        else
            Toast.makeText(getApplicationContext(),R.string.incorrect_toast_message,Toast.LENGTH_SHORT).show();

    }

    @Override
    protected void onStart() {
        super.onStart();
        Toast.makeText(getApplicationContext(),"onStart called",Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onResume() {
        super.onResume();
        Toast.makeText(getApplicationContext(),"onResume called",Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onPause() {
        super.onPause();
        Toast.makeText(getApplicationContext(),"onPause called",Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onStop() {
        super.onStop();
        Toast.makeText(getApplicationContext(),"onStop called",Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Toast.makeText(getApplicationContext(),"onDestroy called",Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putInt(SCORE_KEY,userScore);
        outState.putInt(INDEX_KEY,arrInd);
    }
}
