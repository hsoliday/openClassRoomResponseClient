package com.example.tengentoppatank.quickapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class MultipleChoice extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_multiple_choice);
        Intent i = getIntent();
        String question = i.getStringExtra("question");
        final String ans = i.getStringExtra("answer1");
        final String ans2 = i.getStringExtra("answer2");
        final String ans3 = i.getStringExtra("answer3");
        final String ans4 = i.getStringExtra("answer4");
        final  String pass = i.getStringExtra("pass");
        final String IP = i.getStringExtra("IP");
        final String user = i.getStringExtra("user");
        TextView questionView = findViewById(R.id.textView3);
        Button button1 = findViewById(R.id.button2);
        Button button2 = findViewById(R.id.button3);
        Button button3 = findViewById(R.id.button4);
        Button button4 = findViewById(R.id.button5);
        questionView.setText(question.toCharArray(),0,question.toCharArray().length);
        button1.setText(ans.toCharArray(),0,ans.toCharArray().length);
        button2.setText(ans2.toCharArray(),0,ans2.toCharArray().length);
        button3.setText(ans3.toCharArray(),0,ans3.toCharArray().length);
        button4.setText(ans4.toCharArray(),0,ans4.toCharArray().length);
        button1.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v)
            {
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
        button2.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v)
            {
                Thread thread = new Thread(new Runnable() {
                    public void run() {
                        try {
                            Socket socket = new Socket(IP, 8080);
                            BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                            PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
                            out.println(user);
                            out.println(pass);
                            out.println(ans2);
                            out.flush();

                        } catch (Exception e) {

                        }
                    }
                });
                thread.start();
                finish();
            }
        });
        button3.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v)
            {
                Thread thread = new Thread(new Runnable() {
                    public void run() {
                        try {
                            Socket socket = new Socket(IP, 8080);
                            BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                            PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
                            out.println(user);
                            out.println(pass);
                            out.println(ans3);
                            out.flush();

                        } catch (Exception e) {

                        }
                    }
                });
                thread.start();
                finish();
            }
        });
        button4.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v)
            {
                Thread thread = new Thread(new Runnable() {
                    public void run() {
                        try {
                            Socket socket = new Socket(IP, 8080);
                            BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                            PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
                            out.println(user);
                            out.println(pass);
                            out.println(ans4);
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
