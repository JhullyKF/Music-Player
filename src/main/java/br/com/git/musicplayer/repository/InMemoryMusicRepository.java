package br.com.git.musicplayer.repository;

import br.com.git.musicplayer.model.entities.Music;

import java.util.ArrayList;

public class InMemoryMusicRepository implements MusicRepository {
    private static final ArrayList<Music> musics = new ArrayList<Music>();

    public ArrayList<Music> getAllMusics(){
        return musics;
    }

    public Music getMusicById(int id){
        for(Music music: musics){
            if(id == music.getId()){
                return music;
            }
        }
        return null;
    }

    public Music getMusicByTitle(String title){
        for(Music music: musics){
            if (music.getTitle().equalsIgnoreCase(title)) {
                return music;
            }
        }
        return null;
    }

    public void addMusic(Music music){
        musics.add(music);
    }

    public void removeMusicById(int id){
        for(Music music: musics){
            if (music.getId() == id){
                musics.remove(music);
                break;
            }
        }
    }

    public void removeMusicByTitle(String title){
        for(Music music: musics){
            if(music.getTitle().equalsIgnoreCase(title)){
                musics.remove(music);
                break;
            }
        }
    }

    public void updateMusic(int id, Music musicUpdate){
        for(int i = 0; i < musics.size(); i++){
            if(musics.get(i).getId() == id){
                musics.set(i, musicUpdate);
                break;
            }
        }
    }





}
