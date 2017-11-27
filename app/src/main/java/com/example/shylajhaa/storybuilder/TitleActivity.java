package com.example.shylajhaa.storybuilder;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.util.ArrayList;

public class TitleActivity extends AppCompatActivity {

    EditText title;
    Button b1;
    Button b2;
    Button b3;
    Button save;
    String header = "";
    public static String story  = "";
    public static Context context;

    public static ArrayList<String> suggestions = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_title);

        context = TitleActivity.this;

        Bundle bundle = new Bundle();
        story = bundle.getString("Story");

        b1 = (Button)findViewById(R.id.suggestion1);
        b2 = (Button)findViewById(R.id.suggestion2);
        b3 = (Button)findViewById(R.id.suggestion3);
        save = (Button)findViewById(R.id.save);

        title = (EditText)findViewById(R.id.title);
        header = title.getText().toString();

        CheckRelevance checkRelevance = new CheckRelevance();
        suggestions = checkRelevance.getTitleSuggestions();
        b1.setText(suggestions.get(0));
        b2.setText(suggestions.get(1));
        b3.setText(suggestions.get(2));

        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                title.setText(suggestions.get(0));
                header = suggestions.get(0);
            }
        });

        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                title.setText(suggestions.get(1));
                header = suggestions.get(1);
            }
        });

        b3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                title.setText(suggestions.get(2));
                header = suggestions.get(2);
            }
        });

        save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Database db = new Database(context);
                db.saveData();

                Intent intent = new Intent(TitleActivity.this,IntroActivity.class);
                startActivity(intent);
            }
        });

    }

}
