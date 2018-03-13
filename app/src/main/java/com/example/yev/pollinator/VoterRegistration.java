package com.example.yev.pollinator;

import android.content.Intent;
import android.support.design.widget.TextInputEditText;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;

import pojo.User;

public class VoterRegistration extends AppCompatActivity {

    private String firstname;
    private String lastname;
    private String email;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_voter_registration);

        final TextInputEditText firstnameView = findViewById(R.id.first_name);
        final TextInputEditText lastnameView = findViewById(R.id.last_name);
        final TextInputEditText emailView = findViewById(R.id.email);

        Bundle extras = getIntent().getExtras();
        final String choice = extras.getString("choice");

        Button cast = findViewById(R.id.castVote);
        cast.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                firstname = firstnameView.getText().toString();
                lastname = lastnameView.getText().toString();
                email = emailView.getText().toString();

                if (!checkIfEmpty(firstnameView, lastnameView, emailView)){
                    User user = new User(firstname, lastname, email, choice);
                    Intent intent = new Intent();
                    setResult(RESULT_OK, intent);
                    intent.putExtra("user", user);
                    finish();
                }
            }
        });
    }

    private boolean checkIfEmpty(TextInputEditText fname, TextInputEditText lname, TextInputEditText mail){
        boolean isEmpty = false;

        if (TextUtils.isEmpty(firstname)){
            fname.setError("Do not leave this section blank");
            isEmpty = true;
        }
        if (TextUtils.isEmpty(lastname)){
            lname.setError("Do not leave this section blank");
            isEmpty = true;
        }
        if (TextUtils.isEmpty(email)){
            mail.setError("Do not leave this section blank");
            isEmpty = true;
        }

        return isEmpty;
    }
}
