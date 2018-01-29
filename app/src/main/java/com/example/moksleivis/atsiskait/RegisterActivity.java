package com.example.moksleivis.atsiskait;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

/**
 * Created by moksleivis on 2018-01-29.
 */

public class RegisterActivity extends AppCompatActivity {
    public Button buttonSubmit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reg);

        final EditText etUsername = (EditText) findViewById(R.id.usernameReg);
        final EditText etPassword = (EditText) findViewById(R.id.passwordReg);
        final EditText etPasswordR = (EditText) findViewById(R.id.passwordRegR);
        final EditText etEmail = (EditText) findViewById(R.id.email);

        buttonSubmit = (Button) findViewById(R.id.buttonSubmit);
        buttonSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!Validation.isValidCredentials(etUsername.getText().toString())) {
                    etUsername.requestFocus();
                    etUsername.setError(getResources().getString(R.string.login_invalid_username));
                } else if (!Validation.isValidCredentials(etPassword.getText().toString()) || !Validation.isValidCredentials(etPasswordR.getText().toString())) {
                    etPassword.requestFocus();
                    etPassword.setError(getResources().getString(R.string.login_invalid_password));
                } else if (!etPassword.getText().toString().equals(etPasswordR.getText().toString())) {
                    etPasswordR.requestFocus();
                    etPasswordR.setError(getResources().getString(R.string.login_invalid_passwordR));
                } else if (!Validation.isValidEmail(etEmail.getText().toString())) {
                    etEmail.requestFocus();
                    etEmail.setError(getResources().getString(R.string.login_invalid_email));
                } else {
                    Intent i = new Intent(RegisterActivity.this, MainActivity.class);
                    startActivity(i);
                    Toast.makeText(getApplicationContext(), "Registered successfully", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}
