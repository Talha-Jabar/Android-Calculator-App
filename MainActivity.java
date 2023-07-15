package com.example.calculator_app;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private TextView resultTextView;
    private String currentNumber = "";
    private String operator = "";
    private double calculationResult = 0.0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        resultTextView = findViewById(R.id.resultTextView);

        // Set click listeners for all buttons
        setClickListeners();
    }

    private void setClickListeners() {
        ButtonClickListener buttonClickListener = new ButtonClickListener();

        findViewById(R.id.btnClear).setOnClickListener(buttonClickListener);
        findViewById(R.id.btnDivide).setOnClickListener(buttonClickListener);
        findViewById(R.id.btnMultiply).setOnClickListener(buttonClickListener);
        findViewById(R.id.btnBackspace).setOnClickListener(buttonClickListener);
        findViewById(R.id.btn7).setOnClickListener(buttonClickListener);
        findViewById(R.id.btn8).setOnClickListener(buttonClickListener);
        findViewById(R.id.btn9).setOnClickListener(buttonClickListener);
        findViewById(R.id.btnSubtract).setOnClickListener(buttonClickListener);
        findViewById(R.id.btn4).setOnClickListener(buttonClickListener);
        findViewById(R.id.btn5).setOnClickListener(buttonClickListener);
        findViewById(R.id.btn6).setOnClickListener(buttonClickListener);
        findViewById(R.id.btnAdd).setOnClickListener(buttonClickListener);
        findViewById(R.id.btn1).setOnClickListener(buttonClickListener);
        findViewById(R.id.btn2).setOnClickListener(buttonClickListener);
        findViewById(R.id.btn3).setOnClickListener(buttonClickListener);
        findViewById(R.id.btnEquals).setOnClickListener(buttonClickListener);
        findViewById(R.id.btn0).setOnClickListener(buttonClickListener);
        findViewById(R.id.btnDecimal).setOnClickListener(buttonClickListener);
    }

    private class ButtonClickListener implements View.OnClickListener {

        @Override
        public void onClick(View v) {
            switch (v.getId()) {
                case R.id.btnClear:
                    clear();
                    break;
                case R.id.btnDivide:
                    setOperator("/");
                    break;
                case R.id.btnMultiply:
                    setOperator("*");
                    break;
                case R.id.btnBackspace:
                    backspace();
                    break;
                case R.id.btn7:
                    appendNumber("7");
                    break;
                case R.id.btn8:
                    appendNumber("8");
                    break;
                case R.id.btn9:
                    appendNumber("9");
                    break;
                case R.id.btnSubtract:
                    setOperator("-");
                    break;
                case R.id.btn4:
                    appendNumber("4");
                    break;
                case R.id.btn5:
                    appendNumber("5");
                    break;
                case R.id.btn6:
                    appendNumber("6");
                    break;
                case R.id.btnAdd:
                    setOperator("+");
                    break;
                case R.id.btn1:
                    appendNumber("1");
                    break;
                case R.id.btn2:
                    appendNumber("2");
                    break;
                case R.id.btn3:
                    appendNumber("3");
                    break;
                case R.id.btnEquals:
                    calculateResult();
                    break;
                case R.id.btn0:
                    appendNumber("0");
                    break;
                case R.id.btnDecimal:
                    appendDecimal();
                    break;
            }
        }
    }

    private void appendNumber(String number) {
        currentNumber += number;
        updateResultTextView();
    }

    private void appendDecimal() {
        if (!currentNumber.contains(".")) {
            if (currentNumber.equals("")) {
                currentNumber += "0.";
            } else {
                currentNumber += ".";
            }
            updateResultTextView();
        }
    }

    private void setOperator(String operator) {
        if (!currentNumber.equals("")) {
            this.operator = operator;
            calculationResult = Double.parseDouble(currentNumber);
            currentNumber = "";
            updateResultTextView();
        }
    }

    private void calculateResult() {
        if (!currentNumber.equals("") && !operator.equals("")) {
            double number = Double.parseDouble(currentNumber);
            switch (operator) {
                case "/":
                    calculationResult /= number;
                    break;
                case "*":
                    calculationResult *= number;
                    break;
                case "-":
                    calculationResult -= number;
                    break;
                case "+":
                    calculationResult += number;
                    break;
            }
            currentNumber = String.valueOf(calculationResult);
            operator = "";
            updateResultTextView();
        }
    }

    private void backspace() {
        if (!currentNumber.equals("")) {
            currentNumber = currentNumber.substring(0, currentNumber.length() - 1);
            updateResultTextView();
        }
    }

    private void clear() {
        currentNumber = "";
        operator = "";
        calculationResult = 0.0;
        updateResultTextView();
    }

    private void updateResultTextView() {
        resultTextView.setText(currentNumber);
    }
}
