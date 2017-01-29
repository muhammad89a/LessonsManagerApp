package com.example.mohammed.lessonsmanagerapp.Model;

/**
 * Created by mohammed on 23/01/2017.
 */

public class Song{
    private long id;
    private String title;
    private String artist;

    public Song(long songID, String songTitle, String songArtist) {
        id=songID;
        title=songTitle;
        artist=songArtist;
    }
    public long getID(){return id;}
    public String getTitle(){return title;}
    public String getArtist(){return artist;}


}
