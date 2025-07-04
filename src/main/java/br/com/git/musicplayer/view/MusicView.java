package br.com.git.musicplayer.view;

import br.com.git.musicplayer.controller.MusicController;
import br.com.git.musicplayer.model.entities.Music;
import br.com.git.musicplayer.repository.InMemoryMusicRepository;
import br.com.git.musicplayer.util.Style;

import java.util.ArrayList;
import java.util.Scanner;

public class MusicView {
    private final MusicController musicController;
    private final Scanner scanner = new Scanner(System.in);

    public MusicView() {
        musicController = new MusicController();
    }
    public void menuMusics() {
        int option;
        do {
            System.out.println(Style.blue + Style.bold + "\n    //  M E N U  //");
            System.out.println("    ---------------------------------" + Style.reset);
            System.out.println("    1 - Listar músicas");
            System.out.println("    2 - Buscar música por ID");
            System.out.println("    3 - Buscar música por título");
            System.out.println("    4 - Adicionar música");
            System.out.println("    5 - Remover música por ID");
            System.out.println("    6 - Remover música por título");
            System.out.println("    7 - Atualizar música");
            System.out.println("    0 - Voltar ao menu principal");
            System.out.print(Style.blue + "Opcão -> ");
            option = Integer.parseInt(scanner.nextLine());
            menuMusicsOptions(option);
        } while (option != 0);
    }

    public void menuMusicsOptions(int option) {
        switch (option) {
            case 1 -> showAllMusics();
            case 2 -> findMusicById();
            case 3 -> findMusicByTitle();
            case 4 -> addMusic();
            case 5 -> removeMusicById();
            case 6 -> removeMusicByTitle();
            default -> System.out.println("Opção inválida. Tente novamente.");
        }
    }

    public void showAllMusics() {
        showCharge();
        System.out.println(Style.white + Style.bold + "\n\n    //  M U S I C A S  //");
        System.out.println("    ---------------------------------" + Style.reset);
        musicController.showAllMusics();
    }

    public void findMusicById() {
        showCharge();
        System.out.println(Style.white + Style.bold + "\n\n    //  S E A R C H  //");
        System.out.println("    ---------------------------------" + Style.reset);
        System.out.print(Style.blue + "\nInforme o ID da música para busca -> ");
        int id = Integer.parseInt(scanner.nextLine());
        musicController.findMusicById(id);
    }

    public void findMusicByTitle(){
        showCharge();
        System.out.println(Style.white + Style.bold + "\n\n    //  S E A R C H  //");
        System.out.println("    ---------------------------------" + Style.reset);
        System.out.print(Style.blue + "\nInforme o título da música para busca -> ");
        String title = scanner.nextLine();
        musicController.findMusicByTitle(title);
    }

    public void addMusic(){
        showCharge();
        System.out.println(Style.white + Style.bold + "\n\n    //  A D D  M U S I C  //");
        System.out.println("    ---------------------------------" + Style.reset);
        System.out.print(Style.blue + "Titulo da música -> ");
        String title = scanner.nextLine();
        System.out.print(Style.blue + "Artista da música -> ");
        String artist = scanner.nextLine();
        System.out.print(Style.blue + "Álbum da música -> ");
        String album = scanner.nextLine();
        System.out.print(Style.blue + "Duração da música (em segundos) -> ");
        int duration = Integer.parseInt(scanner.nextLine());
        System.out.print(Style.blue + "Caminho do arquivo da música -> ");
        String path = scanner.nextLine();

        musicController.addMusic(path, title, duration, artist, album);
    }

    public void removeMusicById() {
        showCharge();
        System.out.println(Style.white + Style.bold + "\n\n    //  R E M O V E  M U S I C  //");
        System.out.println("    ---------------------------------" + Style.reset);
        System.out.print(Style.blue + "\nInforme o ID da música para remoção -> ");
        int id = Integer.parseInt(scanner.nextLine());
        musicController.removeMusicById(id);
    }

    public void removeMusicByTitle() {
        showCharge();
        System.out.println(Style.white + Style.bold + "\n\n    //  R E M O V E  M U S I C  //");
        System.out.println("    ---------------------------------" + Style.reset);
        System.out.print(Style.blue + "\nInforme o título da música para remoção -> ");
        String title = scanner.nextLine();
        musicController.removeMusicByTitle(title);
    }

    public void showCharge(){
        for(int i = 0; i < 3; i++) {
            System.out.println(Style.blue + "            . " + Style.reset);
            try {
                Thread.sleep(200); // Simula um carregamento
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
