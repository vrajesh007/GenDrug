package com.newproject.gendrug;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class youraccount extends AppCompatActivity {
    Button byourorders;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_youraccount);

        byourorders=(Button)findViewById(R.id.byourorders);

        byourorders.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(youraccount.this,orderdetails.class);
                startActivity(intent);
            }
        });
    }
}
