package com.example.tower;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.text.method.ScrollingMovementMethod;
import android.view.View;
import android.widget.Button;
import android.widget.ScrollView;
import android.widget.TextView;

public class Tower extends AppCompatActivity {

    TextView output;
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
        up = findViewById(R.id.up);
        down = findViewById(R.id.down);
        right = findViewById(R.id.right);
        left = findViewById(R.id.left);
        action = findViewById(R.id.action);
    }

    public static Intent createIntent(Context previous) {
        return new Intent(previous, Tower.class);
    }

    public void scrollview(java.lang.String toAdd) {
        output.append("\n" + toAdd);
    }
}
