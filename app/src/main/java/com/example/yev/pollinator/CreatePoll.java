package com.example.yev.pollinator;

import android.content.Intent;
import android.support.design.widget.TextInputEditText;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import pojo.Poll;

public class CreatePoll extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_poll);

        Button submitQ = findViewById(R.id.submitQuestion);

        final TextInputEditText question = findViewById(R.id.question);
        final TextInputEditText choice1 = findViewById(R.id.choice1);
        final TextInputEditText choice2 = findViewById(R.id.choice2);
        final TextInputEditText choice3 = findViewById(R.id.choice3);
        final TextInputEditText choice4 = findViewById(R.id.choice4);

        submitQ.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (!checkIfEmpty()){
                    Poll poll = new Poll(question.getText().toString(), choice1.getText().toString(), choice2.getText().toString(), choice3.getText().toString(), choice4.getText().toString());
                    nextActivity(poll);
                }
            }
        });
    }

   private boolean checkIfEmpty(){
        boolean isEmpty = false;

        TextInputEditText question = findViewById(R.id.question);
        TextInputEditText choice1 = findViewById(R.id.choice1);
        TextInputEditText choice2 = findViewById(R.id.choice2);
        TextInputEditText choice3 = findViewById(R.id.choice3);
        TextInputEditText choice4 = findViewById(R.id.choice4);


        if (TextUtils.isEmpty(question.getText().toString())){
            question.setError(getResources().getString(R.string.question_empty));
            isEmpty = true;
        }
        if (TextUtils.isEmpty(choice1.getText().toString())){
            choice1.setError(getResources().getString(R.string.choice_empty));
            isEmpty = true;
        }
        if (TextUtils.isEmpty(choice2.getText().toString())){
            choice2.setError(getResources().getString(R.string.choice_empty));
            isEmpty = true;
        }
        if (TextUtils.isEmpty(choice3.getText().toString())){
            choice3.setError(getResources().getString(R.string.choice_empty));
            isEmpty = true;
        }
        if (TextUtils.isEmpty(choice4.getText().toString())){
            choice4.setError(getResources().getString(R.string.choice_empty));
            isEmpty = true;
        }
       Log.d("It's empty:", "onClick: " + isEmpty);

        return isEmpty;
    }

    private void nextActivity(Poll poll){
        Intent intent = new Intent(this, RunningPoll.class);
        /*Log.d("Poll value:", "onClick: " + poll.getQuestion());
        Log.d("Poll value:", "onClick: " + poll.getChoice1());
        Log.d("Poll value:", "onClick: " + poll.getChoice2());
        Log.d("Poll value:", "onClick: " + poll.getChoice3());
        Log.d("Poll value:", "onClick: " + poll.getChoice4());*/
        intent.putExtra("poll", poll);
        startActivity(intent);
    }
}
