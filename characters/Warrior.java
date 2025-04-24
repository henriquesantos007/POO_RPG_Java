package characters;

import enumeration.ClassType;
import enumeration.ItenRarity;
import enumeration.ItenType;
import services.Gamer;
import entities.Iten;

public class Warrior extends Person implements Gamer{
    private Double stamina;

    public Warrior (String name, String clan){
        this.name = name;
        this.clan = clan;
        clas = ClassType.WARRIOR;
        level = 1;
        health = 1500.0;
        attack = 30.0;
        deffense = 50.0;
        speed = 20.0;
        stamina = 1000.0;
        weapon = new Iten("Espada Enferrujada", ItenType.SWORD, ItenRarity.POOR);
    }

    public Double getStamina() {
        return stamina;
    }

    public void setStamina(Double stamina) {
        this.stamina = stamina;
    }

    public void attackMove(Person target){
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
        health -= damege;
        if (health <= 0){
            System.out.printf("O %s %s recebeu %.1f de dano e foi morto.\n", clas, name, damege);
        } else {
            System.out.printf("O %s %s recebeu %.1f de dano.\n", clas,  name, damege);
        }
    }

    @Override
    public boolean isAlive(){
        return health > 0;
    }

    @Override
    public void uppLevel(){
        this.level++;
        health += level * 0.2;
        attack += level * 0.2;
        deffense += level * 0.2;
        speed += level * 0.2;
        stamina += level * 0.2;
    }

    @Override
    public void equipIten(Iten iten){
        if (iten.getType() == ItenType.SWORD){
            weapon = iten;
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
        sb.append(String.format("Nome: %s, Clan: %s, Classe: %s, LV: ", name, clan, getClas()));
        sb.append(getLevel());
        sb.append(String.format(" Vida: %.1f", getHealth()));
        sb.append(String.format(" Stamina: %.1f, Velocidade: %.1f, Ataque: %.1f, Defesa: %.1f\n", getStamina(), getSpeed(), getAttack(), getDeffense()));
        sb.append("-------------------------------------------------------------------------------------------------------------------------------");
        return sb.toString();
    }

}
