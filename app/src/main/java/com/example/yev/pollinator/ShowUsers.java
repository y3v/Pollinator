package com.example.yev.pollinator;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

import pojo.User;

public class ShowUsers extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_users);

        Bundle extras = getIntent().getExtras();
        ArrayList<User> users = extras.getParcelableArrayList("users");
        String choice = extras.getString("choice");

        for (User user : users) {
            Log.d("PASSED CHOICE:", "PASSED CHOICE IS : " + choice);
            Log.d("USER FIRST NAME:", user.getFirstName());
            Log.d("USER LAST NAME:", user.getLastName());
            Log.d("USER EMAIL:", user.getEmail());
            Log.d("USER CHOICE:", user.getChoice());
        }

        Button okButton = findViewById(R.id.buttonOK);
        okButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });

        ListView list = findViewById(R.id.userList);
        ArrayAdapter<User> userAdapter = new ArrayAdapter<>(this, R.layout.activity_show_users);

        list.setAdapter(userAdapter);
        LinearLayout linear = findViewById(R.id.linear);

        for (User user : users) {
            if (user.getChoice().equals(choice)){
                TextView text = new TextView(this);
                text.setText(user.getLastName() + " " + user.getLastName());
                TextView text1 = new TextView(this);
                text1.setText(user.getEmail());
                LinearLayout.LayoutParams llp = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.WRAP_CONTENT);
                llp.setMargins(0 ,0 , 0, 30);
                text1.setLayoutParams(llp);
                linear.addView(text);
                linear.addView(text1);
            }
        }

    }
}
