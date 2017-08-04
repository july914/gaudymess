package com.example.yuliya.lightsignal;

import android.content.Intent;
import android.support.constraint.ConstraintLayout;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;
import android.view.View.OnClickListener;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements OnClickListener{


    private ConstraintLayout mConstraintLayout;
    private TextView mInfoTextView;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final Button redButton  = (Button)findViewById(R.id.buttonRed);
        final Button yellowButton = (Button)findViewById(R.id.buttonYellow);
        final Button greenButton = (Button)findViewById(R.id.buttonGreen);
        ImageButton BakaButton = (ImageButton)findViewById(R.id.buttonBaka);
        BakaButton.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {
                if (motionEvent.getAction() == MotionEvent.ACTION_DOWN)
                {
                    Toast.makeText(getApplicationContext(), "Don't touch! Baka!", Toast.LENGTH_SHORT).show();
                }
                return false;
            }
        });
        mConstraintLayout = (ConstraintLayout) findViewById(R.id.layoutBackground);
        redButton.setEnabled(false);
        yellowButton.setOnClickListener(this);
        greenButton.setOnClickListener(this);
        mInfoTextView = (TextView) findViewById(R.id.textViewInfo);
    }


    @Override
    public void onClick(View v) {
       switch (v.getId()){
           case R.id.buttonRed:
               mInfoTextView.setText(R.string.red);
               mConstraintLayout.setBackgroundColor(ContextCompat.getColor(this, R.color.redColor));
               break;
           case R.id.buttonYellow:
               mInfoTextView.setText(R.string.yellow);
               mConstraintLayout.setBackgroundColor(ContextCompat.getColor(this, R.color.yellowColor));
               break;
           case R.id.buttonGreen:
               mInfoTextView.setText(R.string.green);
               mConstraintLayout.setBackgroundColor(ContextCompat.getColor(this, R.color.greenColor));
               break;

       }
        //mInfoTextView.setText(R.string.yellow);
        //mConstraintLayout.setBackgroundColor(ContextCompat.getColor(this, R.color.yellowColor));

    }


    public void onAboutButtonClick(View view) {

        Intent intent = new Intent(MainActivity.this, AboutActivity.class);
        startActivity(intent);
    }

    public void onNextButtonClick(View view) {
        EditText receiverEditText = (EditText) findViewById(R.id.editTextReceiver);
        EditText descriptionEditText = (EditText) findViewById(R.id.editTextDescription);


        Intent intent = new Intent(MainActivity.this, BirthdayActivity.class);

        intent.putExtra("Receiver", receiverEditText.getText().toString());
        intent.putExtra("Description", descriptionEditText.getText().toString());
        startActivity(intent);
    }

    static final private int CHOOSE_THIEF=0;
    public void onChooseButtonClick(View view) {
        Intent questionIntent = new Intent(MainActivity.this, SherlockActivity.class);
        startActivityForResult(questionIntent, CHOOSE_THIEF);
    }
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data){
        super.onActivityResult(requestCode, resultCode, data);

        TextView ThiefTextView = (TextView) findViewById(R.id.textViewThief);

        if (requestCode == CHOOSE_THIEF){
            if (resultCode == RESULT_OK){
                String thiefname = data.getStringExtra(SherlockActivity.THIEF);
                ThiefTextView.setText(thiefname);
            }else {
                ThiefTextView.setText("");
            }
        }
    }
}
