package com.example.mobilequizappilcation;

public class QuestionsContainer {
    private String question, answerA, answerB, answerC;
    private int RightAnswerCounter;

    public QuestionsContainer(String question,
                              String answerA,
                              String answerB,
                              String answerC,
                              int rightAnswerCounter) {
        this.question = question;
        this.answerA = answerA;
        this.answerB = answerB;
        this.answerC = answerC;
        this.RightAnswerCounter = rightAnswerCounter;
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public String getAnswerA() {
        return answerA;
    }

    public void setAnswerA(String answerA) {
        this.answerA = answerA;
    }

    public String getAnswerB() {
        return answerB;
    }

    public void setAnswerB(String answerB) {
        this.answerB = answerB;
    }

    public String getAnswerC() {
        return answerC;
    }

    public void setAnswerC(String answerC) {
        this.answerC = answerC;
    }

    public int getRightAnswerCounter() {
        return RightAnswerCounter;
    }

    public void setRightAnswerCounter(int rightAnswerCounter) {
        RightAnswerCounter = rightAnswerCounter;
    }
}
