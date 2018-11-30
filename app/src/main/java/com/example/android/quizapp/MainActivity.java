package com.example.android.quizapp;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    int score ;


    /**
     * This method displays the score when the submit quiz button Is pressed.
     */

    public void SubmitQuiz(View view){

    CheckBox question1_answer1 = findViewById(R.id.answer1_question1);
    boolean firstAnswer = question1_answer1.isChecked();

    CheckBox question1_answer3 = findViewById(R.id.answer3_question1);
        boolean thirdAnswer = question1_answer3.isChecked();


        CheckBox question1_answer4 = findViewById(R.id.answer4_question1);
        boolean fourthAnswer = question1_answer4.isChecked();

        CheckBox question1_answer5 = findViewById(R.id.answer5_question1);
        boolean fifthAnswer = question1_answer5.isChecked();

        // this are the answer for question 2 check boxes

        RadioButton question2_answer = findViewById(R.id.answer1_question2);
        boolean question2correctAnswer = question2_answer.isChecked();



        // correct answer for question 3

        EditText question3_Answer = findViewById(R.id.question3_answer);
        String question3CorrectAnswer = question3_Answer.getText().toString();




     // correct answer for question 4
        RadioButton CorrectAnswerRadioButton = findViewById(R.id.Correct_radio_button);
        boolean question4correctAnswer = CorrectAnswerRadioButton.isChecked();






        // This assigns the quiz taker name to a string variable
        EditText nameOfQuizTaker = findViewById(R.id.name);
        String Name = nameOfQuizTaker.getText().toString();



        int Score = calculateQuizScore(firstAnswer,thirdAnswer,fourthAnswer,fifthAnswer,question3CorrectAnswer,question2correctAnswer,question4correctAnswer);

        Context context = getApplicationContext();
        CharSequence text =  Name + " Your Score is:" + Score;
        int duration = Toast.LENGTH_SHORT;

        Toast toast = Toast.makeText(context, text, duration);
        toast.show();


    }

/**
 * This method calculates the quiz score
 */

    private int calculateQuizScore(boolean question1CorrectAnswer, boolean question1CorrectAnswer2,boolean question2CorrectAnswer,
                                   boolean question4CorrectAnswer, String question3CorrectAnswer,boolean question1CorrectAnswer3,boolean question1CorrectAnswer4){

        int question1Score;
        int question2Score;
        int question3Score;
        int question4Score;


        if (question1CorrectAnswer && question1CorrectAnswer2 && question1CorrectAnswer3 && question1CorrectAnswer4) {
            question1Score = 25;
        } else {
            question1Score = 0;
        }


        if (question2CorrectAnswer) {
            question2Score = 25;
        } else {
            question2Score = 0;
        }

        if (question3CorrectAnswer.equals("voiced, palatal, fricative")){
            question3Score = 25 ;
        } else {
            question3Score = 0;
        }

        if (question4CorrectAnswer){
            question4Score = 25;
        } else {
            question4Score = 0;
        }




        return question1Score + question2Score + question4Score + question3Score;














    }









































}
