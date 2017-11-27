package com.example.shylajhaa.storybuilder;

import android.util.Log;

import java.util.ArrayList;
import java.util.Random;

/**
 * Created by Shylajhaa on 13-11-2017.
 */

public class BuildStory {


    public static ArrayList<String> drama = new ArrayList<String>();
    public static ArrayList<String> romance = new ArrayList<String>();
    public static ArrayList<String> fantasy = new ArrayList<String>();
    public static ArrayList<String> horror = new ArrayList<String>();
    public static ArrayList<String> biography = new ArrayList<String>();

    public String getStarter(String genre)
    {
        Random random = new Random();
        String resultStarter = "";
        int range = random.nextInt(5);
        //Log.d("Output",Integer.toString(range));
        if(genre.equals("drama"))
        {
            resultStarter = drama.get(range);
        }
        if(genre.equals("romance"))
        {
            resultStarter = romance.get(range);
        }
        if(genre.equals("horror"))
        {
            resultStarter = horror.get(range);
        }
        if(genre.equals("fantasy"))
        {
            resultStarter = fantasy.get(range);
        }
        if(genre.equals("biography"))
        {
            resultStarter = biography.get(range);
        }
        //Log.d("OUTPUT",resultStarter);
        return resultStarter;
    }

    public void addStarters(String genre,ArrayList al)
    {
        if(genre.equals("drama"))
        {
            drama.addAll(al);
        }
        if(genre.equals("romance"))
        {
            romance.addAll(al);
        }
        if(genre.equals("horror"))
        {
            horror.addAll(al);
        }
        if(genre.equals("fantasy"))
        {
            fantasy.addAll(al);
        }
        if(genre.equals("biography"))
        {
            biography.addAll(al);
        }
    }
}
