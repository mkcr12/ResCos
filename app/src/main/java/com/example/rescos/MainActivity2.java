package com.example.rescos;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.rescos.R;

public class MainActivity2 extends AppCompatActivity {
    private String[] questions ={"largest waste producing country in the world is canada?",
            "there are 2 R's of waste management", "35% of fiber is used in U.S mills comes from recovered paper",
            "wood fiber can be recycled infinitely"};
    private boolean[] answers={true,false,true,false};
    private int score=0;
    Button yes;
    Button no;
    TextView question;
    TextView textview;
    private int index=0;
    private Object TextView;

    @Override
    public void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        textview = findViewById(R.id.textview);
        Intent intent = getIntent();
        String ar = intent.getStringExtra(MainActivity.EXTRA_NAME);
        textview.setText(ar);
        yes=findViewById(R.id.yes);
        no=findViewById(R.id.no);
        question = findViewById(R.id.question);
        question.setText(questions[index]);
        yes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(index <= questions.length - 1)
                {if (answers[index] == true) {
                    score++;
                }
                    index++;
                    if(index <= questions.length -1)
                    {question.setText(questions[index]);}

                    else {
                        Toast.makeText(MainActivity2.this, "Your score is:" + score, Toast.LENGTH_SHORT).show(); }
                }else {

                    Toast.makeText(MainActivity2.this, "Restart", Toast.LENGTH_SHORT).show();
                }
            }}

        );
        no.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (index <= questions.length - 1) {
                    if (answers[index] == false) {
                        score++;
                    }
                    index++;
                    if (index <= questions.length - 1) {
                        question.setText(questions[index]);
                    } else {
                        Toast.makeText(MainActivity2.this, "Your score is:" + score, Toast.LENGTH_SHORT).show();
                    }
                } else {
                    Toast.makeText(MainActivity2.this, "Restart", Toast.LENGTH_SHORT).show();
                }
            }   });

    }
}