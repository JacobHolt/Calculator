package com.example.jsu.project1;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import java.util.*;
import java.util.Arrays;

public class Calculator extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calculator);
    }

    public void onClick(View v) {
        String id = (v.getResources().getResourceName(v.getId())).split("/")[1];
        TextView textView = (TextView) findViewById(R.id.mainText);
        String textViewString = "";
        int number;

        if(id.contains("button")) {
            String numberString = id.replaceAll("[^0-9]", "");
            number = Integer.parseInt(numberString);
        }
        else {

        }
    }

    public int multiply(int a, int b) {
        return a * b;
    }
    public int divide(int a, int b) {
        return a / b;
    }
    public int add(int a, int b) {
        return a + b;
    }
    public int subtract(int a, int b) {
        return a - b;
    }
}
