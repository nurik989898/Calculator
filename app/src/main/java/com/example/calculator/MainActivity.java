package com.example.calculator;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.text.DecimalFormat;

public class MainActivity extends AppCompatActivity {
    private TextView tvResult;
    private double firstVar;
    private double secondVar;
    private String operation;
    private Boolean isOperatin;
    private Button btn_go;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tvResult = findViewById(R.id.tv_result);
        btn_go = findViewById(R.id.btn_go);
        findViewById(R.id.btn_go).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this,secondActivity.class);
                String result = ((TextView)findViewById(R.id.tv_result)).getText().toString();
                intent.putExtra("result",result);
                startActivity(intent);
            }
        });
    }

    public void onNumberClick(View view) {
        switch (view.getId()){
            case R.id.one:
                setNumber("1");
                break;
            case R.id.two:
               setNumber("2");
                break;
            case R.id.three:
               setNumber("3");
                break;
            case R.id.four:
                setNumber("4");
                break;
            case R.id.five:
                setNumber("5");
                break;
            case R.id.six:
                setNumber("6");
                break;
            case R.id.seven:
                setNumber("7");
                break;
            case R.id.eight:
               setNumber("8");
                break;
            case R.id.nine:
               setNumber("9");
                break;
            case R.id.nul:
                if (tvResult.getText().toString().equals("0")){
                    tvResult.setText("0");
                }else{
                    tvResult.append("0");
                }
                break;
            case R.id.AC:
                tvResult.setText("0");
                firstVar=0;
                secondVar=0;
                break;
            case R.id.dot:
                setNumber(".");

        }
        btn_go.setVisibility(View.INVISIBLE);
        isOperatin = false;
    }
    private void setNumber(String number){
        btn_go.setVisibility(View.INVISIBLE);
        if (tvResult.getText().toString().equals("0")){
            tvResult.setText(number);
        }else if (isOperatin){
        tvResult.setText(number);
        }else{
            tvResult.append(number);
        }
        isOperatin = false;
    }

    public void onOperationClick(View view) {
       btn_go.setVisibility(View.INVISIBLE);
        switch (view.getId()){
            case R.id.plus:
                 firstVar= Double.parseDouble(tvResult.getText().toString());
                 isOperatin = true;
                 operation = "+";
                break;
            case R.id.minus:
                firstVar = Double.parseDouble(tvResult.getText().toString());
                isOperatin = true;
                operation = "-";
                break;
            case R.id.delit:
                firstVar = Double.parseDouble(tvResult.getText().toString());
                isOperatin=true;
                operation = "/";
                break;
            case R.id.x:
                firstVar = Double.parseDouble(tvResult.getText().toString());
                isOperatin = true;
                operation = "*";
                break;
            case R.id.equal:
                btn_go.setVisibility(view.getVisibility());
                secondVar= Double.parseDouble(tvResult.getText().toString());
                Double result = Double.valueOf(0);
                switch (operation){
                    case "+":
                        result = firstVar + secondVar ;
                        break;
                    case "-":
                        result = firstVar - secondVar;
                        break;
                    case "*":
                        result = firstVar * secondVar;
                        break;
                    case "/":
                        result = firstVar / secondVar;
                        break;
                    case ".":
                }
                tvResult.setText(new DecimalFormat("##.#####").format(result));
                btn_go.setVisibility(view.getVisibility());
                isOperatin = true;
                break;
        }
    }
}