package com.example.yuliya.lightsignal;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.TextView;

public class BirthdayActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_birthday);

        String receiver = "ЖЫвотное";
        String description = "дырку от бублика";

        //receiver = getIntent().getExtras().getString("Receiver");
        //description = getIntent().getExtras().getString("Description");
        receiver = getIntent().getStringExtra("Receiver");
        description = getIntent().getStringExtra("Description");

        TextView infoTextView = (TextView)findViewById(R.id.textView);
        infoTextView.setText(receiver + " , you get " + description);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
    }

}
