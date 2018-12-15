package com.example.gonza.savingscalculatortester;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    double amt, balance;
    int days, edays, times;
    String result;
    int len1, len2, len3;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        amt = 0;
        balance = 0;
        days = 0;
        edays = 0;
        times = 0;





        findViewById(R.id.final_result_button).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                len1 = ((EditText) findViewById(R.id.amt_input)).length();
                len2 = ((EditText) findViewById(R.id.days_input)).length();
                len3 = ((EditText) findViewById(R.id.edays_input)).length();


                if (len1 == 0 || len2 == 0 || len3 == 0)
                    Toast.makeText(getApplicationContext(), "You must enter all the fields", Toast.LENGTH_SHORT).show();
                else if( Double.valueOf(((EditText) findViewById(R.id.amt_input)).getText().toString()) < 1 || Integer.valueOf(((EditText) findViewById(R.id.days_input)).getText().toString()) < 1 || Integer.valueOf(((EditText) findViewById(R.id.edays_input)).getText().toString()) < 1)
                    Toast.makeText(getApplicationContext(), "None of your entries can be 0", Toast.LENGTH_SHORT).show();
                else {
                    amt = Double.valueOf(((EditText) findViewById(R.id.amt_input)).getText().toString());
                    days = Integer.valueOf(((EditText) findViewById(R.id.days_input)).getText().toString());
                    edays = Integer.valueOf(((EditText) findViewById(R.id.edays_input)).getText().toString());
                    result = "You will save $" + getResult() + " in " + edays + " days if you save $" + amt + " every " + days + " days.";
                    ((TextView) findViewById(R.id.print_result)).setText(result);
                    findViewById(R.id.print_result).setVisibility(View.VISIBLE);

                }


            }
        });


        findViewById(R.id.reset_button).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                ((EditText) findViewById(R.id.amt_input)).setText("");
                ((EditText) findViewById(R.id.days_input)).setText("");
                ((EditText) findViewById(R.id.edays_input)).setText("");


                findViewById(R.id.print_result).setVisibility(View.INVISIBLE);

            }
        });


    }


    public double getResult() {

        times = edays / days;
        balance = amt * times;
        balance = ((int) (balance * 100.00)) / 100.00;
        return balance;
    }


}
