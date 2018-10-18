package com.example.aleix.calculadora;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {



    private TextView curr_num;
    private Button igual_btn;
    private boolean decimalFicat;
    private float aux1;
    private char operador;
    private float CE;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        curr_num = findViewById(R.id.curr_num);
        decimalFicat = false;

        igual_btn = (Button) findViewById(R.id.btn_igual);


        igual_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                float aux2 = Float.parseFloat(curr_num.getText().toString());
                float total = 0;

                switch (operador){
                    case '+':
                        total = (aux1+aux2);
                        break;
                    case '-':
                        total = (aux1-aux2);
                        break;
                    case '/':
                        total = (aux1/aux2);
                        break;
                    case '*':
                        total = (aux1*aux2);
                        break;
                }
                curr_num.setText(""+total);
                Log.d("numero", aux1+"..."+aux2+"..."+total);
            }
        });


    }

    public void onClickDigit(View view){
        Button b = (Button)view;
        char digit = b.getText().toString().charAt(0);
        String curr = curr_num.getText().toString();
        curr_num.setText(curr + digit);


    }

    public void onClickOperator (View view){
        decimalFicat = false;

        Button b = (Button)view;
        operador = b.getText().toString().charAt(0);

        aux1 = Float.parseFloat(curr_num.getText().toString());
        curr_num.setText("");
    }


    public void onClickDecimal(View view) {
        Button b = (Button)view;
        char digit = b.getText().toString().charAt(0);

        // EVENT
        if(!decimalFicat){
            String curr = curr_num.getText().toString();
            curr_num.setText(curr + digit);
        }

        decimalFicat = true;


    }

    public void onClickCE (View view){

        Button b = (Button)view;
        CE = b.getText().toString().charAt(0);

        CE = Float.parseFloat(curr_num.getText().toString());
        curr_num.setText("");
}
    }
