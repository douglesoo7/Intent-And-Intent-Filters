package com.example.intent_and_intent_filters;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class HomeActivity extends AppCompatActivity {
    private TextView mTvUsername;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        mTvUsername=findViewById(R.id.tvUsername);
        Intent intent=getIntent();
        String username=intent.getStringExtra("username");
        mTvUsername.setText(username);
    }
}