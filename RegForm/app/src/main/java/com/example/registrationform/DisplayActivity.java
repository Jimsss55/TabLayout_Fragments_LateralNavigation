package com.example.registrationform;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.TextView;

public class DisplayActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display);

        Intent intent=getIntent();
        String studentid=intent.getStringExtra("Studentid");
        String name=intent.getStringExtra("Name");
        String programme=intent.getStringExtra("prog");
        String academic=intent.getStringExtra("aca");
        String year=intent.getStringExtra("year");
        String sem=intent.getStringExtra("sem");
        String mod=intent.getStringExtra("mod");

        TextView std=findViewById(R.id.getstdid);
        std.setText("StudentID: "+studentid);

        TextView displayname=findViewById(R.id.getnameid);
        displayname.setText("Name: "+name);

        TextView displayprogramme=findViewById(R.id.getprogid);
        displayprogramme.setText("Programme: "+programme);

        TextView displayacademic=findViewById(R.id.getacaid);
        displayacademic.setText("Academic Year: "+academic);

        TextView displayyear=findViewById(R.id.getyearid);
        displayyear.setText("Year: "+year);

        TextView displaysem=findViewById(R.id.getsemid);
        displaysem.setText("Semester: "+sem);

        TextView displaymod=findViewById(R.id.getmodid);
        displaymod.setText(mod);
    }
}