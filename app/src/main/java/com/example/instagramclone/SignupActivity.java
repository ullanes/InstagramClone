package com.example.instagramclone;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.parse.ParseException;
import com.parse.ParseUser;
import com.parse.SignUpCallback;

public class SignupActivity extends AppCompatActivity {

    private EditText etSignupUsername;
    private EditText etSignupPassword;
    private Button btnRegister;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);


        etSignupUsername = findViewById(R.id.etSignupUsername);
        etSignupPassword = findViewById(R.id.etSignupPassword);
        btnRegister = findViewById(R.id.btnRegister);

        btnRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String username = etSignupUsername.getText().toString();
                String password = etSignupPassword.getText().toString();

                checkValid( username, password);
            }
        });

    }

    private void checkValid( String username, String password) {

        ParseUser user = new ParseUser();
    
        user.setPassword(password);
        user.setUsername(username);

        user.signUpInBackground(new SignUpCallback() {
            public void done(ParseException e) {
                if (e == null) {
                   goLoginActivity();
                    // Hooray! Let them use the app now.
                } else {
                    // Sign up didn't succeed. Look at the ParseException
                    // to figure out what went wrong
                    Log.e("SignupActivity", "didnt succeed",e);
                }
            }
        });


    }

    private void goLoginActivity() {
        Intent i = new Intent(this,LoginActivity.class);
        startActivity(i);
        finish();
    }
}