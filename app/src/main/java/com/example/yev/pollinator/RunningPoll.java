package com.example.yev.pollinator;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import pojo.Poll;
import pojo.User;

public class RunningPoll extends AppCompatActivity {

    private ArrayList<User> users = new ArrayList<User>();
    private Poll poll;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_running_poll);

        Bundle extras = getIntent().getExtras();
        poll = extras.getParcelable("poll");

        TextView question = findViewById(R.id.questionDisplay);
        question.setText(poll.getQuestion());

        Button choice1 = findViewById(R.id.choice1Button);
        choice1.setText(poll.getChoice1());

        Button choice2 = findViewById(R.id.choice2Button);
        choice2.setText(poll.getChoice2());

        Button choice3 = findViewById(R.id.choice3Button);
        choice3.setText(poll.getChoice3());

        Button choice4 = findViewById(R.id.choice4Button);
        choice4.setText(poll.getChoice4());

        Button[] buttons = {choice1,choice2,choice3,choice4};

        for (final Button button: buttons) {
            button.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    getRegistration(button.getText().toString());
                }
            });
        }

        Button resultsButton = findViewById(R.id.seeResultsButton);
        resultsButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                getResults(poll);
            }
        });
    }

    private void getRegistration(String choice){
        Intent intent = new Intent(this,VoterRegistration.class);
        intent.putExtra("choice", choice);
        startActivityForResult(intent, 1);
    }

    public void onActivityResult(int requestCode, int resultCode, Intent data){
        Log.d("I'M BACK BABY", "----------------");
        User user = data.getExtras().getParcelable("user");
        if (user != null){
            Log.d("USER FIRST NAME:", user.getFirstName());
            Log.d("USER LAST NAME:", user.getLastName());
            Log.d("USER EMAIL:", user.getEmail());
            users.add(user);
        }
        else{
            Log.d("USER:", "IS NULL");
        }

        //check to see that all user info is persisted
        Log.d("CHECK THE ARRAYLIST:", "-------------");
        for (User u: users) {
            Log.d("USER FIRST NAME:", u.getFirstName());
            Log.d("USER LAST NAME:", u.getLastName());
            Log.d("USER EMAIL:", u.getEmail());
            Log.d("USER CHOICE:", u.getChoice());
        }

    }

    private void getResults(Poll poll){
        Intent intent = new Intent(this, RunningPoolResults.class);
        intent.putParcelableArrayListExtra("users", users);
        intent.putExtra("poll", poll);
        startActivity(intent);
    }
}
