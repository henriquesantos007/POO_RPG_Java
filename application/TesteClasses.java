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

import characters.Person;
import characters.Archer;
import characters.Warrior;
import characters.Wizzard;
import entities.Iten;
import entities.weapons.Weapon;
import enumeration.ItenRarity;
import enumeration.ItenType;

public class TesteClasses {
    public static void main(String[] args) {
        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);

        // Inicialização do personagem do usuário
        Person myPlayer;

        List<Person> allPlayers = new ArrayList<>();

        // Oponente de teste
        Archer oponente1 = new Archer("Luiz", "Sérvia");
        Warrior oponente2 = new Warrior("Mario", "Moçambu");

        // Itens da campanha
        Iten iten1 = new Weapon("Ceifeira da Morte", ItenType.SWORD, ItenRarity.LEGENDARY, 250.0);
        Iten iten2 = new Weapon("Noite Estrelada", ItenType.BOW, ItenRarity.COMMON, 15.0);
        Iten iten3 = new Weapon("Cetro de Merlin", ItenType.STAFF, ItenRarity.RARE, 100.0);
        Iten iten4 = new Weapon("Chave do Inferno", ItenType.KEY, ItenRarity.POOR, 12.0);

        // Lista de itens do jogo
        List<Iten> allItens = new ArrayList<>();
        allItens.add(iten1);
        allItens.add(iten2);
        allItens.add(iten3);
        allItens.add(iten4);
        
        // Início da campanha
        System.out.println("COMEÇAR CAMPANHA...\n");

        // Criação do personagem
        /*System.out.println("Crie seu personagem:");
        System.out.print("Nome: ");
        String name = sc.nextLine();
        System.out.print("Nome do seu Clan: ");
        String clan = sc.nextLine();

        // Definição da classe. OBS: Personagem instanciado de a cordo com a classe definida pelo usuário
        while(true){
            System.out.print("Classe do personagem [G, M, A]: ");
            char personClass = sc.next().charAt(0);
            Character.toUpperCase(personClass);

            if (personClass == 'G'){
                myPlayer = new Warrior(name, clan);
                break;
            }else if (personClass == 'M'){
                myPlayer = new Wizzard(name, clan);
                break;
            }else if (personClass == 'A'){
                myPlayer = new Archer(name, clan);
                break;
            }else{
                System.out.println("Clásse inválida! Escolha Guerreiro, Mago ou Arqueiro!\n");
            }
        }*/
        
        myPlayer = new Wizzard("Merlin", "ASS");

        System.out.println();

        
        allPlayers.add(myPlayer);
        allPlayers.add(oponente1); 
        allPlayers.add(oponente2);

        // Detalhes dos personagem criado
        for (Person player : allPlayers) {
            System.out.println(player.status());
        }

        // Batalha de teste
        System.out.println("\n======================== BATTLE ========================");
        /*for (Person player : allPlayers) {
            System.out.println(player.status());
        }*/



        sc.close();
    }
}
