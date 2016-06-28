package com.example.jokedisplay;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class jokeDisplayActivity extends AppCompatActivity {

    public static String joke_key = "Joke Key";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.joke_activity);
    }
}
