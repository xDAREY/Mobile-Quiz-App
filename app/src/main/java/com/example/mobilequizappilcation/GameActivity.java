package com.example.mobilequizappilcation;

import androidx.appcompat.app.AppCompatActivity;

import android.content.res.ColorStateList;
import android.graphics.Color;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class GameActivity extends AppCompatActivity {

    private TextView QuizQuestion, QuizPoints, QuizQuestionsNo, QuizTimer;
    private RadioGroup answerBox;
    private RadioButton optRbt1, optRbt2, optRbt3;
    private Button NextBtn;

    int allQuestionsAnswered;
    int questionCounter = 0;
    int Point = 0;

    ColorStateList optRbtPicked;
    boolean answered;
    CountDownTimer cdtimer;

    private QuestionsContainer onGoingQuestion;


    private List<QuestionsContainer> questionsList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game_);


        questionsList = new ArrayList<>();
        QuizQuestion = findViewById(R.id.Questions2beAnswered);
        QuizPoints = findViewById(R.id.gamePoints);
        QuizQuestionsNo = findViewById(R.id.questionNo);
        QuizTimer = findViewById(R.id.gameTimer);

        answerBox = findViewById(R.id.answerBox);
        optRbt1 = findViewById(R.id.answerA);
        optRbt2 = findViewById(R.id.answerB);
        optRbt3 = findViewById(R.id.answerC);
        NextBtn = findViewById(R.id.nextBtn);

        optRbtPicked = optRbt1.getTextColors();

        inputQuestions();
        allQuestionsAnswered = questionsList.size();
        showNextQuestions();

        NextBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(answered == false){
                    if(optRbt1.isChecked() || optRbt2.isChecked() || optRbt3.isChecked()){
                        verifyAnswer();
                        cdtimer.cancel();
                    }else {
                        Toast.makeText(GameActivity.this, "Choose an answer", Toast.LENGTH_SHORT).show();
                        }
                    }else {
                    showNextQuestions();
                }
            }

            private void verifyAnswer() {
                answered = true;
                RadioButton rbtPicked = findViewById(answerBox.getCheckedRadioButtonId());
                int answerNo = answerBox.indexOfChild(rbtPicked) + 1;
                if(answerNo == onGoingQuestion.getRightAnswerCounter()){
                    Point++;
                    QuizPoints.setText("Point: "+Point);
                }
                optRbt1.setTextColor(Color.YELLOW);
                optRbt2.setTextColor(Color.YELLOW);
                optRbt3.setTextColor(Color.YELLOW);

                switch (onGoingQuestion.getRightAnswerCounter()){
                    case 1:
                        optRbt1.setTextColor(Color.GREEN);
                        break;
                    case 2:
                        optRbt2.setTextColor(Color.GREEN);
                        break;
                    case 3:
                        optRbt3.setTextColor(Color.GREEN);
                        break;
                }
                if (questionCounter < allQuestionsAnswered){
                    NextBtn.setText("NEXT");
                }else{
                    NextBtn.setText("Complete");
                }

            }
        });



    }

    private void showNextQuestions() {

        answerBox.clearCheck();
        optRbt1.setTextColor(optRbtPicked);
        optRbt2.setTextColor(optRbtPicked);
        optRbt3.setTextColor(optRbtPicked);

        if(questionCounter < allQuestionsAnswered){
            timer();
            onGoingQuestion = questionsList.get(questionCounter);
            QuizQuestion.setText(onGoingQuestion.getQuestion());
            optRbt1.setText(onGoingQuestion.getAnswerA());
            optRbt2.setText(onGoingQuestion.getAnswerB());
            optRbt3.setText(onGoingQuestion.getAnswerC());

            questionCounter++;
            NextBtn.setText("SUBMIT");
            QuizQuestionsNo.setText("Question: "+questionCounter+"/"+allQuestionsAnswered);
            answered = false;

        }else{
            finish();
        }
    }

    private void timer() {
        cdtimer = new CountDownTimer(20000,1000) {
            @Override
            public void onTick(long millisUntilFinished) {
                QuizTimer.setText("00:" +1/1000);
            }

            @Override
            public void onFinish() {
                showNextQuestions();

            }
        }.start();

    }

    private void inputQuestions(){
        questionsList.add(new QuestionsContainer("Who sang Finesse ?", "Pheelz", "Doja Cat", "MeekMill", 1));
        questionsList.add(new QuestionsContainer("Who sang Finesse ?", "Pheelz", "Doja Cat", "MeekMill", 1));
        questionsList.add(new QuestionsContainer("Who sang Finesse ?", "Pheelz", "Doja Cat", "MeekMill", 1));
        questionsList.add(new QuestionsContainer("Who sang Finesse ?", "Pheelz", "Doja Cat", "MeekMill", 1));
        questionsList.add(new QuestionsContainer("Who sang Finesse ?", "Pheelz", "Doja Cat", "MeekMill", 1));
    }

}