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
    /**
     * This method displays the score when the submit quiz button Is pressed.
     */
    public void SubmitQuiz(View view){

        CheckBox question1_answer1 = findViewById(R.id.answer1_question1);
        boolean firstAnswer = question1_answer1.isChecked();

        CheckBox question1_answer2 = findViewById(R.id.answer2_question1);
        boolean secondAnswer = question1_answer2.isChecked();

        // this are the answer for question 2 check boxes

        CheckBox question2_answer2 = findViewById(R.id.answer2_question2);
        boolean secondAnswerQuestion2 = question2_answer2.isChecked();

        CheckBox question2_answer4 = findViewById(R.id.answer4_question2);
        boolean fourthAnswerQuestion2 = question2_answer4.isChecked();

        // correct answer for question 3

        EditText question3_Answer = findViewById(R.id.question3_answer);
        String question3CorrectAnswer = question3_Answer.getText().toString();

        // correct answer for question 4
        RadioButton CorrectAnswerRadioButton = findViewById(R.id.Correct_radio_button);
        boolean question4correctAnswer = CorrectAnswerRadioButton.isChecked();

        // This assigns the quiz taker name to a string variable
        EditText nameOfQuizTaker = findViewById(R.id.name);
        String Name = nameOfQuizTaker.getText().toString();

        int Score = calculateQuizScore(firstAnswer,secondAnswer,secondAnswerQuestion2,fourthAnswerQuestion2,question4correctAnswer,question3CorrectAnswer);

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
                                   boolean question2CorrectAnswer2, boolean question4CorrectAnswer, String question3CorrectAnswer){

        int question1Score;
        int question2Score;
        int question3Score;
        int question4Score;

        if (question1CorrectAnswer && question1CorrectAnswer2) {
            question1Score = 25;
        } else {
            question1Score = 0;
        }
        if (question2CorrectAnswer && question2CorrectAnswer2) {
            question2Score = 25;
        } else {
            question2Score = 0;
        }
        if (question3CorrectAnswer.equals("Lika")){
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
