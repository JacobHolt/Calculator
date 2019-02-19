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
            if(textViewString == "") {
                textViewString = "" + number;
                textView.setText(textViewString);
            }
            else {
                textViewString = textViewString + " " + number;
                textView.setText(textViewString);
            }
        }
        else if(id.contains("multiply")){
            textViewString = textViewString + " *";
            textView.setText(textViewString);
        }
        else if(id.contains("divide")){
            textViewString = textViewString + " /";
            textView.setText(textViewString);
        }
        else if(id.contains("plus")){
            textViewString = textViewString + " +";
            textView.setText(textViewString);
        }
        else if(id.contains("minus")){
            textViewString = textViewString + " -";
            textView.setText(textViewString);
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
