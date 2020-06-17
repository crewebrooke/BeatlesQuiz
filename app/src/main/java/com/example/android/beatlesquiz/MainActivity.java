package com.example.android.beatlesquiz;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {


    private int correctAnswers;
    Button submitScore;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        submitScore = findViewById(R.id.submitScore);
        submitScore.setOnClickListener(submitScoreOnClickListener);
    }

    /**
     * This method is called when Q1 is answered.
     */
    private void QuestionOne() {
        CheckBox questionOneGeorge = findViewById(R.id.question1George);
        CheckBox questionOneRingo = findViewById(R.id.question1Ringo);
        CheckBox questionOnePaul = findViewById(R.id.question1Paul);
        boolean isGeorgeChecked = questionOneGeorge.isChecked();
        boolean isRingoChecked = questionOneRingo.isChecked();
        boolean isPaulChecked = questionOnePaul.isChecked();

        if (isRingoChecked && isPaulChecked && !isGeorgeChecked) {
            correctAnswers += 1;
        }
    }

    /**
     * This method is called when Q2 is answered.
     */
    private void QuestionTwo() {
        RadioButton ericnotInBeatles = findViewById(R.id.question2Eric);
        boolean isEricChecked = ericnotInBeatles.isChecked();
        if (isEricChecked) {
            correctAnswers += 1;

        }
    }

    /**
     * This method is called when Q3 is answered.
     */
    private void QuestionThree() {
        RadioButton theQuarryMen = findViewById(R.id.question3Quarry);
        boolean isQuarryChecked = theQuarryMen.isChecked();
        if (isQuarryChecked) {
            correctAnswers += 1;
        } else {
            correctAnswers += 0;
        }
    }

    /**
     * This method is called when Q4 is answered.
     */
    private void QuestionFour() {
        RadioButton letItBe = findViewById(R.id.question4Letitbe);
        boolean isLetItBeChecked = letItBe.isChecked();
        if (isLetItBeChecked) {
            correctAnswers += 1;
        } else {
            correctAnswers += 0;
        }
    }

    /**
     * This method is called when Q5 is answered.
     */
    private String Question5() {
        EditText addText = findViewById(R.id.name_field);
        String name = addText.getText().toString();
        return name;
    }

    private void Question5Answer() {
        String name = Question5();
        if (name.equalsIgnoreCase("liverpool")) {
            correctAnswers += 1;
        }

    }

    /**
     * This method calculates the 5 questions are correct
     */
    private void checkAnswers() {
        QuestionOne();
        QuestionTwo();
        QuestionThree();
        QuestionFour();
        Question5Answer();
    }

    private void resetCounterCorrectAnswers() {
        correctAnswers = 0;
    }

    final View.OnClickListener submitScoreOnClickListener = new View.OnClickListener() {
        public void onClick(final View v) {
            checkAnswers();
            Toast.makeText(MainActivity.this, "Correct Answers: " + correctAnswers + "/5",
                    Toast.LENGTH_SHORT).show();
            resetCounterCorrectAnswers();
        }
    };
}




