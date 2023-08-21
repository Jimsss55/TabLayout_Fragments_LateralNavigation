package com.example.calculatorapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import com.google.android.material.button.MaterialButton;
import org.mozilla.javascript.Context;
import org.mozilla.javascript.Scriptable;


public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    TextView answer,solution;
    MaterialButton button_c,button_openb,button_closeb;
    MaterialButton button_divide,button_add,button_multiply,button_subtract,button_equal;
    MaterialButton button_4,button_5,button_6,button_3,button_2,button_1,button_0,button_7,button_8,button_9;
    MaterialButton button_ac, button_dot;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        answer=findViewById(R.id.answer);
        solution= findViewById(R.id.solution);

        assignId(button_c,R.id.button_c);
        assignId(button_openb,R.id.button_openb);
        assignId(button_closeb,R.id.button_closeb);
        assignId(button_divide,R.id.button_divide);
        assignId(button_add,R.id.button_add);
        assignId(button_multiply,R.id.button_multiply);
        assignId(button_subtract,R.id.button_subtract);
        assignId(button_equal,R.id.button_equal);
        assignId(button_0,R.id.button_0);
        assignId(button_1,R.id.button_1);
        assignId(button_2,R.id.button_2);
        assignId(button_3,R.id.button_3);
        assignId(button_4,R.id.button_4);
        assignId(button_5,R.id.button_5);
        assignId(button_6,R.id.button_6);
        assignId(button_7,R.id.button_7);
        assignId(button_8,R.id.button_8);
        assignId(button_9,R.id.button_9);
        assignId(button_dot,R.id.button_dot);
        assignId(button_ac,R.id.button_ac);

    }

    void assignId(MaterialButton btn,int id){
        btn=findViewById(id);
        btn.setOnClickListener(this);
    }
    @Override
    public void onClick(View view) {
        MaterialButton button=(MaterialButton) view;
        String buttonText=button.getText().toString();
        String calculate=solution.getText().toString();

        if (buttonText.equals("Ac")) {
            solution.setText("0");
            answer.setText("0");
        }
        else if (buttonText.equals("=")) {
            String result = getResult(calculate);
            answer.setText(result);
        }
        else if (buttonText.equals("C")) {
            if (calculate.length() > 0) {
                calculate = calculate.substring(0, calculate.length() - 1);
            }
        }
        else {
            calculate = calculate + buttonText;
        }

        solution.setText(calculate);
        String finalresult=getResult(calculate);

        if(!finalresult.equals("Error")){
            answer.setText(finalresult);
        }
    }
    String getResult(String data) {
        try{
            Context context=Context.enter();
            context.setOptimizationLevel(-1);
            Scriptable scriptable=context.initStandardObjects();
            String finalresult=context.evaluateString(scriptable,data,"Javascript",1,null).toString();
            if(finalresult.endsWith(".0")){
                finalresult=finalresult.replace("0","");
            }
            return finalresult;
        }
        catch (Exception e){
            return "Error";
        }
    }
}