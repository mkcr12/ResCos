package com.example.rescos;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.google.firebase.auth.FirebaseAuth;

public class MainActivity4 extends AppCompatActivity {
    Button activity,quiz,reduse,url;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main4);
        activity =  findViewById(R.id.activity);
        quiz = findViewById(R.id.quiz);
        reduse = findViewById(R.id.reduse);
        url = findViewById(R.id.url);
        activity.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity4.this,MainActivity3.class);
                startActivity(intent);

            }
        });
       quiz.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity4.this,MainActivity.class);
                startActivity(intent);

            }
        });

       reduse.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity4.this,MainActivity5.class);
                startActivity(intent);

            }
        });
        url.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity4.this,MainActivity6.class);
                startActivity(intent);

            }
        });


    }
    public void Logout(View view) {
        FirebaseAuth.getInstance().signOut();
        startActivity(new Intent(getApplicationContext(),Login.class));
        finish();
    }

}

