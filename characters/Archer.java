package characters;

import java.util.Random;

import entities.Iten;
import entities.weapons.Weapon;
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
        weapon = new Weapon("Arco de Madeira", ItenType.BOW, ItenRarity.POOR, 15.0);
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
        super.attackMove(target);
        Random rand = new Random();
        double chance = rand.nextDouble() * 100;

        if (chance <= precision) {
            System.out.printf("%s dispara uma flecha certeira com %s!",name, weapon.getName());
            target.takeDamege(attack);
        } else {
            System.out.println(name + " erra o disparo!");
        }
    }


    // Método de sofrer dano
    @Override
    public void takeDamege(Double damege){
        super.takeDamege(damege);
        health -= damege;
        if (health <= 0){
            System.out.printf("O %s %s recebeu %.1f de dano e foi abatido.\n", clas, name, damege);
        } else {
            System.out.printf("O %s %s recebeu %.1f de dano.\n", clas, name, damege);
        }
    }

    

    // Uppar de level. Melhora os atributos do personagem
    @Override
    public void uppLevel(){
        super.uppLevel();
        precision += level * 0.2;
    }


    // Equipa um item como arma principal (Aceita somente arma específica para cada tipo de personagem)
    @Override
    public void equipIten(Iten iten){
        if (iten.getType() == ItenType.BOW){
            weapon = iten;
            System.out.printf("%s equipou %s como arma principal.",name, weapon
            .getName());
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
        sb.append("---------------------\n");
        sb.append(String.format(" - Nome: %s\n - LV: %d\n - Weapon: %s\n - Clan: %s\n - Classe: %s\n", name, getLevel(), weapon.getName(),clan, getClas()));
        sb.append(String.format(" - Vida: %.1fHP\n", getHealth()));
        sb.append(String.format(" - Precision: %.1f%%\n - Velocidade: %.1f\n - Ataque: %.1f\n - Defesa: %.1f\n", getPrecision(), getSpeed(), getAttack(), getDeffense()));
        sb.append("---------------------");        
        return sb.toString();
    }
}
