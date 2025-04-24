package characters;

import entities.Iten;
import entities.weapons.Weapon;
import enumeration.ClassType;
import enumeration.ItenRarity;
import enumeration.ItenType;
import services.Gamer;

public class Wizzard extends Person implements Gamer{
    
    private Double mana;

    public Wizzard (String name, String clan){
        this.name = name;
        this.clan = clan;
        clas = ClassType.WIZZARD;
        level = 1;
        health = 850.0;
        attack = 10.0;
        deffense = 30.0;
        speed = 40.0;
        mana = 10000.0;
        weapon = new Weapon("Cajado Velho", ItenType.STAFF, ItenRarity.POOR, 12.0);
    }


    public Double getMana() {
        return mana;
    }

    public void setMana(Double mana) {
        this.mana = mana;
    }

    @Override
    public void attackMove(Person target){
        if (mana >= 100){
            System.out.printf("%s lança uma bola de fogo!\n", name);
            target.takeDamege(attack);
            mana -= 100;
        } else {
            System.out.printf("%s está sem mana.\n", name);
        }
    }

    @Override
    public void takeDamege(Double damege){
        health -= damege;
        if (health <= 0){
            System.out.printf("O %s %s recebeu %.1f de dano e foi morto.\n", clas, name, damege);
        } else {
            System.out.printf("O %s %s recebeu %.1f de dano.\n", clas, name, damege);
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
        mana += level * 0.2;
    }


    @Override
    public void equipIten(Iten iten){
        if (iten.getType() == ItenType.STAFF){
            weapon = iten;
            System.out.printf("%s equipou %s como arma principal.",name, weapon
            .getName());
        }else{
            System.out.println("Impossível equipar.");
        }
    }

    @Override
    public void moove(int x, int y){
        System.out.printf("%s flutua para a posição (%d, %d).\n", name, x, y);
    }

    @Override
    public void makeTurn(){
        mana += 50;
        health += 10.0;
        System.err.printf("%s medita e regenera a mana.\n", name);
    }

    @Override
    public String status(){
        StringBuilder sb = new StringBuilder();
        sb.append("-------------------------------------------------------------------------------------------------------------------------------\n");
        sb.append(String.format(" - Nome: %s\n - LV: %d\n - Clan: %s\n - Classe: %s\n", name, getLevel(), clan, getClas()));
        sb.append(String.format(" - Vida: %.1fHP\n", getHealth()));
        sb.append(String.format(" - Mana: %.1f\n - Velocidade: %.1f\n - Ataque: %.1f\n - Defesa: %.1f\n", getMana(), getSpeed(), getAttack(), getDeffense()));
        sb.append("-------------------------------------------------------------------------------------------------------------------------------");
        return sb.toString();
    }


}
