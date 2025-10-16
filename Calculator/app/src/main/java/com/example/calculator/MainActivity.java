package com.example.calculator;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private EditText display;
    private String input = "", operator = "";
    private double num1, num2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        display = findViewById(R.id.display);

        setButtonListeners();
    }

    private void setButtonListeners() {
        int[] buttonIds = {
                R.id.btn0, R.id.btn1, R.id.btn2, R.id.btn3, R.id.btn4,
                R.id.btn5, R.id.btn6, R.id.btn7, R.id.btn8, R.id.btn9,
                R.id.btnadd, R.id.btnSubtract, R.id.btnMultiply, R.id.btnDivide,
                R.id.btnAC, R.id.btnEquals, R.id.btnDot, R.id.btnPercent,
                R.id.btnBS
        };

        for (int id : buttonIds) {
            Button button = findViewById(id);
            button.setOnClickListener(this::onButtonClick);
        }
    }

    public void onButtonClick(View view) {
        Button button = (Button) view;
        String buttonText = button.getText().toString();

        switch (buttonText) {
            case "AC":
                input = "";
                operator = "";
                display.setText("0");
                break;
            case "BS":
                if (!input.isEmpty()) {
                    input = input.substring(0, input.length() - 1);
                    display.setText(input);
                }
                break;
            case "+": case "−": case "x": case "÷":
                if (!input.isEmpty()) {
                    num1 = Double.parseDouble(input);
                    operator = buttonText;
                    input = "";
                }
                break;
            case "=":
                if (!input.isEmpty() && !operator.isEmpty()) {
                    num2 = Double.parseDouble(input);
                    double result = calculate(num1, num2, operator);
                    display.setText(String.valueOf(result));
                    input = String.valueOf(result);
                    operator = "";
                }
                break;
            case "%":
                if (!input.isEmpty()) {
                    double percentValue = Double.parseDouble(input) / 100;
                    display.setText(String.valueOf(percentValue));
                    input = String.valueOf(percentValue);
                }
                break;
            case ".":
                if (!input.contains(".")) {
                    input += buttonText;
                    display.setText(input);
                }
                break;
            default:
                input += buttonText;
                display.setText(input);
                break;
        }
    }

    private double calculate(double num1, double num2, String operator) {
        switch (operator) {
            case "+": return num1 + num2;
            case "−": return num1 - num2;
            case "x": return num1 * num2;
            case "÷": return num2 != 0 ? num1 / num2 : 0;
            default: return 0;
        }
    }
}
