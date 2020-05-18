//remember we are designing according to mvc pattern
//model is the QuizModel
//view is the xml file
//controller is the MainActivity

package com.example.quizapp;

public class QuizModel {
    //our quiz will contain questions and answers
    //here questions are strings and the answers are boolean
    //just because the questions resides in the resources
    //they are fetched by the whole number pointing to each string resource
    private int mQuestion;
    private boolean mAnswer;
    //constructor is a method and
    // called when object of this class is created
    //constructor does not have any return type


    public QuizModel(int mQuestion, boolean mAnswer) {
        this.mQuestion = mQuestion;
        this.mAnswer = mAnswer;
    }

    public int getmQuestion() {
        return mQuestion;
    }

    public void setmQuestion(int mQuestion) {
        this.mQuestion = mQuestion;
    }

    public boolean ismAnswer() {
        return mAnswer;
    }

    public void setmAnswer(boolean mAnswer) {
        this.mAnswer = mAnswer;
    }
}
