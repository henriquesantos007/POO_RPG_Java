package application;

import java.util.Locale;
import java.util.Scanner;

import characters.Person;
import characters.Wizzard;
import entities.Iten;
import entities.consumables.Consumable;
import entities.consumables.HealerPotion;
import entities.consumables.Key;
import entities.consumables.PoisonPotion;
import entities.weapons.Weapon;
import enumeration.ItenRarity;
import enumeration.ItenType;

public class TesteInventario {
    public static void main(String[] args) {
        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);

        // Inicialização do personagem do usuário
        Person myPlayer = new Wizzard("Gandalf", "ASSIS");

        // Itens da campanha
        Iten espada = new Weapon("Ceifeira da Morte", ItenType.SWORD, ItenRarity.LEGENDARY, 250.0);
        Iten arco = new Weapon("Noite Estrelada", ItenType.BOW, ItenRarity.COMMON, 15.0);
        Iten cajado = new Weapon("Cetro de Merlin", ItenType.STAFF, ItenRarity.RARE, 100.0);
        Iten chave = new Key("Chave do Inferno", ItenType.KEY);
        Iten pocao_cura = new HealerPotion("Poção de Cura Pequena", ItenType.HEALLER);
        Iten pocao_veneno = new PoisonPotion("Poção Venenosa", ItenType.POISON);

        myPlayer.bag.addInBag(espada);
        myPlayer.bag.addInBag(arco);
        myPlayer.bag.addInBag(cajado);
        myPlayer.bag.addInBag(chave);
        myPlayer.bag.addInBag(pocao_cura);
        myPlayer.bag.addInBag(pocao_veneno);
        myPlayer.bag.listItens();


        System.out.println();

        myPlayer.bag.useIten((Consumable)chave, myPlayer);

        System.out.println();

        myPlayer.bag.useIten((Consumable)pocao_veneno, myPlayer);

        System.out.println();

        myPlayer.bag.useIten((Consumable)pocao_cura, myPlayer);
        myPlayer.bag.useIten((Consumable)pocao_cura, myPlayer);

        myPlayer.bag.useIten((Consumable)pocao_veneno, myPlayer);

        myPlayer.bag.useIten((Consumable)pocao_cura, myPlayer);
        myPlayer.bag.useIten((Consumable)pocao_cura, myPlayer);

        myPlayer.bag.useIten((Consumable)pocao_veneno, myPlayer);

        myPlayer.bag.useIten((Consumable)pocao_cura, myPlayer);
        myPlayer.bag.useIten((Consumable)pocao_cura, myPlayer);
        myPlayer.bag.useIten((Consumable)pocao_cura, myPlayer);

        myPlayer.bag.useIten((Consumable)pocao_veneno, myPlayer);

        myPlayer.bag.useIten((Consumable)pocao_cura, myPlayer);
        myPlayer.bag.useIten((Consumable)pocao_cura, myPlayer);

        myPlayer.bag.useIten((Consumable)pocao_veneno, myPlayer);
        
        myPlayer.bag.useIten((Consumable)pocao_cura, myPlayer);
        
        
        
    

        sc.close();
    }
}
