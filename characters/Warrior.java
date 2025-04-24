package characters;

import enumeration.ClassType;
import enumeration.ItenRarity;
import enumeration.ItenType;
import services.Gamer;
import entities.Iten;
import entities.weapons.Weapon;

public class Warrior extends Person implements Gamer{
    private Double stamina;

    public Warrior (String name, String clan){
        this.name = name;
        this.clan = clan;
        clas = ClassType.WARRIOR;
        level = 1;
        health = 150.0;
        healthMax = 150.0;
        attack = 30.0;
        deffense = 50.0;
        speed = 20.0;
        stamina = 1000.0;
        weapon = new Weapon("Espada Enferrujada", ItenType.SWORD, ItenRarity.POOR, 12.0);
    }

    public Double getStamina() {
        return stamina;
    }

    public void setStamina(Double stamina) {
        this.stamina = stamina;
    }

    public void attackMove(Person target){
        super.attackMove(target);
        if (stamina >= 100){
            System.out.printf("%s faz um ataque direto com sua arma %s\n", name, weapon.getName());
            target.takeDamege(attack);
            stamina -= 100;
        } else {
            System.err.printf("%s não tem folego para atacar.\n", name);
        }
    }

    @Override
    public void takeDamege(Double damege){
        super.takeDamege(damege);
        health -= damege;
        if (health <= 0){
            System.out.printf("O %s %s recebeu %.1f de dano e foi abatido.\n", clas, name, damege);
        } else {
            System.out.printf("O %s %s recebeu %.1f de dano.\n", clas,  name, damege);
        }
    }


    @Override
    public void uppLevel(){
        super.uppLevel();
        stamina += level * 0.2;
    }

    @Override
    public void equipIten(Iten iten){
        if (iten.getType() == ItenType.SWORD){
            weapon = iten;
            System.out.printf("%s equipou %s como arma principal.",name, weapon
            .getName());
        }else{
            System.out.println("Impossível equipar.");
        }
    }

    @Override
    public void moove(int x, int y){
        System.out.printf("%s corre para a posição (%d, %d).\n", name, x, y);
    }

    @Override
    public void makeTurn(){
        stamina += 100;
        health += 10.0;
        System.err.printf("%s descansa e regenera o folego.\n", name);
    }

    public String status(){
        StringBuilder sb = new StringBuilder();
        sb.append("---------------------\n");
        sb.append(String.format(" - Nome: %s\n - LV: %d\n - Clan: %s\n - Classe: %s\n", name, getLevel(), clan, getClas()));
        sb.append(String.format(" - Vida: %.1fHP\n", getHealth()));
        sb.append(String.format(" - Stamina: %.1f\n - Velocidade: %.1f\n - Ataque: %.1f\n - Defesa: %.1f\n", getStamina(), getSpeed(), getAttack(), getDeffense()));
        sb.append("---------------------\n");
        return sb.toString();
    }

}
