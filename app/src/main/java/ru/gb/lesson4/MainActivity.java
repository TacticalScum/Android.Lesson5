package ru.gb.lesson4;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    public static final String NUMBER_1 = "NUMBER_1";
    public static final String NUMBER_2 = "NUMBER_2";
    public static final String SYMBOL = "SYMBOL";
    public static final String RESULT = "RESULT";
    private EditText num1View;
    private TextView symbolView;
    private EditText num2View;
    private TextView resultView;
    String a;
    String b;
    String c;
    String x;
    Buttons buttons = new Buttons();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActionBar actionBar = getSupportActionBar();
        actionBar.hide();
        setContentView(R.layout.activity_main);

        num1View = findViewById(R.id.num1View);
        symbolView = findViewById(R.id.symbolView);
        num2View = findViewById(R.id.num2View);
        resultView = findViewById(R.id.resultView);

        Button butn0 = findViewById(R.id.button0);
        buttonsValueSetter(butn0);

        Button butn1 = findViewById(R.id.button1);
        buttonsValueSetter(butn1);

        Button butn2 = findViewById(R.id.button2);
        buttonsValueSetter(butn2);

        Button butn3 = findViewById(R.id.button3);
        buttonsValueSetter(butn3);

        Button butn4 = findViewById(R.id.button4);
        buttonsValueSetter(butn4);

        Button butn5 = findViewById(R.id.button5);
        buttonsValueSetter(butn5);

        Button butn6 = findViewById(R.id.button6);
        buttonsValueSetter(butn6);

        Button butn7 = findViewById(R.id.button7);
        buttonsValueSetter(butn7);

        Button butn8 = findViewById(R.id.button8);
        buttonsValueSetter(butn8);

        Button butn9 = findViewById(R.id.button9);
        buttonsValueSetter(butn9);

        Button butnPlus = findViewById(R.id.buttonPlus);
        symbolsValueSetter(butnPlus);

        Button butnDigit = findViewById(R.id.buttonDigit);
        symbolsValueSetter(butnDigit);

        Button butnClear = findViewById(R.id.buttonClear);
        butnClear.setOnClickListener(v -> {
            a = " ";
            b = " ";
            c = " ";
            x = " ";
            updateView();
            updateResultView();
        });

        Button butnMultiply = findViewById(R.id.buttonMultiply);
        if (c == null) {
            c = " ";
        }
        symbolsValueSetter(butnMultiply);

        Button butnMinus = findViewById(R.id.buttonMinus);
        symbolsValueSetter(butnMinus);

        Button butnEquals = findViewById(R.id.buttonEquals);
        butnEquals.setOnClickListener(v -> {
            if (a != null && b != null && c.equals("+")) {
                x = buttons.setPlusResult(a, b);
                updateResultView();
            }

            if (a != null && b != null && c.equals("-")) {
                x = buttons.setMinusResult(a, b);
                updateResultView();
            }

            if (b.equals("0") && c.equals("÷")) {
                resultView.setText("Ошибка");
            } else if (a != null && c.equals("÷")) {
                x = buttons.setDigitResult(a, b);
                updateResultView();
            }

            if (a != null && b != null && c.equals("x")) {
                x = buttons.setMultiplyResult(a, b);
                updateResultView();
            }
        });
    }

    private void buttonsValueSetter(Button button) {
        button.setOnClickListener(v -> {
            if (a == null || a.equals(" ")) {
                a = button.getText().toString();
            } else {
                b = button.getText().toString();
            }
            updateView();
        });
    }

    private void symbolsValueSetter(Button button) {
        button.setOnClickListener(v -> {
            c = button.getText().toString();
            updateView();
        });
    }

    private void updateView() {
        if (a != null) {
            num1View.setText(a);
        }
        if (b != null) {
            num2View.setText(b);
        }
        symbolView.setText(String.valueOf(c));
    }

    private void updateResultView() {
        resultView.setText(String.valueOf(x));
    }

    @Override
    protected void onRestoreInstanceState(@NonNull Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        a = savedInstanceState.getString(NUMBER_1);
        b = savedInstanceState.getString(NUMBER_2);
        c = savedInstanceState.getString(SYMBOL);
        updateView();
        x = savedInstanceState.getString(RESULT);
        updateResultView();
    }

    @Override
    protected void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putString(NUMBER_1, a);
        outState.putString(NUMBER_2, b);
        outState.putString(SYMBOL, c);
        outState.putString(RESULT, x);
    }
}