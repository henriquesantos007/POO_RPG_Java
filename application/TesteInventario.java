package application;

import java.util.Locale;
import java.util.Scanner;

import characters.Person;
import characters.Wizzard;
import entities.Iten;
import entities.weapons.Weapon;
import enumeration.ItenRarity;
import enumeration.ItenType;

public class TesteInventario {
    public static void main(String[] args) {
        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);

        // Inicialização do personagem do usuário
        Person myPlayer = new Wizzard("Gandalf", "ASS");

        // Itens da campanha
        Iten iten1 = new Weapon("Ceifeira da Morte", ItenType.SWORD, ItenRarity.LEGENDARY, 250.0);
        //Iten iten2 = new Weapon("Noite Estrelada", ItenType.BOW, ItenRarity.COMMON, 15.0);
        //Iten iten3 = new Weapon("Cetro de Merlin", ItenType.STAFF, ItenRarity.RARE, 100.0);
        //Iten iten4 = new Weapon("Chave do Inferno", ItenType.KEY, ItenRarity.POOR, 12.0);

        
        myPlayer.bag.addInBag(iten1);
        //myPlayer.getBag().listItens();
    

        sc.close();
    }
}
