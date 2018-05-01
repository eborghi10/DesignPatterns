package com.emiliano.compositepattern;

public class Song extends SongComponent {

    private String songName;
    private String bandName;
    private int releaseYear;

    Song(String songName, String bandName, int releaseYear) {
        this.songName = songName;
        this.bandName = bandName;
        this.releaseYear = releaseYear;
    }

    public String getSongName() {
        return songName;
    }

    public String getBandName() {
        return bandName;
    }

    public int getReleaseYear() {
        return releaseYear;
    }

    @Override
    public void displaySongInfo() {
        System.out.println(songName + " was recorded by " + bandName + " in " + releaseYear);
    }
}
