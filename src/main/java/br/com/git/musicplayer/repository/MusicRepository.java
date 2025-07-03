package br.com.git.musicplayer.repository;

import br.com.git.musicplayer.model.entities.Music;

import java.util.ArrayList;

public interface MusicRepository {
    ArrayList<Music> getAllMusics();
    Music getMusicById(int id);
    Music getMusicByTitle(String title);
    void addMusic(Music music);
    void removeMusicById(int id);
    void removeMusicByTitle(String title);
    void updateMusic(int id, Music music);
}
