package com.newproject.gendrug;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class categorylist extends AppCompatActivity {
    ListView listview;
    String category[]={"Tablets","Syrup","Injection","Capsules"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_categorylist);

        listview=findViewById(R.id.category);
        ArrayAdapter<String> arrayAdapter=new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,category);
        listview.setAdapter(arrayAdapter);
    }
}
