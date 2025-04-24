/*
 * Esse é um arquivop de TESTE que usei para analisar o funcionamento do programa
 * O programa apresenta TRÊS campanhas principais. "A Maldição de Valkar", "A Guerra dos Clãs" e "O Coração de Gélidan".
 * Para joga-las, abra os arquivos das campanhas no pacote "applications" e execute o código.
 */

package application;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

import entities.Iten;
import entities.consumables.Consumable;
import entities.consumables.HealerPotion;
import entities.consumables.Key;
import entities.consumables.PoisonPotion;
import entities.weapons.Weapon;
import enumeration.ItenRarity;
import enumeration.ItenType;

public class TesteItens {
    public static void main(String[] args) {
        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);



        // Itens da campanha
        Iten iten1 = new Weapon("Ceifeira da Morte", ItenType.SWORD, ItenRarity.LEGENDARY, 250.0);
        Iten iten2 = new Weapon("Noite Estrelada", ItenType.BOW, ItenRarity.COMMON, 15.0);
        Iten iten3 = new Weapon("Cetro de Merlin", ItenType.STAFF, ItenRarity.RARE, 100.0);
        Iten iten4 = new Key("Chave do Inferno", ItenType.KEY);
        Iten iten5 = new HealerPotion("Poção de Cura Pequena", ItenType.HEALLER);
        Iten iten6 = new PoisonPotion("poção Venenosa", ItenType.POISON);

        // Lista de itens do jogo
        List<Iten> allItens = new ArrayList<>();
        allItens.add(iten1);
        allItens.add(iten2);
        allItens.add(iten3);
        allItens.add(iten4);
        allItens.add(iten5);
        allItens.add(iten6);
        
    for (Iten iten : allItens){
        System.out.println(iten.toString());
    }



        sc.close();
    }
}
 