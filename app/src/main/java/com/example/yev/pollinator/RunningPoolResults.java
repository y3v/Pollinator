package com.example.yev.pollinator;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;

import pojo.Poll;
import pojo.User;

public class RunningPoolResults extends AppCompatActivity {

    ArrayList<User> users;
    Poll poll;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_running_pool_results);

        Bundle extras = getIntent().getExtras();
        poll = extras.getParcelable("poll");
        users = extras.getParcelableArrayList("users");

        TextView questionDisplay = findViewById(R.id.questionDisplay2);
        questionDisplay.setText(poll.getQuestion());

        Button button1 = findViewById(R.id.choice1Button2);
        button1.setText(poll.getChoice1());

        Button button2 = findViewById(R.id.choice2Button2);
        button2.setText(poll.getChoice2());

        Button button3 = findViewById(R.id.choice3Button2);
        button3.setText(poll.getChoice3());

        Button button4 = findViewById(R.id.choice4Button2);
        button4.setText(poll.getChoice4());

        Button[] buttons = {button1, button2, button3, button4};
        for (final Button button: buttons) {
            button.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    showResultsPerClick(button.getText().toString());
                }
            });
        }

        Button newButton = findViewById(R.id.seeNew);
        newButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                newPoll();
            }
        });

    }

    private void newPoll(){
        Intent intent = new Intent(this, CreatePoll.class);
        startActivity(intent);
    }

    private void showResultsPerClick(String choice){
        Intent intent = new Intent(this, ShowUsers.class);
        intent.putParcelableArrayListExtra("users", users);
        intent.putExtra("choice", choice);
        startActivityForResult(intent, 2);
    }

}
