package com.example.shylajhaa.storybuilder;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class WriteActivity extends AppCompatActivity {

    Button nextLine;
    Button endStory;
    EditText newLine;
    TextView oldLine;
    String text = "";
    String starter = "";
    public String startLine = "";
    public Context context;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_write);

        context = WriteActivity.this;

        Bundle bundle = getIntent().getExtras();
        startLine = bundle.getString("StarterLine");
        starter = startLine;

        oldLine = (TextView) findViewById(R.id.oldLine);
        oldLine.setText(startLine);

        newLine = (EditText) findViewById(R.id.newLine);

        nextLine = (Button) findViewById(R.id.next);
        nextLine.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                text = newLine.getText().toString();
                if (checkRelevance(text, starter)) {
                    startLine = startLine + " " + text;
                    newLine.setText("");
                    //Layout textView = oldLine.getLayout();
                    //int height = textView.getHeight();
                    //int height = oldLine.getHeight() + 50;

                    //Log.d("OUTPUT", String.valueOf(height));
                    oldLine.setText(startLine);
                } else {
                    newLine.setText("");
                    newLine.setError("Write a relevant story");
                }
            }
        });

        endStory = (Button)findViewById(R.id.end_story);
        endStory.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                text = newLine.getText().toString();
                if (checkRelevance(text, starter)) {
                    startLine = startLine + " " + text;
                    newLine.setText("");
                    //Layout textView = oldLine.getLayout();
                    //int height = textView.getHeight();
                    //int height = oldLine.getHeight() + 50;

                    //Log.d("OUTPUT", String.valueOf(height));
                    oldLine.setText(startLine);

                    Intent intent = new Intent(WriteActivity.this,TitleActivity.class);
                    intent.putExtra("Story",startLine);
                    Toast.makeText(getApplicationContext(),"Title",Toast.LENGTH_LONG).show();
                    startActivity(intent);
            }
                else {
                    newLine.setText("");
                    newLine.setError("Write a relevant story");
                }
            }
        });
    }

        public boolean checkRelevance(String text, String starter)
        {
            CheckRelevance check = new CheckRelevance(this);
            Boolean result = check.relevant(text,starter);
            return result;
        }
}
