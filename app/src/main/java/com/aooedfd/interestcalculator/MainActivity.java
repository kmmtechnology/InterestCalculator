package com.aooedfd.interestcalculator;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.SeekBar;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    SeekBar seekBar;
    TextView seekValue,displayCalc;
    EditText principal, interest;
    Button calculate;
    String year;
    int years=0;
    static final String LOG_TAG="HelloWorldActivity";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        seekBar=(SeekBar)findViewById(R.id.seekBar);
        seekValue=(TextView)findViewById(R.id.seekValue);
        calculate=(Button)findViewById(R.id.calculateBtn);
        principal=(EditText)findViewById(R.id.principal);
        interest=(EditText)findViewById(R.id.interestRate);
        displayCalc=(TextView)findViewById(R.id.displayCalc);
        seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {

              seekValue.setText(String.valueOf(progress)+" Year(s)");
                year=String.valueOf(progress)+" year(s)";
                years=Integer.parseInt(String.valueOf(progress));
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });

        calculate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                double prin = Double.parseDouble(principal.getText().toString());
                double rate = Double.parseDouble(interest.getText().toString());
                displayCalc.setText("The interest for $" + principal.getText().toString() + " at a rate of $" + interest.getText().toString() + " for " + year + " is $" + (double) (prin * (rate / 100) * years));
            }
        });

        Log.v(LOG_TAG,"Activity has been created");

    }


}
