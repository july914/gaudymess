package com.example.yuliya.lightsignal;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class SherlockActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sherlock);
    }

    public final static String THIEF = "com.example.yuliya.lightsignal";

    public void onRadioClick(View v){
        Intent answerIntent = new Intent();

        switch (v.getId()){
            case R.id.radioDog:
                answerIntent.putExtra(THIEF, "Shit Dog");
                break;
            case R.id.radioCrow:
                answerIntent.putExtra(THIEF, "Crow");
                break;
            case R.id.radioCat:
                answerIntent.putExtra(THIEF, "Neighborhood horse");
                break;
            default:
                break;
        }
        setResult(RESULT_OK, answerIntent);
        finish();
    }
}
