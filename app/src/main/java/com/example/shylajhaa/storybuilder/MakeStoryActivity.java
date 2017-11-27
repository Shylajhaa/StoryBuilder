package com.example.shylajhaa.storybuilder;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;

public class MakeStoryActivity extends AppCompatActivity {

    TextView start;
    public static ArrayList<String> startData = new ArrayList<String>();
    public static String starter = "";
    public static String genre = "";
    Button write;
    public Context context;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_makestory);

        context = MakeStoryActivity.this;

        Bundle bundle = getIntent().getExtras();
        genre = bundle.getString("Genre");
        startData = bundle.getStringArrayList("List");

        start =(TextView)findViewById(R.id.start);
        write = (Button)findViewById(R.id.write);

        write.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MakeStoryActivity.this,WriteActivity.class);
                intent.putExtra("StarterLine",starter);
                startActivity(intent);
            }
        });

        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                BuildStory buildStory = new BuildStory();
                //String genre = "drama";
                buildStory.addStarters(genre,startData);
                starter = buildStory.getStarter(genre);
                //Log.d("OUTPUT",starter);
                start.setText(starter);
            }
        });
        thread.start();
    }
}
