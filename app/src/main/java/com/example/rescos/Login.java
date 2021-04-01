package com.example.rescos;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class Login extends AppCompatActivity {
    EditText email,password;
    Button login;
    TextView register;
    FirebaseAuth fAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        email = findViewById(R.id.email);
        password = findViewById(R.id.password1);
        register = findViewById(R.id.register);
        login = findViewById(R.id.login1);
        fAuth = FirebaseAuth.getInstance();

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String semail = email.getText().toString().trim();
                String spassword = password.getText().toString().trim();

                if (TextUtils.isEmpty(semail)){
                    email.setError("Email is Required");
                    return;
                }
                if (TextUtils.isEmpty(spassword)){
                    password.setError("Password is Required");
                    return;
                }
                if (password.length() <= 6){
                    password.setError("Password must be greater than 6 characters");
                    return;
                }fAuth.signInWithEmailAndPassword(semail,spassword).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()){
                            Toast.makeText(Login.this, "Logged in successfully", Toast.LENGTH_SHORT).show();
                            startActivity(new Intent(getApplicationContext(),MainActivity4.class));
                        }
                        else{
                            Toast.makeText(Login.this, "Error !"+task.getException().getMessage(), Toast.LENGTH_SHORT).show();
                        }

                    }
                }) ;
            }
        });
        register.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                startActivity(new Intent(getApplicationContext(),Register.class));
            }
        });
    }
}