package com.example.registrationform;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.widget.RadioButton;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.Spinner;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener {
    private Button submit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Spinner spinner=findViewById(R.id.progid1);
        ArrayAdapter<CharSequence> adapter=ArrayAdapter.createFromResource(this,R.array.programmes, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_item);
        spinner.setAdapter(adapter);
        spinner.setOnItemSelectedListener(this);

        submit=findViewById(R.id.buttonid);

        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String studentid=((EditText) findViewById(R.id.stdid1)).getText().toString();
                String name=((EditText) findViewById(R.id.nameid1)).getText().toString();
                String programme=((Spinner) findViewById(R.id.progid1)).getSelectedItem().toString();
                String academic=((EditText) findViewById(R.id.acaid1)).getText().toString();
                String year=((EditText) findViewById(R.id.yearid1)).getText().toString();

                RadioGroup sem = findViewById(R.id.semid1);
                String radio="";

                int selectedRadioButtonId = sem.getCheckedRadioButtonId();
                if(selectedRadioButtonId != -1){
                    RadioButton selectedRadioButton = findViewById(selectedRadioButtonId);
                    radio =  selectedRadioButton.getText().toString();
                }

                String module=((EditText) findViewById(R.id.modid1)).getText().toString();

                Intent intent=new Intent(MainActivity.this,DisplayActivity.class);

                intent.putExtra("Studentid",studentid);
                intent.putExtra("Name",name);
                intent.putExtra("prog",programme);
                intent.putExtra("aca",academic);
                intent.putExtra("year",year);
                intent.putExtra("sem",radio);
                intent.putExtra("mod",module);

                startActivity(intent);
            }
        });
    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long l) {
        String text=parent.getItemAtPosition(position).toString();
    }

    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {

    }
}