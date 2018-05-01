package com.emiliano.compositepattern;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class SongListGenerator extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        SongComponent industrialMusic = new SongGroup("Industrial", "This is the industrial music list");
        SongComponent heavyMetalMusic = new SongGroup("Heavy metal", "This is the heavy metal music list");
        SongComponent dubstepMusic = new SongGroup("Dubstep", "This is the dubstep music list");

        SongComponent everySong = new SongGroup("Song list", "Every song available");

        everySong.add(industrialMusic);
        everySong.add(heavyMetalMusic);

        industrialMusic.add(new Song("Head Like a Hole", "NIN", 1990));
        industrialMusic.add(new Song("Headhunter", "Front 242", 1988));

        industrialMusic.add(dubstepMusic);
        dubstepMusic.add(new Song("Centipede", "Knife Party", 2012));
        dubstepMusic.add(new Song("Tetris", "Doctor P", 2011));

        heavyMetalMusic.add(new Song("War Pigs", "Black Sabbath", 1970));
        heavyMetalMusic.add(new Song("Ace of Spades", "Motorhead", 1980));

        DiscJockey crazyLarry = new DiscJockey(everySong);
        crazyLarry.getSongList();
    }
}
