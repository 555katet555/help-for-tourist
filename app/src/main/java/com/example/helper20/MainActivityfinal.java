package com.example.helper20;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.TextView;

import java.util.List;

public class MainActivityfinal extends AppCompatActivity {

    //private static final String JSON_URL = "http://92.63.106.150:5000/";
    //TextView textView;
   // WebView webView;
    //String tmp;



    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_activityfinal);

        //webView = findViewById(R.id.webView);

       // Intent intent = getIntent();


        Button btn_hm = (Button) findViewById(R.id.btn_hm);
        btn_hm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent1 = new Intent(MainActivityfinal.this, MainActivity.class);
                startActivity(intent1);
            }


        });

        //loadJSONFromURL(JSON_URL);
    }
    //private void loadJSONFromURL(String url){
        //final ProgressBar progressBar = (ProgressBar) findViewById(R.id.progressBar);
   // }

}