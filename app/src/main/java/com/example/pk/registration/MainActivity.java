package com.example.pk.registration;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private EditText loginEt;
    private EditText emailEt;
    private EditText phoneNumberEt;
    private EditText passwordEt;
    private EditText repeatPasswordEt;

    private static final String LOGIN_KEY = "login";
    private static final String EMAIL_KEY = "email";
    private static final String PHONE_NUMBER_KEY = "phone number";
    private static final String PASSWORD_KEY = "password";
    private static final String REPEAT_PASSWORD_KEY = "repeat password";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        loginEt = (EditText) findViewById(R.id.loginEditText);
        emailEt = (EditText) findViewById(R.id.emailEditText);
        phoneNumberEt = (EditText) findViewById(R.id.phoneNumberEditText);
        passwordEt = (EditText) findViewById(R.id.passwordEditText);
        repeatPasswordEt = (EditText) findViewById(R.id.repeatPasswordEditText);

        final Button registrationButton = (Button) findViewById(R.id.registration_button);
        registrationButton.setOnClickListener(this);
    }


    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.registration_button:
                checkValidation();
                break;
        }
    }

    /**
     * This method check the edit text views for validation and out result.
     */
    private void checkValidation() {
        String login = loginEt.getText().toString();
        String email = emailEt.getText().toString();
        String phoneNumber = phoneNumberEt.getText().toString();
        String password = passwordEt.getText().toString();
        String repeatPassword = repeatPasswordEt.getText().toString();

        String finalResult = "";

        //check login
        if (login.isEmpty()) {
            finalResult += "Login is empty; ";
        }
        //check email
        if (email.isEmpty()) {
            finalResult += "Email is empty; ";
        }
        if (!email.contains("@") && !email.isEmpty()) {
            finalResult += "Incorrect email; ";
        }
        //check phone number
        if (phoneNumber.isEmpty()) {
            finalResult += "Phone number is empty; ";
        }
        if ((!phoneNumber.startsWith("+380") || phoneNumber.length() != 13) && !phoneNumber.isEmpty()) {
            finalResult += "Incorrect phone number; ";
        }
        //check password and repeat password
        if (password.isEmpty()) {
            finalResult += "Password is empty; ";
        }
        if (repeatPassword.isEmpty()) {
            finalResult += "Repeat password is empty; ";
        }
        if (!password.equals(repeatPassword)) {
            finalResult += "Passwords do not match; ";
        }

        //show final toast
        if (finalResult.isEmpty()) {
            Toast.makeText(this, "Validation complete!", Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(this, finalResult, Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);

        outState.putString(LOGIN_KEY, loginEt.getText().toString());
        outState.putString(EMAIL_KEY, emailEt.getText().toString());
        outState.putString(PHONE_NUMBER_KEY, phoneNumberEt.getText().toString());
        outState.putString(PASSWORD_KEY, passwordEt.getText().toString());
        outState.putString(REPEAT_PASSWORD_KEY, repeatPasswordEt.getText().toString());
    }

    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);

        loginEt.setText(savedInstanceState.getString(LOGIN_KEY));
        emailEt.setText(savedInstanceState.getString(EMAIL_KEY));
        phoneNumberEt.setText(savedInstanceState.getString(PHONE_NUMBER_KEY));
        passwordEt.setText(savedInstanceState.getString(PASSWORD_KEY));
        repeatPasswordEt.setText(savedInstanceState.getString(REPEAT_PASSWORD_KEY));
    }
}
