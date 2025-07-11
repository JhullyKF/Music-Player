package br.com.git.musicplayer.controller;

import br.com.git.musicplayer.model.entities.Music;
import javazoom.jl.player.Player;

import java.io.FileInputStream;
import java.io.InputStream;

public class PlaybackController {
    private Player player;
    private Thread playerThread;

    public void play(Music music){
        stop();
        try{
            InputStream input = new FileInputStream(music.getPath());
            player = new Player(input);
            playerThread = new Thread(() -> {
                try{
                    System.out.println("\n    ▶ Tocando agora: " + music.getTitle());
                    player.play();
                } catch (Exception e) {
                    if (!e.getMessage().equals("closed")){
                        System.out.println("    ▫ Erro durante a reprodução: " + e.getMessage());
                    }
                }
            });
            playerThread.start();
        } catch (Exception e){
            System.out.println("    ▫ Erro ao carregar o arquivo de música: ");
        }
    }

    public void stop(){
        if (player != null){
            player.close();
            player = null;
            playerThread = null;
            System.out.println("    ■ Reprodução parada.");
        }
    }
}
