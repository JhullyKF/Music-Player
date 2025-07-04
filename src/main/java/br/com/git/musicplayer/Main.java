package br.com.git.musicplayer;

import br.com.git.musicplayer.util.Style;
import br.com.git.musicplayer.view.MusicView;

import static java.lang.Thread.sleep;

public class Main {
    public static void main(String[] args) {
        welcomeMessage();
        new MusicView().menuMusics();
    }

    public static void welcomeMessage(){
        System.out.println(Style.bold + Style.blue + "\n//  M U S I C   P L A Y E R  //\n");
        System.out.println("---------------------------------\n" + Style.reset);

        try{
            System.out.println("Inicializando serviços...");
            sleep(400);
            System.out.println("▫ Verificando biblioteca de mídias...   " + Style.green + "[ OK ]" + Style.reset);
            sleep(400);
            System.out.println("▫ Conectando ao sistema de áudio...      " + Style.green + "[ OK ]" + Style.reset);
            sleep(400);
            System.out.println("▫ Calibrando equalizador...              " + Style.green + "[ OK ]\n\n" + Style.reset);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        System.out.flush();
    }
}