package com.example.roman.todolistandroidapp.ui;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.example.roman.todolistandroidapp.R;

public class AuthorizationActivity extends AppCompatActivity {

    Intent intent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_authorization);
    }

    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.signIn:
                intent = new Intent(this, MainActivity.class);
                startActivity(intent);
                break;
            case R.id.register:
                intent = new Intent(this, RegistrationActivity.class);
                startActivity(intent);
                break;
        }
    }
}
