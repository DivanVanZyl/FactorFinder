package com.example.factorfinder;

import android.annotation.SuppressLint;
import android.os.Build;
import android.os.Bundle;
import android.text.Editable;
import android.text.Html;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import static java.lang.Double.parseDouble;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final EditText aField = findViewById(R.id.editTextA);
        final EditText bField = findViewById(R.id.editTextB);
        final EditText cField = findViewById(R.id.editTextC);

        final Button button = findViewById(R.id.btn_fact);
        button.setOnClickListener(new View.OnClickListener() {
            @RequiresApi(api = Build.VERSION_CODES.N)
            public void onClick(View v) {

                // Code here executes on main thread after user presses button
                TextView theCorrectAnsTextView = findViewById(R.id.answer);

                divisionHelper div = new divisionHelper();

                String firstResult;
                String secondResult;
                //double secondRoot = 0, firstRoot = 0;

                double aVal = parseDouble(aField.getText().toString());
                final double bVal = parseDouble(bField.getText().toString());
                double cVal = parseDouble(cField.getText().toString());

                //quadratic formula
                double determinant = (bVal*bVal)-(4*aVal*cVal);
                double sqrt = Math.sqrt(determinant);

                if(determinant>0){
                    firstResult = div.fraction((-bVal + sqrt),(2*aVal));
                    secondResult = div.fraction((-bVal - sqrt),(2*aVal));

                    theCorrectAnsTextView.setText(android.text.Html.fromHtml("<br /> The Roots are: x = " + firstResult + "  or x = " + secondResult + " <br />", Html.FROM_HTML_MODE_COMPACT));
                    }else if(determinant == 0){
                    theCorrectAnsTextView.setText("Root is : "+(-bVal + sqrt)/(2*aVal));
                }else {
                    theCorrectAnsTextView.setText("determinant is < 0!");
                }
            }
        });
        //end of button click listener

        //begin text edit listeners
        aField.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @SuppressLint("SetTextI18n")
            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                TextView aValText = findViewById(R.id.aValViewHeading);

                if(aField.getText().length() > 0)
                {
                    if(aField.getText().toString().contains("."))
                    {
                        try {
                            double a = Double.parseDouble(aField.getText().toString());
                            aValText.setText(Double.toString(a));
                        } catch (NumberFormatException ex) {
                            aValText.setText("(Not valid)");
                        }
                    } else
                    {
                        try {
                            int a = Integer.parseInt(aField.getText().toString());
                            aValText.setText(Integer.toString(a));

                        } catch (NumberFormatException e)
                        {
                            aValText.setText("(Not valid)");
                        }
                    }
                }
                else
                {
                    aValText.setText("a");
                }

            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });

        bField.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @SuppressLint("SetTextI18n")
            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                TextView bValText = findViewById(R.id.bValViewHeading);

                if(bField.getText().length() > 0)
                {
                    if(bField.getText().toString().contains("."))
                    {
                        try {
                            double b = Double.parseDouble(bField.getText().toString());
                            bValText.setText(Double.toString(b));
                        } catch (NumberFormatException ex) {
                            bValText.setText("(Not valid)");
                        }
                    } else
                    {
                        try {
                            int b = Integer.parseInt(bField.getText().toString());
                            bValText.setText(Integer.toString(b));

                        } catch (NumberFormatException e)
                        {
                            bValText.setText("(Not valid)");
                        }
                    }
                }
                else
                {
                    bValText.setText("b");
                }

            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });

        cField.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @SuppressLint("SetTextI18n")
            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                TextView cValText = findViewById(R.id.cValViewHeading);

                if(cField.getText().length() > 0)
                {
                    if(cField.getText().toString().contains("."))
                    {
                        try {
                            double c = Double.parseDouble(cField.getText().toString());
                            cValText.setText(Double.toString(c));
                        } catch (NumberFormatException ex) {
                            cValText.setText("(Not valid)");
                        }
                    } else
                    {
                        try {
                            int c = Integer.parseInt(cField.getText().toString());
                            cValText.setText(Integer.toString(c));

                        } catch (NumberFormatException e)
                        {
                            cValText.setText("(Not valid)");
                        }
                    }
                }
                else
                {
                    cValText.setText("c");
                }

            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });
    }
}
