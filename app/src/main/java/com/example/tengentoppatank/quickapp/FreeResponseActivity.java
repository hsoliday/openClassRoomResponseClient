package com.example.tengentoppatank.quickapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class FreeResponseActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_free_response);
        TextView textView = findViewById(R.id.textView4);
        final EditText editText = findViewById(R.id.editText);
        Button button = findViewById(R.id.button6);
        Intent i = getIntent();
        final  String pass = i.getStringExtra("pass");
        final String IP = i.getStringExtra("IP");
        final String user = i.getStringExtra("user");
        String question = i.getStringExtra("question");
        button.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v)
            {
                final String ans = editText.getText().toString();
                Thread thread = new Thread(new Runnable() {
                    public void run() {
                        try {
                            Socket socket = new Socket(IP, 8080);
                            BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                            PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
                            out.println(user);
                            out.println(pass);
                            out.println(ans);
                            out.flush();

                        } catch (Exception e) {

                        }
                    }
                });
                thread.start();
                finish();

            }
        });

    }

    @Override
    protected void onResume() {
        super.onResume();
            setContentView(R.layout.activity_free_response);
            TextView textView = findViewById(R.id.textView4);
            final EditText editText = findViewById(R.id.editText);
            Button button = findViewById(R.id.button6);
            Intent i = getIntent();
            final  String pass = i.getStringExtra("pass");
            final String IP = i.getStringExtra("IP");
            final String user = i.getStringExtra("user");
            String question = i.getStringExtra("question");
            button.setOnClickListener(new View.OnClickListener() {
                public void onClick(View v)
                {
                    final String ans = editText.getText().toString();
                    Thread thread = new Thread(new Runnable() {
                        public void run() {
                            try {
                                Socket socket = new Socket(IP, 8080);
                                BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                                PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
                                out.println(user);
                                out.println(pass);
                                out.println(ans);
                                out.flush();

                            } catch (Exception e) {

                            }
                        }
                    });
                    thread.start();
                    finish();

                }
            });
    }
}
