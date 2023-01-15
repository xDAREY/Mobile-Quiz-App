package com.example.mobilequizappilcation;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class GameActivity extends AppCompatActivity {

    private TextView QuizQuestion, QuizPoints, QuizQuestionsNo, QuizTimer;
    private RadioGroup answerBox;
    private RadioButton optRbt1, optRbt2, optRbt3;
    private Button NextBtn;

    int allQuestionsAnswered;
    int questionCounter = 0;

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

        inputQuestions();
        allQuestionsAnswered = questionsList.size();
        showNextQuestions();

    }

    private void showNextQuestions() {
        if(questionCounter < allQuestionsAnswered){
            onGoingQuestion = questionsList.get(questionCounter);
            QuizQuestion.setText(onGoingQuestion.getQuestion());
            optRbt1.setText(onGoingQuestion.getAnswerA());
            optRbt2.setText(onGoingQuestion.getAnswerB());
            optRbt3.setText(onGoingQuestion.getAnswerC());

            questionCounter++;
        }else{
            finish();
        }
    }

    private void inputQuestions(){
        questionsList.add(new QuestionsContainer("Who sang Finesse ?", "Pheelz", "Doja Cat", "MeekMill", 1));
        questionsList.add(new QuestionsContainer("Who sang Finesse ?", "Pheelz", "Doja Cat", "MeekMill", 1));
        questionsList.add(new QuestionsContainer("Who sang Finesse ?", "Pheelz", "Doja Cat", "MeekMill", 1));
        questionsList.add(new QuestionsContainer("Who sang Finesse ?", "Pheelz", "Doja Cat", "MeekMill", 1));
        questionsList.add(new QuestionsContainer("Who sang Finesse ?", "Pheelz", "Doja Cat", "MeekMill", 1));
    }

}