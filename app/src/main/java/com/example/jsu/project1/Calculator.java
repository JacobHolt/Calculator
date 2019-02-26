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
        String textViewString = textView.getText().toString();
        int number;

        if(id.contains("button")) {
            String numberString = id.replaceAll("[^0-9]", "");
            number = Integer.parseInt(numberString);
            textViewString = textViewString + number;
            textView.setText(textViewString);
        }
        else if(id.contains("multiply")){
            textViewString = textViewString + " * ";
            textView.setText(textViewString);
        }
        else if(id.contains("divide")){
            textViewString = textViewString + " / ";
            textView.setText(textViewString);
        }
        else if(id.contains("plus")){
            textViewString = textViewString + " + ";
            textView.setText(textViewString);
        }
        else if(id.contains("minus")){
            textViewString = textViewString + " - ";
            textView.setText(textViewString);
        }
        else if(id.contains("clear")) {
            textView.setText("");
            textViewString = "";
        }
        else if(id.contains("equals")) {
            textView.setText("" + equalsSign());
        }
        else if(id.contains("changeSigns")) {
            if(textViewString.contains("-")) {
                textViewString = textViewString.replaceAll("- ", "");
                textView.setText(textViewString);
            }
            else { textViewString = "- " + textViewString; textView.setText(textViewString); }
        }
        else if(id.contains("decimal")) {
            textViewString = textViewString + ".";
            textView.setText(textViewString);
        }
        else if(id.contains("percent")) {
            textViewString += "% ";
            textView.setText(textViewString);
        }
        else if(id.contains("sqrt")) {
            double numSqrt = Integer.parseInt(textViewString);
            textView.setText("" + Math.sqrt(numSqrt));
        }
    }

    public double equalsSign() {

        TextView textView = (TextView) findViewById(R.id.mainText);
        String textViewString = textView.getText().toString();
        String[] parts = textViewString.split("(?=[-/*+])|(?<=[-/*+])");
        System.out.println(Arrays.toString(parts));
        double result = Double.parseDouble(parts[0]);
        for (int i = 1; i < parts.length; i += 2) {
            String op = parts[i];
            double val = Double.parseDouble(parts[i+1]);
            switch (op) {
                case "*" :
                    result *= val;
                    break;
                case "/" :
                    result /= val;
                    break;
                case "-" :
                    result -= val;
                    break;
                case "+" :
                    result += val;
                    break;
                case "%d" :
                    result *= val/100;
                    break;
            }
        }
        return result;
    }
}
