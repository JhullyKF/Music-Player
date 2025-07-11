package br.com.git.musicplayer.model.entities;

public class Music {
    private int id;
    private String path;
    private String title;
    private String artist;
    private String album;

    public Music(int id, String path, String title, String artist, String album) {
        this.id = id;
        this.path = path;
        this.title = title;this.artist = artist;
        this.album = album;
    }
    public Music(String path, String title, String artist, String album) {
        this.path = path;
        this.title = title;
        this.artist = artist;
        this.album = album;
    }

    public int getId() {
        return id;
    }

    public String getPath() {
        return path;
    }
    public void setPath(String path) {
        this.path = path;
    }
    public String getTitle() {
        return title;
    }
    public void setTitle(String title) {
        this.title = title;
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

    public String toString() {
        return " Music " + id +
                ", path='" + path + '\'' +
                ", title='" + title + '\'' +
                ", artist='" + artist + '\'' +
                ", album='" + album + '\'' +
                '}';
    }
}
