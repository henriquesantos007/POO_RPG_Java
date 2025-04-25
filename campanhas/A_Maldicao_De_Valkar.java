package campanhas;

import java.util.Map;
import java.util.Scanner;

import characters.Archer;
import characters.Person;
import characters.Warrior;
import characters.Wizzard;
import entities.Iten;
import entities.weapons.Weapon;
import enumeration.ItenRarity;
import enumeration.ItenType;
import enumeration.maps.A_Maldicao_de_Valka.Local;
import services.Pause;

public class A_Maldicao_De_Valkar {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Instancia do personagem principal
        Person myPlayer;

        // SINOPSE DA CAMPANHA
        System.out.println("" +
                "                       *** A MALDIÇÃO DE VALKAR ***\r\n" +
                "\r\n" +
                "     Uma antiga maldição assola a terra de Valkar, onde criaturas sombrias\r\n" +
                "     vagam pelas florestas e montanhas. Os habitantes da região estão\r\n" +
                "     aterrorizados e clamam por um herói que possa quebrar essa maldição.\r\n" +
                "\r\n" +
                "     Você é esse herói! Sua jornada começa na Torre do Mago, onde você\r\n" +
                "     receberá sua primeira missão: encontrar o Santuário de Fogo e\r\n" +
                "     descobrir a origem da maldição.\r\n" +
                "\r\n" +
                "     Prepare-se para enfrentar inimigos poderosos, explorar locais\r\n" +
                "     misteriosos e desvendar os segredos de Valkar. Boa sorte!\r\n");

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

        System.out.print("Pressione Enter para iniciar a campanha...");
        Pause.makePause();
        
        sc.nextLine();
        String enter = sc.nextLine(); 
        System.out.println();

        System.out.println(myPlayer.knowLocalization());
        Pause.makePause();

        System.out.println("Você avista uma cláridade ao sul. Ao se aproximar, você percebe que é uma torre antiga.");

        while (true){
        
            System.out.println("\nO que deseja fazer?");
            System.out.println("\n1. Seguir para a luz.");
            System.out.println("2. Verificar o inventário.");
            System.out.println("3. Visualizar Status.");
            System.out.println("4. Sair do jogo.");
            System.out.print("Escolha uma opção: ");
            int choice = sc.nextInt();
            
            

            if (choice == 1) {
                System.out.println("\nVocê segue a luz, e se depara com uma torre encardida. Mas que exala poder mágico e energia arcana.");
                System.out.println("A energia arcana vibra no ar, e você sente que algo poderoso está acontecendo dentro dela.\n");

                myPlayer.setLocalization(Local.TORRE);
                System.out.println(myPlayer.knowLocalization());

                System.out.println("\nAo entrar na Torre, você encontra um Mago que parece estar lutando contra uma força sombria.");
                System.out.println("O Mago lhe diz: 'Olá Viajante, sinto que você está fadado à um grande destino. A maldição de Valkar é antiga e poderosa. \nE você deve me ajudar a detê-la! Você deve encontrar o Santuário de Fogo para descobrir sua origem.'");

                System.out.println("Você aceita a missão e o Mago lhe entrega um mapa antigo que mostra a localização do Santuário de Fogo.");

                enumeration.maps.A_Maldicao_de_Valka.Map.showMap(myPlayer.getLocal());

                while (true){
                    System.out.println("\nO que deseja fazer?");
                    System.out.println("\n1. Explorar a Torre.");
                    System.out.println("2. Seguir para o Pico da Tempestade.");
                    System.out.println("3. Seguir para o Santuário de Fogo.");
                    System.out.println("4. Verificar o inventário.");
                    System.out.println("5. Visualizar Status.");
                    System.out.println("6. Sair do jogo.");
                    System.out.print("Escolha uma opção: ");
                    choice = sc.nextInt();

                    if (choice == 1) {
                        System.out.println("\nVocê explora a Torre e encontra um baú com um item mágico!");
                        if (myPlayer instanceof Warrior) {
                            System.out.println("Você encontrou uma Espada Mágica!");
                            myPlayer.bag.addInBag(new Weapon("Escalibbour", ItenType.SWORD, ItenRarity.LEGENDARY, 300.0));
                        } else if (myPlayer instanceof Wizzard) {
                            System.out.println("Você encontrou um Cajado Mágico!");
                            myPlayer.bag.addInBag(new Weapon("Cetro De Merlim", ItenType.STAFF, ItenRarity.LEGENDARY, 300.0));
                        } else if (myPlayer instanceof Archer) {
                            System.out.println("Você encontrou um Arco Mágico!");
                            myPlayer.bag.addInBag(new Weapon("Arco de Artemis", ItenType.STAFF, ItenRarity.LEGENDARY, 300.0));
                        }
                    } else if (choice == 2) {
                        myPlayer.bag.listItens();
                    } else if (choice == 3) {
                        
                    } else if( choice == 4) {
                        myPlayer.bag.listItens();
                    }  else if( choice == 5) {
                        System.out.println(myPlayer.status());
                    }  else if( choice == 6) {
                        break;
                    } else {
                        System.out.println("Opção inválida! Tente novamente.");
                    }
                }

            } else if (choice == 2) {
                myPlayer.bag.listItens();
            } else if (choice == 3) {
                System.out.println(myPlayer.status());
            } else if( choice == 4) {
                System.out.println("Você decidiu sair do jogo. Até a próxima!");
                break;
            } else {
                System.out.println("Opção inválida! Tente novamente.");
            }
        }


        sc.close();
    }
}
