package com.example.convertisseurdedevise;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;


import java.io.IOException;
import java.text.BreakIterator;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;


public class MainActivity extends AppCompatActivity {

    public static BreakIterator data;
    List<String> keysList;
    Spinner toCurrency, fromCurrency;
    TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        fromCurrency = (Spinner) findViewById(R.id.planets_spinner);
        ArrayList<String> from = new ArrayList<>();
        from.add("DT");
        from.add("EURO");
        from.add("USD");
        ArrayAdapter<String> arrayAdapterto = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, from);
        arrayAdapterto.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        fromCurrency.setAdapter(arrayAdapterto);

        toCurrency = (Spinner) findViewById(R.id.planets_spinner2);
        ArrayList<String> to = new ArrayList<>();
        to.add("DT");
        to.add("EURO");
        to.add("USD");
        ArrayAdapter<String> arrayAdapterfrom = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, to);
        arrayAdapterfrom.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        toCurrency.setAdapter(arrayAdapterfrom);

        final EditText edtDinarValue = (EditText) findViewById(R.id.editText4);
        final Button btnConvert = (Button) findViewById(R.id.button);
        textView = (TextView) findViewById(R.id.textView7);


        btnConvert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!edtDinarValue.getText().toString().isEmpty()) {
                    String toCurr = toCurrency.getSelectedItem().toString();
                    String fromCurr = fromCurrency.getSelectedItem().toString();
                    double dVlaue = Double.valueOf(edtDinarValue.getText().toString());


                    try {
                        convertCurrency(fromCurr, toCurr, dVlaue);
                    } catch (Exception e) {
                        e.printStackTrace();
                        Toast.makeText(MainActivity.this, e.getMessage(), Toast.LENGTH_SHORT).show();
                    }
                } else {
                    Toast.makeText(MainActivity.this, "Please Enter a Value to Convert..", Toast.LENGTH_SHORT).show();
                }

            }
        });

    }

    public void convertCurrency(final String fromCurr, final String toCurr, final double euroVlaue) {

        switch (fromCurr) {
            case "DT":
                switch (toCurr) {
                    case "DT": {
                        double sum = euroVlaue;
                        String output = "votre montant en DT est : " + sum;
                        textView.setText(output);
                        break;
                    }
                    case "EURO": {
                        double sum = euroVlaue / 3.2;
                        String output = "votre montant TND en Euro  est : " + sum;
                        textView.setText(output);
                        break;
                    }
                    case "USD": {
                        double sum = euroVlaue / 3;
                        String output = "votre montant TND en USD est : " + sum;
                        textView.setText(output);

                        break;
                    }
                }

                break;
            case "EURO":
                switch (toCurr) {
                    case "DT": {
                        double sum = euroVlaue * 3;
                        String output = "votre montant EURO en TND est : " + sum;
                        textView.setText(output);
                        break;
                    }
                    case "EURO": {
                        double sum = euroVlaue;
                        String output = "votre montant de TND en Euro  est : " + sum;
                        textView.setText(output);
                        break;
                    }
                    case "USD": {
                        double sum = euroVlaue * 1;
                        String output = "votre montant de TND en USD est : " + sum;
                        textView.setText(output);

                        break;
                    }
                }

                break;
            case "USD":
                switch (toCurr) {
                    case "DT": {
                        double sum = euroVlaue * 3.2;
                        String output = "votre montant USD en dinars est : " + sum;
                        textView.setText(output);
                        break;
                    }
                    case "EURO": {
                        double sum = euroVlaue * 1;
                        String output = "votre montant USD en Euro  est : " + sum;
                        textView.setText(output);
                        break;
                    }
                    case "USD": {
                        double sum = euroVlaue;
                        String output = "votre montant en USD est : " + sum;
                        textView.setText(output);
                        break;
                    }
                }
                break;
        }


    }
}