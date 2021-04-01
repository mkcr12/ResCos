package com.example.rescos;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.widget.ListViewAutoScrollHelper;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;

public class MainActivity extends AppCompatActivity {
    ListView listview;

    public static final String EXTRA_NAME = "com.example.rescos.extra.NAME";
    String arr[] = {"level 1", "level 2", "level 3"};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        listview=findViewById(R.id.listview);
        ArrayAdapter ad = new ArrayAdapter(this, android.R.layout.simple_list_item_1, arr);
        listview.setAdapter(ad);
        listview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
                        public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                //Toast.makeText(MainActivity.this, "you clicked on:" +i, Toast.LENGTH_SHORT).show();
            if(i==0)
            {Toast.makeText(MainActivity.this, "level 1", Toast.LENGTH_SHORT).show();
                                Intent intent = new Intent(MainActivity.this, MainActivity2.class);
                //s=arr[i];
                intent.putExtra(EXTRA_NAME,arr[i]);
            startActivity(intent);}
            if(i==1)
            {Toast.makeText(MainActivity.this, "level 2", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(MainActivity.this, MainActivity2.class);
                //s=arr[i];
                intent.putExtra(EXTRA_NAME,arr[i]);
                startActivity(intent); }
            if(i==2)
            {Toast.makeText(MainActivity.this, "level 3", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(MainActivity.this, MainActivity2.class);
                //s=arr[i];
                intent.putExtra(EXTRA_NAME,arr[i]);
                startActivity(intent);}
            }

        });
    }

       }

