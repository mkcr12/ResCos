package com.example.rescos;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.provider.ContactsContract;
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

public class Register extends AppCompatActivity {
    EditText fullname,email,password;
    TextView login;
    FirebaseAuth fAuth;
    Button register;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        fullname = findViewById(R.id.fullname);
        email = findViewById(R.id.email);
        password = findViewById(R.id.password);
        register = findViewById(R.id.register);
        login = findViewById(R.id.login);
        fAuth = FirebaseAuth.getInstance();

        if (fAuth.getCurrentUser()!=null){
            startActivity(new Intent(getApplicationContext(),MainActivity4.class));
            finish();
        }
        register.setOnClickListener(new View.OnClickListener() {
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
                }
                fAuth.createUserWithEmailAndPassword(semail,spassword).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()){
                            Toast.makeText(Register.this, "User Created", Toast.LENGTH_SHORT).show();
                            startActivity(new Intent(getApplicationContext(),MainActivity4.class));
                        }
                        else{
                            Toast.makeText(Register.this, "Error !"+task.getException().getMessage(), Toast.LENGTH_SHORT).show();
                        }

                    }
                }) ;
            }
        });
        login.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                startActivity(new Intent(getApplicationContext(),Login.class));
            }
        });
    }
}