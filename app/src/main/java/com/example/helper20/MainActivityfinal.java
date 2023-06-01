package com.example.helper20;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.app.ProgressDialog;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.webkit.WebView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.TextView;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;

public class MainActivityfinal extends AppCompatActivity {

    //private static final String JSON_URL = "http://92.63.106.150:5000/";
    //TextView textView;
   // WebView webView;
    //String tmp;

    Button btnHit;
    TextView txtJson;
    ProgressDialog pd;




    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_activityfinal);

        //webView = findViewById(R.id.webView);

       // Intent intent = getIntent();

        btnHit = (Button) findViewById(R.id.btnHit);
        txtJson = (TextView) findViewById(R.id.tvJsonItem);

        btnHit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new JsonTask().execute("http://92.63.106.150:5000/api/recognize");
            }
        });



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

    private class JsonTask extends AsyncTask<String, String, String> {

        protected void onPreExecute() {
            super.onPreExecute();

            pd = new ProgressDialog(MainActivityfinal.this);
            pd.setMessage("Please wait");
            pd.setCancelable(false);
            pd.show();
        }

        protected String doInBackground(String... params) {


            HttpURLConnection connection = null;
            BufferedReader reader = null;

            try {
                URL url = new URL(params[0]);
                connection = (HttpURLConnection) url.openConnection();
                connection.connect();


                InputStream stream = connection.getInputStream();

                reader = new BufferedReader(new InputStreamReader(stream));

                StringBuffer buffer = new StringBuffer();
                String line = "";

                while ((line = reader.readLine()) != null) {
                    buffer.append(line+"\n");
                    Log.d("Response: ", "> " + line);   //here u ll get whole response...... :-)

                }

                return buffer.toString();


            } catch (MalformedURLException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            } finally {
                if (connection != null) {
                    connection.disconnect();
                }
                try {
                    if (reader != null) {
                        reader.close();
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            return null;
        }

        @Override
        protected void onPostExecute(String result) {
            super.onPostExecute(result);
            if (pd.isShowing()){
                pd.dismiss();
            }
            txtJson.setText(result);
        }
    }
}


