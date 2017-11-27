package com.example.shylajhaa.storybuilder;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class IntroActivity extends AppCompatActivity {

    public Button start;
    public Button tips;
    public Button about;
    public Button view;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_intro);

        start = (Button)findViewById(R.id.starttowrite);
        start.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent1 = new Intent(IntroActivity.this,MainActivity.class);
                startActivity(intent1);
            }
        });

        tips = (Button)findViewById(R.id.tips);
        tips.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent2 = new Intent(IntroActivity.this,TipsActivity.class);
                startActivity(intent2);
            }
        });

        about = (Button)findViewById(R.id.about);
        about.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent3 = new Intent(IntroActivity.this,AboutActivity.class);
                startActivity(intent3);
            }
        });

        view = (Button)findViewById(R.id.view);
        view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent1 = new Intent(IntroActivity.this,ViewActivity.class);
                startActivity(intent1);
            }
        });
    }
}
