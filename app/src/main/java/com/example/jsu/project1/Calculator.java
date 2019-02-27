package com.example.jsu.project1;

import android.os.Bundle;
import android.support.v4.content.res.TypedArrayUtils;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import java.util.*;
import java.util.Arrays;
import java.lang.*;

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
            textViewString += " %";
            textView.setText(textViewString);

        }
        else if(id.contains("sqrt")) {
            double numSqrt = Double.parseDouble(textViewString);
            textView.setText("" + Math.sqrt(numSqrt));
        }
    }
    public double equalsSign() {
        TextView textView = (TextView) findViewById(R.id.mainText);
        String textViewString = textView.getText().toString().replaceAll("\\s","");
        String[] parts = textViewString.split("(?=[-/*+%])|(?<=[-/*+%])");
        double result = Double.parseDouble(parts[0]);
        List<String> list = new LinkedList<>(Arrays.asList(parts));
        List<Double> partsNum = new ArrayList<>();
        if(list.contains("%")) {
            list.remove(1);
            list.remove(2);
            double[] parsed = new double[parts.length];
            for (int i = 0; i < list.size(); i++) parsed[i] = Double.valueOf(list.get(i));
            for (int i = 0; i < list.size(); i++) list.set(i, String.valueOf(parsed[i]));
            for(String s : list) partsNum.add(Double.valueOf(s));
            Double[] numbers = new Double[partsNum.size()];
            for(int k = 0; k < partsNum.size(); k++){
                numbers[k] = partsNum.get(k);
            }
            double temp1 = numbers[0] * (numbers[1]/100);
            double temp2;
            for (int i = 1; i < parts.length; i += 2) {
                String op = parts[i];
                switch (op) {
                    case "*":
                        temp2 = numbers[0] * temp1;
                        result = temp2;
                        break;
                    case "/":
                        temp2 = numbers[0] / temp1;
                        result = temp2;
                        break;
                    case "-":
                        temp2 = numbers[0] - temp1;
                        result = temp2;
                        break;
                    case "+":
                        temp2 = numbers[0] + temp1;
                        result = temp2;
                        break;
                }
            }
        }
        else {
            for (int i = 1; i < parts.length; i += 2) {
                String op = parts[i];
                double val = Double.parseDouble(parts[i + 1]);
                switch (op) {
                    case "*":
                        result *= val;
                        break;
                    case "/":
                        result /= val;
                        break;
                    case "-":
                        result -= val;
                        break;
                    case "+":
                        result += val;
                        break;
                }
            }
        }
        return result;
    }
}
