package br.com.git.musicplayer.view;

import br.com.git.musicplayer.controller.MusicController;

import java.util.Scanner;

public class MusicView {
    private final MusicController musicController;
    private final Scanner scanner = new Scanner(System.in);

    public MusicView() {
        musicController = new MusicController();
    }
    public void menuMusics() {
        System.out.println("1 - Listar músicas");
        System.out.println("2 - Buscar música por ID");
        System.out.println("3 - Buscar música por título");
        System.out.println("4 - Adicionar música");
        System.out.println("5 - Remover música por ID");
        System.out.println("6 - Remover música por título");
        System.out.println("7 - Atualizar música");
        System.out.println("0 - Voltar ao menu principal");
    }

    public void showAllMusics() {
        showCharge();
        System.out.println("Musicas disponíveis: ");
        musicController.showAllMusics();
    }

    public void findMusicById() {
        showCharge();
        System.out.println("Informe o ID da música para busca: ");
        int id = scanner.nextInt();
        System.out.println("Música encontrada com ID: " + id);
        musicController.findMusicById(id);
    }

    public void showCharge(){
        for(int i = 0; i < 3; i++) {
            System.out.print(".");
            try {
                Thread.sleep(500); // Simula um carregamento
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
