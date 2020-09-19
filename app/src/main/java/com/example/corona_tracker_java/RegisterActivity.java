package com.example.corona_tracker_java;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.view.View.OnClickListener;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class RegisterActivity extends AppCompatActivity {

    private static final String TAG = MainActivity.class.getSimpleName();
    EditText mTextUsername;
    EditText mTextPassword;
    EditText getTextConfPassword;
    Button mButtonRegister;
    Button mButtontaketologinpage;
    TextView mTextViewLogin;

    private FirebaseAuth mAuth;
    private EditText inputEmail, inputPassword;
    private Button btnSignUp, btnResetPassword;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        mTextUsername = (EditText) findViewById(R.id.edittext_username);
        mTextPassword = (EditText) findViewById(R.id.edittext_password);
        mTextPassword = (EditText) findViewById(R.id.edittext_conf_password);
        mButtonRegister = (Button) findViewById(R.id.button_login);

        mAuth = FirebaseAuth.getInstance();
        btnSignUp = (Button) findViewById(R.id.sign_up_button);
        inputEmail = (EditText) findViewById(R.id.edittext_email);
        inputPassword = (EditText) findViewById(R.id.edittext_password);
        btnResetPassword = (Button) findViewById(R.id.btn_reset_password);

        createNewUser();
        addListenerOnButton();
    }


    public void updateUI(FirebaseUser currentUser) {
        if (currentUser != null) {
            Toast.makeText(this, "U Signed In successfully", Toast.LENGTH_LONG).show();
            startActivity(new Intent(this, GoogleMapsTracker.class));
        } else {
            Toast.makeText(this, "U Didnt signed in", Toast.LENGTH_LONG).show();
        }
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

    private void createNewUser() {
        final String email = "sorockminecraft@gmail.com";
        String password = "bigdickenergy";

        mAuth.createUserWithEmailAndPassword(email, password)
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()) {
                            Log.d(TAG, "Authentication successful");
                            FirebaseUser user = mAuth.getCurrentUser();
                            updateUI(user);
                        } else {
                            Log.w(TAG, "createUserWithEmail:failure", task.getException());
                            Toast.makeText(RegisterActivity.this, "Authentication failed.",
                                    Toast.LENGTH_SHORT).show();
                            updateUI(null);
                        }
                    }
                });
    }

    public void addListenerOnButtonSignUp() {

        final Context context = this;

        btnSignUp.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View arg0) {

                createNewUser();

            }
        });
    }
}
