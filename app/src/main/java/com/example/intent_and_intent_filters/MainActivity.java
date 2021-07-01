package com.example.intent_and_intent_filters;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
    private EditText mEtUsername,mEtEmail,mEtPassword;
    private Button mBtnLogin;
    private String emailValidation="[a-zA-Z0-9._-]+@[a-z]+\\.+[a-z]+";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initViwes();

        mBtnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                boolean isUsernameValid=isUsernameValid();
                boolean isEmailValid=isEmailValid();
                boolean isPasswordValid=isPasswordValid();
                if (isUsernameValid && isEmailValid && isPasswordValid){
                    Intent intent=new Intent(MainActivity.this,HomeActivity.class);
                    intent.putExtra("username",mEtUsername.getText().toString());
                    startActivity(intent);
                }

            }
        });
    }

    private void initViwes(){
        mEtUsername=findViewById(R.id.etUsername);
        mEtEmail=findViewById(R.id.etEmail);
        mEtPassword=findViewById(R.id.etPassword);
        mBtnLogin=findViewById(R.id.btnLogin);
    }

    private boolean isUsernameValid(){
        if (mEtUsername.getText().toString().trim().length()>=4){
            return true;
        }
        else{
            mEtUsername.setError("Invalid Username");
            return false;
        }
    }

    private boolean isEmailValid(){
        if(mEtEmail.getText().toString().matches(emailValidation)){
            return true;
        }
        else{
            mEtEmail.setError("Invalid Email");
            return false;
        }
    }

    private boolean isPasswordValid(){
        if(mEtPassword.getText().toString().length()>=6){
            return true;
        }
        else{
            mEtPassword.setError("Invalid Password");
            return false;
        }
    }
}