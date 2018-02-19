package com.example.aaron.medicalcalculator;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

import java.text.DecimalFormat;

public class MainActivity extends AppCompatActivity {

    double conversionRate = 2.2;
    double weightEntered;
    double convertedWeight;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setLogo(R.mipmap.ic_launcher);
        getSupportActionBar().setDisplayUseLogoEnabled(true);

        final RadioButton lbsToKilos = findViewById(R.id.radLbsToKilo);
        final RadioButton kiloToLbs = findViewById(R.id.radKiloToLbs);
        final EditText weight = (EditText) findViewById(R.id.txtWeight);
        final TextView result = (TextView) findViewById(R.id.txtResult);

        final Button convert = (Button) findViewById(R.id.btnConvert);

        convert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                weightEntered = Double.parseDouble(weight.getText().toString());
                DecimalFormat tenth = new DecimalFormat("#.#");

                if (lbsToKilos.isChecked()){
                    if (weightEntered <= 500){
                         convertedWeight = weightEntered/conversionRate;
                         result.setText(tenth.format(convertedWeight) + " kilograms");
                    }else{
                        Toast.makeText(MainActivity.this,"Pounds entered must be less than 500", Toast.LENGTH_SHORT).show();
                    }
                }
                if (kiloToLbs.isChecked()) {
                    if (weightEntered <= 225) {
                        convertedWeight = weightEntered * conversionRate;
                        result.setText(tenth.format(convertedWeight) + " lbs");
                    } else {
                        Toast.makeText(MainActivity.this, "Kilos entered must be less than 225", Toast.LENGTH_SHORT).show();
                    }

                }
            }
        });









    }

}
