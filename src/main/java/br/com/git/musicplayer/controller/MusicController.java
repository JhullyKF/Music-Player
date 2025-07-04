package br.com.git.musicplayer.controller;

import br.com.git.musicplayer.model.entities.Music;
import br.com.git.musicplayer.repository.InMemoryMusicRepository;
import javazoom.jl.player.Player;

import java.io.FileInputStream;
import java.io.InputStream;
import java.util.ArrayList;

public class MusicController {
    private final InMemoryMusicRepository musicRepository;

    public MusicController(){
        this.musicRepository = new InMemoryMusicRepository();
    }

    public void showAllMusics() {
        if(musicRepository.getAllMusics() == null || musicRepository.getAllMusics().isEmpty()) {
            System.out.println("    ▫ Nenhuma música encontrada.");
        }
        for(Music music : musicRepository.getAllMusics()) {
            System.out.println("    ▫ " + music.toString());
        }
    }

    public void findMusicById(int id){
        Music music = musicRepository.getMusicById(id);
        try(InputStream input = new FileInputStream(music.getPath())){
            System.out.println("    ▫ Música encontrada: ");
            Player player = new Player(input);
            player.play();
        } catch (Exception e) {
            System.out.println("    ▫ Erro ao carregar o arquivo de música: " + e.getMessage());
        }
    }

    public void findMusicByTitle(String title){
        Music music = musicRepository.getMusicByTitle(title.toLowerCase());
        try(InputStream input = new FileInputStream(music.getPath())){
            System.out.println("    ▫ Música encontrada: ");
            Player player = new Player(input);
            player.play();
        } catch (Exception e) {
            System.out.println("Erro ao carregar o arquivo de música: " + e.getMessage());
        }
    }

    public void addMusic(String path, String title, int duration, String artist, String album) {
        int id = 1;
        if (!(musicRepository.getAllMusics().isEmpty() || musicRepository.getAllMusics() == null)){
            id = musicRepository.getAllMusics().size() + 1;
        }
        try {
            Music newMusic = new Music(id, path, title.toLowerCase(), duration, artist, album);
            musicRepository.addMusic(newMusic);
            System.out.println("    ▫ Música adicionada com sucesso: " + newMusic);
        } catch (RuntimeException e) {
            throw new RuntimeException(e);
        }
    }

    public void removeMusicById(int id) {
        try {
            musicRepository.removeMusicById(id);
            System.out.println("    ▫ Música removida com sucesso.");
        } catch (Exception e) {
            System.out.println("    ▫ Erro ao remover música: " + e.getMessage());
        }
    }

    public void removeMusicByTitle(String title) {
        try {
            musicRepository.removeMusicByTitle(title.toLowerCase());
            System.out.println("    ▫ Música removida com sucesso.");
        } catch (Exception e) {
            System.out.println("    ▫ Erro ao remover música: " + e.getMessage());
        }
    }

}
