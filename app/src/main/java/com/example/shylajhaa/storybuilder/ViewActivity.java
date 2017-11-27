package com.example.shylajhaa.storybuilder;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;
import java.io.InputStream;
import java.util.Scanner;

public class ViewActivity extends AppCompatActivity {

    TextView showData;
    public static String text = "";
    public static Context context;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view);

        context = ViewActivity.this;

        showData = findViewById(R.id.dbdata);
        //Log.d("HELLO","Shylajhaa");
        //showData.setText(text);
        //showData.setText(text);
        String storyText = getData();
        Log.d("HELLO",storyText);
        showData.setText(storyText);

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
       showData.setText("");
    }

    public static String getData()
    {
        InputStream input = context.getResources().openRawResource(R.raw.database);
        //Log.d("HELLO","Shylajhaa");
        Scanner sc = new Scanner(input);
        String sCurrentLine = sc.nextLine();
        try
        {
            while (sCurrentLine != null)
            {
                text = text + sCurrentLine;
                //Log.d("HELLO",text);
                if(sc.hasNext())
                    sCurrentLine = sc.nextLine();
                else
                    break;
            }
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
        return text;
    }
}
