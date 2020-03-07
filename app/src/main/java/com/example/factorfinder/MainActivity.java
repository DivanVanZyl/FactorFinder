package com.example.factorfinder;

import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        String testString = "test";

        final Button button = findViewById(R.id.btn_fact);
        button.setOnClickListener(new View.OnClickListener() {
            @RequiresApi(api = Build.VERSION_CODES.N)
            public void onClick(View v) {
                // Code here executes on main thread after user presses button
                TextView theCorrectAnsTextView = findViewById(R.id.answer);

                final EditText aField = findViewById(R.id.editTextA);
                final EditText bField = findViewById(R.id.editTextB);
                final EditText cField = findViewById(R.id.editTextC);

                String aString = aField.getText().toString();
                String bString = bField.getText().toString();
                String cString = cField.getText().toString();

                int aVal = Integer.parseInt(aString);
                final int bVal = Integer.parseInt(bString);
                int cVal = Integer.parseInt(cString);

                final List<Multiples> aMultiples = new ArrayList<>();
                final List<Multiples> cMultiples = new ArrayList<>();

                //find all multiples of a
                for(int cnt = aVal;cnt > 0;cnt--)
                {
                    if(aVal % cnt == 0)
                    {
                        aMultiples.add(new Multiples(cnt,(aVal/cnt)));
                    }
                }
                //find all multiples of c
                for(int cnt = cVal;cnt > 0;cnt--)
                {
                    if(cVal % cnt == 0)
                    {
                        cMultiples.add(new Multiples(cnt,(cVal/cnt)));
                    }
                }

                //try combinations of multiples of a and c, to find one that equals the value of b
                AtomicBoolean successFlag = new AtomicBoolean(false);
                aMultiples.forEach((a) ->
                {
                    cMultiples.forEach((c) ->
                    {
                        if((a.first * c.second) + (a.second * c.first) == bVal)
                        {
                            //found the multiples
                            successFlag.set(true);
                            theCorrectAnsTextView.setText("(" + a.first + "x * " + c.first + ")" + "(" + a.second + "x * " + c.second + ")");
                        }
                        //if(aMultiples)
                    });

                });

                if(successFlag.get() != true)
                {
                    theCorrectAnsTextView.setText("no integer possibility");
                }
            }
        });
    }
}
