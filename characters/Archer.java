package characters;

import java.util.Random;

import entities.Iten;
import enumeration.ClassType;
import enumeration.ItenRarity;
import enumeration.ItenType;
import services.Gamer;

public class Archer extends Person implements Gamer{
    
    // Atributo específico de arqueiro
    private Double precision;

    // Construtor da classe arqueiro com características específicas
    public Archer (String name, String clan){
        this.name = name;
        this.clan = clan;
        clas = ClassType.ARCHER;
        level = 1;
        health = 1000.0;
        healthMax = 1000.0;
        attack = 10.0;
        deffense = 30.0;
        speed = 40.0;
        precision = 70.0;
        weapon = new Iten("Arco de Madeira", ItenType.BOW, ItenRarity.POOR);
    }

    public Double getPrecision() {
        return precision;
    }

    public void setPrecision(Double precision) {
        this.precision = precision;
    }


    // Método específico de ataque. Levará a precisão do arqueiro como fator
    @Override
    public void attackMove(Person target){
        Random rand = new Random();
        double chance = rand.nextDouble() * 100;

        if (chance <= precision) {
            System.out.println(name + " dispara uma flecha certeira!");
            target.takeDamege(attack);
        } else {
            System.out.println(name + " erra o disparo!");
        }
    }


    // Método de sofrer dano
    @Override
    public void takeDamege(Double damege){
        health -= damege;
        if (health <= 0){
            System.out.printf("O %s %s recebeu %.1f de dano e foi morto.\n", clas, name, damege);
        } else {
            System.out.printf("O %s %s recebeu %.1f de dano.\n", clas, name, damege);
        }
    }


    // Verifica se está vivo
    @Override
    public boolean isAlive(){
        return health > 0;
    }
    

    // Uppar de level. Melhora os atributos do personagem
    @Override
    public void uppLevel(){
        this.level++;
        healthMax += level * 0.2;
        health = healthMax;
        attack += level * 0.2;
        deffense += level * 0.2;
        speed += level * 0.2;
        precision += level * 0.2;
    }


    // Equipa um item como arma principal (Aceita somente arma específica para cada tipo de personagem)
    @Override
    public void equipIten(Iten iten){
        if (iten.getType() == ItenType.BOW){
            weapon = iten;
        }else{
            System.out.println("Impossível equipar.");
        }
    }


    // Locomoção do personagem
    @Override
    public void moove(int x, int y){
        System.out.printf("%s move-se para a posição (%d, %d).\n", name, x, y);
    }


    // Pula o turno para recuperar vida
    @Override
    public void makeTurn(){
        System.err.printf("%s descansa.\n", name);
        health += 10.0;
    }


    // Exibe informções do personagem
    @Override
    public String status(){
        StringBuilder sb = new StringBuilder();
        sb.append(String.format("Nome: %s, Clan: %s, Classe: %s, LV: ", name, clan, getClas()));
        sb.append(getLevel());
        sb.append(String.format(" Vida: %.1f", getHealth()));
        sb.append(String.format(" Precision: %.1f%%, Velocidade: %.1f, Ataque: %.1f, Defesa: %.1f\n", getPrecision(), getSpeed(), getAttack(), getDeffense()));
        sb.append("-------------------------------------------------------------------------------------------------------------------------------");
        
        return sb.toString();
    }
}
