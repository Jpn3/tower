package com.example.tower;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.text.method.ScrollingMovementMethod;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.ScrollView;
import android.widget.TextView;

public class Tower extends AppCompatActivity {

    static TextView output;
    Button up;
    Button down;
    Button left;
    Button right;
    Button action;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.towergame);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        output = findViewById(R.id.output);
        output.setMovementMethod(new ScrollingMovementMethod());
        output.setGravity(Gravity.LEFT | Gravity.BOTTOM);
        scrollview("Your goal is to complete all the challenges in this tower.");
        up = findViewById(R.id.up);
        up.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Player.up();
            }
        });
        down = findViewById(R.id.down);
        down.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Player.down();
            }
        });
        right = findViewById(R.id.right);
        right.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Player.right();
            }
        });
        left = findViewById(R.id.left);
        left.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Player.left();
            }
        });
        action = findViewById(R.id.action);
        action.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Player.action();
            }
        });
    }

    public static Intent createIntent(Context previous) {
        return new Intent(previous, Tower.class);
    }

    public static void scrollview(java.lang.String toAdd) {
        output.append("\n" + toAdd);
    }
}
