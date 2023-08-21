package com.example.simplemenu;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MapActivity extends AppCompatActivity {
    EditText address;
    Button search;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_map);

        address= findViewById(R.id.nameid);
        search =findViewById(R.id.searchid);

        search.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String location = address.getText().toString();
                if (!location.isEmpty()) {
                    Uri gmmIntentUri = Uri.parse("geo:0,0?q=" + location);
                    Intent mapIntent = new Intent(Intent.ACTION_VIEW, gmmIntentUri);
                    mapIntent.setPackage("com.google.android.apps.maps");

                    if (mapIntent.resolveActivity(getPackageManager()) != null) {
                        startActivity(mapIntent);
                    } else {
                        Uri webIntentUri = Uri.parse("https://www.google.com/maps/search/?api=1&query=" + location);
                        Intent webIntent = new Intent(Intent.ACTION_VIEW, webIntentUri);
                        startActivity(webIntent);
                    }
                }
            }
        });
    }

}
