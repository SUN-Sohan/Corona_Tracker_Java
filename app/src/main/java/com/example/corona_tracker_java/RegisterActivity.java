package com.example.corona_tracker_java;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.view.View.OnClickListener;

public class RegisterActivity extends AppCompatActivity {
    EditText mTextUsername;
    EditText mTextPassword;
    EditText getTextConfPassword;
    Button mButtonRegister;
    Button mButtontaketologinpage;
    TextView mTextViewLogin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        mTextUsername = (EditText) findViewById(R.id.edittext_username);
        mTextPassword = (EditText) findViewById(R.id.edittext_password);
        mTextPassword = (EditText) findViewById(R.id.edittext_conf_password);
        mButtonRegister = (Button) findViewById(R.id.button_login);
        addListenerOnButton();
    }


    public void addListenerOnButton() {

        final Context context = this;

        mButtontaketologinpage = (Button) findViewById(R.id.button_taketologinpage);

        mButtontaketologinpage.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View arg0) {

                Intent intent = new Intent(context, MainActivity.class);
                startActivity(intent);

            }

        });
    }
}
