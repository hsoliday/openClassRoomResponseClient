package com.example.tengentoppatank.quickapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.Socket;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final Button button = findViewById(R.id.button);
        final EditText userName = findViewById(R.id.editText2);
        final EditText passWord = findViewById(R.id.editText4);
        final EditText IP = findViewById(R.id.editText5);
        button.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v)
            {
                String user = userName.getText().toString();
                String pass = passWord.getText().toString();
                String ip = IP.getText().toString();
                Intent i = new Intent(MainActivity.this, WaitActivity.class);
                i.putExtra("IP", ip);
                i.putExtra("pass", pass);
                i.putExtra("user", user);
                startActivity(i);

            }
        });

    }
}
