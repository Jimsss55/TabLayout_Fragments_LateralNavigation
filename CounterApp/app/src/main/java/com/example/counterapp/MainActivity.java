package com.example.counterapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private EditText num;
    private Button add;
    private Button reset;
    int count=0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        num=(EditText)findViewById(R.id.numid);
        add=(Button) findViewById(R.id.clickid);
        reset=(Button) findViewById(R.id.resetid);
        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                count++;
                display(count);
                Toast.makeText(MainActivity.this, "Button Clicked", Toast.LENGTH_SHORT).show();
            }
        });
        reset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                count=0;
                display(count);
                Toast.makeText(MainActivity.this, "Button Reset", Toast.LENGTH_SHORT).show();
            }
        });
    }
    private void display(int count){
        num.setText(String.valueOf(count));
    }
}



