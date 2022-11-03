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
    Spinner toCurrency;
    TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        toCurrency = (Spinner)findViewById(R.id.planets_spinner);
        ArrayList<String> to = new ArrayList<>();
        to.add("EURO");
        to.add("USD");
        ArrayAdapter<String> arrayAdapterto = new ArrayAdapter<String>(this,android.R.layout.simple_spinner_item, to);
        arrayAdapterto.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        toCurrency.setAdapter(arrayAdapterto);

        final EditText edtDinarValue = (EditText)findViewById(R.id.editText4);
        final Button btnConvert = (Button)findViewById(R.id.button);
        textView =(TextView) findViewById(R.id.textView7);


        btnConvert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(!edtDinarValue.getText().toString().isEmpty())
                {
                    String toCurr = toCurrency.getSelectedItem().toString();
                    double dVlaue = Double.valueOf(edtDinarValue.getText().toString());

                    Toast.makeText(MainActivity.this, "Please Wait..", Toast.LENGTH_SHORT).show();
                    try {
                        convertCurrency(toCurr, dVlaue);
                    } catch (Exception e) {
                        e.printStackTrace();
                        Toast.makeText(MainActivity.this, e.getMessage(), Toast.LENGTH_SHORT).show();
                    }
                }
                else
                {
                    Toast.makeText(MainActivity.this, "Please Enter a Value to Convert..", Toast.LENGTH_SHORT).show();
                }

            }
        });

    }

    public void convertCurrency(final String toCurr, final double euroVlaue)  {

        if (toCurr == "EURO"){
            double output = euroVlaue/0.32;
            textView.setText(String.valueOf(output));
        }
        if (toCurr == "USD"){
            double output = euroVlaue*0.31;
            textView.setText(String.valueOf(output));
        }

    }
}