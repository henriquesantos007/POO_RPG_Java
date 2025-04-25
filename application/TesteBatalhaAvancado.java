package application;

import java.util.Locale;
import java.util.Scanner;

import characters.Archer;
import characters.Person;
import characters.Warrior;
import characters.Wizzard;

public class TesteBatalhaAvancado {
    public static void main(String[] args) {
        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);

        Person myPlayer;

        // Início da campanha
        System.out.println("COMEÇAR CAMPANHA...\n");

        System.out.println("=============================== BATALHA ===============================");
        System.out.println("Você foi capturado e agora está sendo obrigado a lutar pela vida em uma\n arena aterrorizande! Combata cada inimigo com garra para passar de fase\ne ser libertado por mérito!");
        System.out.println("=======================================================================");

        // Criação do personagem
        System.out.println("Crie seu personagem:");
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
        }
        System.out.println("Personagem criado com sucesso!");
        System.out.println();
        System.out.println(myPlayer.status());
        System.out.println();

        System.out.println();

        Person enemy1 = new Warrior("Calkavan", "Borius");
        enemy1.setLevel(1);
        System.out.println("O primeiro inimigo apareceu!");
        System.out.println(enemy1.status());
        System.out.println("Que começe a batalha!!\n");

        while (myPlayer.isAlive() && enemy1.isAlive()){
            System.out.println("\n\nTurno do jogador:");
            myPlayer.attackMove(enemy1);
            System.out.println(enemy1.status());
            myPlayer.makeTurn();

            if (!enemy1.isAlive()){
                System.out.println("Você venceu essa luta, mas não a guerra!");
                System.out.println("PRÓXIMA FASE!");
                break;
            }

            System.out.println("Turno do inimigo:");
            enemy1.attackMove(myPlayer);
            myPlayer.takeDamege(enemy1.getAttack());
            System.out.println(myPlayer.status());
            enemy1.makeTurn();

            if (!myPlayer.isAlive()){
                System.out.println("Você foi derrotado!");
                System.out.println("GAME OVER!");
                break;
            }
        }

        



        sc.close();
    }
}
