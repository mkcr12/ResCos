package com.example.rescos;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity6 extends AppCompatActivity {
    Button button1,button2,button3,button4,button5;
    TextView url1,url2,url3,url4,url5;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main6);
        button1 = findViewById(R.id.button1);
        url1 = findViewById(R.id.url1);
        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view){
                String urltext = url1.getText().toString();
                Uri webpage = Uri.parse(urltext);
                Intent intent = new Intent(Intent.ACTION_VIEW,webpage);
                 startActivity(intent);
                 }
        });

        button2 = findViewById(R.id.button2);
        url2 = findViewById(R.id.url2);
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view){
                String urltext1 = url2.getText().toString();
                Uri webpage = Uri.parse(urltext1);
                Intent intent = new Intent(Intent.ACTION_VIEW,webpage);

                    startActivity(intent);
                }
        });

        button3 = findViewById(R.id.button3);
        url3 = findViewById(R.id.url3);
        button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view){
                String urltext2 = url3.getText().toString();
                Uri webpage = Uri.parse(urltext2);
                Intent intent = new Intent(Intent.ACTION_VIEW,webpage);
                startActivity(intent);

            }
        });

        button4 = findViewById(R.id.button4);
        url4 = findViewById(R.id.url4);
        button4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view){
                String urltext3 = url4.getText().toString();
                Uri webpage = Uri.parse(urltext3);
                Intent intent = new Intent(Intent.ACTION_VIEW,webpage);

                    startActivity(intent);
            }
        });

        button5 = findViewById(R.id.button5);
        url5 = findViewById(R.id.url5);
        button5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view){
                String urltext4 = url5.getText().toString();
                Uri webpage = Uri.parse(urltext4);
                Intent intent = new Intent(Intent.ACTION_VIEW,webpage);
                 startActivity(intent);
                }
        });
    }
}