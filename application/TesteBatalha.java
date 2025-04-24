package application;

import java.util.Locale;
import java.util.Scanner;

import characters.Warrior;
import characters.Wizzard;

public class TesteBatalha {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Locale.setDefault(Locale.US);

        // Combatente 1
        Wizzard mago = new Wizzard("Merlin", "KONAN");

        for(int i = 0; i <= 100; i++){
            mago.uppLevel();
        }

        // Combatente 2
        Warrior guerreiro = new Warrior("Alessandro", "ASSIS");

        System.out.println("\n\n========================== BATALHA ==========================");
        mago.attackMove(guerreiro);
        mago.attackMove(guerreiro);

        guerreiro.isAlive();

        sc.close();
    }
}
