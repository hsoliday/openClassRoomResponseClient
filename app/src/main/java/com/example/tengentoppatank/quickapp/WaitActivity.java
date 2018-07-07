package com.example.tengentoppatank.quickapp;

import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.ArrayList;

public class WaitActivity extends AppCompatActivity {

    String u;
    String p;
    String ii;
    protected void onResume()
    {
        super.onResume();
        setContentView(R.layout.activity_wait);
        TextView t = findViewById(R.id.textView2);
        final Handler handler = new Handler();
        Thread thread = new Thread(new Runnable() {
            public void run() {
                try {
                    Socket socket = new Socket(ii, 8080);
                    BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                    PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
                    out.println(u);
                    out.println(p);
                    out.flush();
                    String line, str;
                    ArrayList<String> arr = new ArrayList<String>();
                    boolean flag = false;
                    while (true) {
                        line = in.readLine();
                        Log.d("APPU",line);
                        if (line.equals("question")) {
                            flag = true;
                            continue;
                        }
                        if (line.equals("end")) {
                            break;
                        }
                        if (flag) {
                            arr.add(line);
                        }
                    }
                    String question = arr.get(0);
                    if (arr.size() < 3) {
                        Intent intent = new Intent(WaitActivity.this, FreeResponseActivity.class);
                        intent.putExtra("question", question);
                        intent.putExtra("IP", ii);
                        intent.putExtra("pass", p);
                        intent.putExtra("user", u);
                        startActivity(intent);
                    } else {
                        Intent intent = new Intent(WaitActivity.this, MultipleChoice.class);
                        intent.putExtra("question", question);
                        intent.putExtra("answer1", arr.get(1));
                        intent.putExtra("answer2", arr.get(2));
                        intent.putExtra("answer3", arr.get(3));
                        intent.putExtra("answer4", arr.get(4));
                        startActivity(intent);
                    }
                } catch (Exception e) {
                }
            }
        });
        thread.start();
    }

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_wait);
        Intent i = getIntent();
        final String pass = i.getStringExtra("pass");
        final String IP = i.getStringExtra("IP");
        final String user = i.getStringExtra("user");
        u = user;
        p = pass;
        ii = IP;
        TextView t = findViewById(R.id.textView2);
        final Handler handler = new Handler();
        Thread thread = new Thread(new Runnable() {
            public void run() {
                try {
                    Socket socket = new Socket(IP, 8080);
                    BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                    PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
                    out.println(user);
                    out.println(pass);
                    out.flush();
                    String line, str;
                    ArrayList<String> arr = new ArrayList<String>();
                    boolean flag = false;
                    while (true) {
                        line = in.readLine();
                        Log.d("APPU",line);
                        if (line.equals("question")) {
                            flag = true;
                            continue;
                        }
                        if (line.equals("end")) {
                            break;
                        }
                        if (flag) {
                            arr.add(line);
                        }
                    }
                    String question = arr.get(0);
                    if (arr.size() < 3) {
                        Intent intent = new Intent(WaitActivity.this, FreeResponseActivity.class);
                        intent.putExtra("question", question);
                        intent.putExtra("IP", IP);
                        intent.putExtra("pass", pass);
                        intent.putExtra("user", user);
                        startActivity(intent);
                    } else {
                        Intent intent = new Intent(WaitActivity.this, MultipleChoice.class);
                        intent.putExtra("question", question);
                        intent.putExtra("answer1", arr.get(1));
                        intent.putExtra("answer2", arr.get(2));
                        intent.putExtra("answer3", arr.get(3));
                        intent.putExtra("answer4", arr.get(4));
                        intent.putExtra("IP", IP);
                        intent.putExtra("pass", pass);
                        intent.putExtra("user", user);
                        startActivity(intent);
                    }
                } catch (Exception e) {
                }
            }
        });
            thread.start();

    }
}
