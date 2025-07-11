package br.com.git.musicplayer.controller;

import br.com.git.musicplayer.model.entities.Music;
import br.com.git.musicplayer.repository.InMemoryMusicRepository;


public class MusicController {
    private final InMemoryMusicRepository musicRepository;
    private final PlaybackController playbackController;

    public MusicController(){
        this.musicRepository = new InMemoryMusicRepository();
        this.playbackController = new PlaybackController();
    }

    public void showAllMusics() {
        if(musicRepository.getAllMusics() == null || musicRepository.getAllMusics().isEmpty()) {
            System.out.println("    ▫ Nenhuma música encontrada.");
        }
        for(Music music : musicRepository.getAllMusics()) {
            System.out.println("    ▫ " + music.toString());
        }
    }
    public Music getMusicById(int id){
        return musicRepository.getMusicById(id);
    }

    public Music getMusicByTitle(String title){
        return musicRepository.getMusicByTitle(title.toLowerCase());
    }

    public void playMusic(Object identifier){
        Music music;
        if(identifier instanceof Integer){
            music = getMusicById((int) identifier);
        } else if (identifier instanceof String){
            music = getMusicByTitle((String) identifier);
        } else {
            return;
        }
        if (music == null) {
            System.out.println("    ▫ Música não encontrada.");
            return;
        }
        playbackController.play(music);
    }

    public void addMusic(String path, String title, String artist, String album) {
        if (musicRepository.addMusic(new Music(path, title, artist, album))){
            System.out.println("    ▫ Música adicionada com sucesso");
        }
    }

    public void removeMusic(Object identifier) {
        if (identifier instanceof Integer) {
            musicRepository.removeMusicById((int) identifier);
        } else if (identifier instanceof String) {
            musicRepository.removeMusicByTitle((String) identifier);
        } else {
            System.out.println("    ▫ Identificador inválido. Use ID ou título.");
        }
    }

    public void pauseMusic(){
        playbackController.stop();
    }

    public void updateMusic(int id, int option, String content){
        Music music = getMusicById(id);
        if (music == null) {
            System.out.println("    ▫ Música não encontrada.");
            return;
        }

        switch (option){
            case 1 -> music.setTitle(content);
            case 2 -> music.setArtist(content);
            case 3 -> music.setAlbum(content);
            case 4 -> music.setPath(content);
            default -> {
                System.out.println("    ▫ Opção inválida. Tente novamente.");
                return;
            }
        }
        if (musicRepository.updateMusic(id, music)){;
            System.out.println("    ▫ Música atualizada com sucesso.");
        }
    }
}
