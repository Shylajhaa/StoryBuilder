package com.example.shylajhaa.storybuilder;


import android.content.Context;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.InputStream;

/**
 * Created by Shylajhaa on 19-11-2017.
 */

public class Database
{

    public Context context;
    public String file = "database.txt";

    public static String title = "Shylu";
    public static String storyText = "She is a good girl";

    public Database(Context context)
    {
        this.context = context;
    }

    public void saveData()
    {
        try
        {
           FileOutputStream fos = context.openFileOutput(file,context.MODE_PRIVATE);
           fos.write(title.getBytes());
           fos.write(storyText.getBytes());
           fos.close();
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }
}
