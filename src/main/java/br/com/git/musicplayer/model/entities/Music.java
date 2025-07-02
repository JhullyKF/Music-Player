package br.com.git.musicplayer.model.entities;

public class Music {
    private int id;
    private String title;
    private int duration;
    private String artist;
    private String album;

    public Music(int id, String title, int duration, String artist, String album) {
        this.id = id;
        this.title = title;
        this.duration = duration;
        this.artist = artist;
        this.album = album;
    }
    public Music() {
    }

    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getTitle() {
        return title;
    }
    public void setTitle(String title) {
        this.title = title;
    }
    public int getDuration() {
        return duration;
    }
    public void setDuration(int duration) {
        this.duration = duration;
    }
    public String getArtist() {
        return artist;
    }
    public void setArtist(String artist) {
        this.artist = artist;
    }
    public String getAlbum() {
        return album;
    }
    public void setAlbum(String album) {
        this.album = album;
    }
}
