package com.example.shylajhaa.storybuilder;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    Button drama;
    Button romance;
    Button fantasy;
    Button horror;
    Button biography;

    public static ArrayList<String> dramaList = new ArrayList<String>();
    public static ArrayList<String> romanceList = new ArrayList<String>();
    public static ArrayList<String> fantasyList = new ArrayList<String>();
    public static ArrayList<String> horrorList = new ArrayList<String>();
    public static ArrayList<String> biographyList = new ArrayList<String>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        drama = (Button)findViewById(R.id.drama);
        drama.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                dramaList.add("I just joined at the college. New place and new people.");
                dramaList.add("\"Oh, come on!\" I yelled as I threw my papers across the office.");
                dramaList.add("She looked out of the hotel room window walking down a 10 year old memory lane.");
                dramaList.add("New York. The city of new beginnings.");
                dramaList.add("I was nine years old when my older sister died.");

                Intent intent1 = new Intent(MainActivity.this,MakeStoryActivity.class);
                intent1.putExtra("Genre","drama");
                intent1.putExtra("List",dramaList);
                startActivity(intent1);
                //Toast.makeText(getApplicationContext(),"Drama",Toast.LENGTH_LONG).show();
            }
        });

        romance = (Button)findViewById(R.id.romance);
        romance.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                romanceList.add("It was in-fact a deep relationship. A very deep and centuries old one.");
                romanceList.add("The thought began to tragically take form in her mind...");
                romanceList.add("It has been one month since I moved to Paris.");
                romanceList.add("I don't know how it happened but I care about a girl.");
                romanceList.add("We fly. Its that fraction of a moment where everything comes to a halt.");

                Intent intent2 = new Intent(MainActivity.this,MakeStoryActivity.class);
                intent2.putExtra("Genre","romance");
                intent2.putExtra("List",romanceList);
                startActivity(intent2);
                //Toast.makeText(getApplicationContext(),"Romance",Toast.LENGTH_LONG).show();
            }
        });

        fantasy = (Button)findViewById(R.id.fantasy);
        fantasy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                fantasyList.add("Walking down a modern busy street, Princess Pamela was aware of several admiring male glances.");
                fantasyList.add("I had always dreamed running my own cafe.");
                fantasyList.add("Marble columns were placed expertly to keep the cave ceiling from dropping onto the dwarves.");
                fantasyList.add("There was a magnificent snow-clad wall guarding the seven kingdoms from the dead");
                fantasyList.add("The silent underground station held all the charm and colour of a mortuary slab.");

                Intent intent3 = new Intent(MainActivity.this,MakeStoryActivity.class);
                intent3.putExtra("Genre","fantasy");
                intent3.putExtra("List",fantasyList);
                startActivity(intent3);
                //Toast.makeText(getApplicationContext(),"Fantasy",Toast.LENGTH_LONG).show();
            }
        });

        horror = (Button)findViewById(R.id.horror);
        horror.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                horrorList.add("It was a dark and stormy night in modern Barriville, perhaps gloomier than usual.");
                horrorList.add("The pale full moon shone brightly upon the lonely street");
                horrorList.add("Darkness is all I see");
                horrorList.add("I awoke on my side, staring at my alarm clock.");
                horrorList.add("His heart pounds against his rib cage like a wild animal stricken with fear.");

                Intent intent4 = new Intent(MainActivity.this,MakeStoryActivity.class);
                intent4.putExtra("Genre","horror");
                intent4.putExtra("List",horrorList);
                startActivity(intent4);
                //Toast.makeText(getApplicationContext(),"Horror",Toast.LENGTH_LONG).show();
            }
        });

        biography = (Button)findViewById(R.id.biography);
        biography.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                biographyList.add("Abdul Kalam was born on 15 October 1931 in the pilgrimage centre of Rameswaram on Pamban Island");
                biographyList.add("Mahatma Gandhi was a prominent Indian political leader who campaigned for Indian independence.");
                biographyList.add("Abraham Lincoln was born February 12, 1809, the second child of Thomas and Nancy Hanks Lincoln,in Kentucky");
                biographyList.add("Mother Teresa was a Roman Catholic nun who devoted her life to serving the poor and destitute around the world.");
                biographyList.add("Nelson Mandela a South African political activist spent over 20 years in prison for his opposition to the apartheid regime");

                Intent intent5 = new Intent(MainActivity.this,MakeStoryActivity.class);
                intent5.putExtra("Genre","biography");
                intent5.putExtra("List",biographyList);
                startActivity(intent5);
                //Toast.makeText(getApplicationContext(),"Biography",Toast.LENGTH_LONG).show();
            }
        });

    }
}
