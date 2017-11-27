package com.example.shylajhaa.storybuilder;

import android.content.Context;
import android.util.Log;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;


/**
 * Created by Shylajhaa on 14-11-2017.
 */

public class CheckRelevance {

    public static ArrayList<String> oldWords = new ArrayList<String>();
    public static ArrayList<String> newWords = new ArrayList<String>();
    public static ArrayList<String> title = new ArrayList<String>();
    public static Context context;

    public CheckRelevance()
    {

    }

    public CheckRelevance(Context current)
    {
        this.context = current;
    }

    public boolean relevant(String text,String starter)
    {
        String[] arr = starter.split(" ");
        int len = arr.length;
        for(int i=0;i<len;i++)
        {
            String x = arr[i].toLowerCase();
            if(!contains(x))
            {
                oldWords.add(arr[i]);
            }
        }

        String[] newArr = text.split(" ");
        int length = newArr.length;
        for(int i=0;i<length;i++)
        {
            String x = newArr[i];
            if(!contains(x))
            {
                newWords.add(newArr[i]);
            }
        }

        /*for(int i=0;i<oldWords.size();i++)
            Log.d("OUTPUT",oldWords.get(i));
        for(int i=0;i<newWords.size();i++)
            Log.d("OUTPUT",newWords.get(i));*/

        if(newWordAlreadyPresent())
        {
            return true;
        }
        else
        {
            return false;
        }
    }

    public static boolean contains(String str)
    {
        InputStream input = context.getResources().openRawResource(R.raw.stopwords);
        int flag = 0;
        try
        {
            Scanner sc = new Scanner(input);
            String sCurrentLine = sc.nextLine();
            while (sCurrentLine!= null)
            {
                if(sCurrentLine.equals(str))
                {
                    flag = 1;
                    break;
                }
                else
                {
                    sCurrentLine = sc.nextLine();
                }
            }
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
        if(flag==0)
            return false;
        else
            return true;
    }

    public static boolean newWordAlreadyPresent()
    {
        int size = newWords.size();
        int flag  = 0;
        for(int i=0;i<size;i++)
        {
            String x = newWords.get(i);
            if(oldWords.contains(x))
            {
                flag = 1;
                break;
            }
        }
        if(flag==1)
            return true;
        else
            return false;
    }

    public ArrayList getTitleSuggestions()
    {
        HashMap<String,Integer> frequencyOfWords = new HashMap<>();
        int countOfWords = 0;
        int size = oldWords.size();
        for(int i=0;i<size;i++)
        {
            String x = oldWords.get(i);
            if(frequencyOfWords.containsKey(x))
            {
                frequencyOfWords.put(x,frequencyOfWords.get(x)+1);
            }
            else
            {
                frequencyOfWords.put(x,1);
                countOfWords++;
            }
        }

        String[] words = new String[countOfWords];
        int[] wordFrequency = new int[countOfWords];

        int j = 0;
        for (Map.Entry m:frequencyOfWords.entrySet())
        {
            words[j] = (String)(m.getKey());
            wordFrequency[j] = (int)(m.getValue());
            j++;
        }

        int[] index = new int[countOfWords];
        for(int i=0;i<countOfWords;i++)
        {
            index[i] = i;
        }

        for (int i=0;i<countOfWords-1;i++)
        {
            for (int k=i+1;k<countOfWords;k++)
            {
                if(wordFrequency[i]<wordFrequency[k])
                {
                    int temp = index[i];
                    index[i] = index[k];
                    index[k] = temp;
                }
            }
        }

        for (int i=0;i<countOfWords;i++)
        {
            title.add(words[index[i]]);
            //Log.d("OUTPUT",words[index[i]]);
        }
        return title;
    }
}
