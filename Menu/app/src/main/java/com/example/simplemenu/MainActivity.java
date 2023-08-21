package com.example.simplemenu;

import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;

public class MainActivity extends AppCompatActivity {

    ListView listview;
    ImageView imageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listview = findViewById(R.id.listviewid);
        String[] list = {"Message", "Map", "Image"};
//        imageView=findViewById(R.id.imageView);

        ArrayAdapter adapter = new ArrayAdapter<String>(
                this,
                android.R.layout.simple_list_item_1,
                list
        );

        listview.setAdapter(adapter);

        listview.setOnItemClickListener((parent, view, position, id) -> {
            String selecteditem = list[position];

            if (selecteditem.equals("Message")) {
                Intent intent = new Intent(Intent.ACTION_VIEW);
                intent.setData(Uri.parse("sms:"));
                startActivity(intent);
            } else if (selecteditem.equals("Map")) {
                Intent intent = new Intent(MainActivity.this, MapActivity.class);
                startActivity(intent);
//                Intent intent=new Intent(Intent.ACTION_VIEW);
//                intent.setData(Uri.parse("https://www.google.com/maps"));
            } else if (selecteditem.equals("Image")) {
                openContextMenu(view);
            }
        });
        registerForContextMenu(listview);
    }
    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo){
        super.onCreateContextMenu(menu,v,menuInfo);
        getMenuInflater().inflate(R.menu.context_menu,menu);
    }


//    @Override
//    public boolean onContextItemSelected(MenuItem item){
//        AdapterView.AdapterContextMenuInfo info =(AdapterView.AdapterContextMenuInfo) item.getItemId();
//        int position =info.position;
//
//        switch(item.getItemId()){
//            case R.id.:
//                return true;
//
//            case R.id.option_2:
//                return true;
//            default:
//                return super.onContextItemSelected(item);
//        }
//    }

}