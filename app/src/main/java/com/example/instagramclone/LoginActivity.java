package com.example.instagramclone;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.parse.LogInCallback;
import com.parse.ParseException;
import com.parse.ParseUser;

public class LoginActivity extends AppCompatActivity{

    public static final String TAG = "LoginActivity";
    private EditText etUsername;
    private EditText etPassword;
    private Button btnLogin;

        // start by creating the login screen
        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_login);

            if (ParseUser.getCurrentUser() != null) {
                goMainActivity();
            }

            etPassword = findViewById(R.id.etPassword);
            etUsername = findViewById(R.id.etUsername);
            btnLogin = findViewById(R.id.btnLogin);

            //create a listener to the login button
            btnLogin.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Log.i(TAG, "onClick login button");
                    String username = etUsername.getText().toString();
                    String password = etPassword.getText().toString();
                    loginUser(username, password);
                }
            });
        }

    private void loginUser(String username, String password) {
            Log.i(TAG, "Attameping to login user " + username);

        ParseUser.logInInBackground(username, password, new LogInCallback() {
            @Override
            public void done(ParseUser user, ParseException e) {
                // if the username and password does not match we end the this method
                if (e != null) {
                    Log.e(TAG, "Issue with login", e);
                    Toast.makeText(LoginActivity.this, "Issue with login!", Toast.LENGTH_SHORT).show();
                    return;
                }

                // if the username and password match, we will go to the MainActivity
                goMainActivity();
                Toast.makeText(LoginActivity.this, "Success!", Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void goMainActivity() {
            Intent i = new Intent(this, MainActivity.class);
            startActivity(i);

            // when the MainActvity start, we will no longer go back to login Activity
            finish();
    }
}

