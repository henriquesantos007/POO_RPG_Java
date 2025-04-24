package characters;


import enumeration.ClassType;
import entities.Inventory;
import entities.Iten;

public abstract class Person {
    // Classe do personagem - Tipo enum (WARRIOR, ARCHER, WIZZARD)
    protected ClassType clas;

    // Dados sociais
    protected String name;
    protected String clan = "NÃO INFORMADO";

    // Level e arma do personagem
    protected int level;
    protected Iten weapon;

    // Dados de combate (estatísticas)
    protected Double healthMax;
    protected Double health;
    protected Double speed;
    protected Double attack;
    protected Double deffense;


    // Inventário. Bolsa de itens
    protected Inventory bag;


    // getter e setters
    public Double getAttack() {
        return attack;
    }

    public String getClan() {
        return clan;
    }

    public ClassType getClas() {
        return clas;
    }

    public Double getDeffense() {
        return deffense;
    }

    public Double getHealth() {
        return health;
    }

    public int getLevel() {
        return level;
    }

    public String getName() {
        return name;
    }

    public Double getSpeed() {
        return speed;
    }

    public void setClan(String clan) {
        this.clan = clan;
    }


    // Métodos principais
    public abstract void attackMove (Person target);
    public abstract void takeDamege(Double damege);
    public abstract boolean isAlive();
    public abstract void uppLevel();
    public abstract void equipIten(Iten iten);
    

    // Método para exibir o status do jogador
    public String status(){
        StringBuilder sb = new StringBuilder();
        sb.append(String.format("\nNome: %s, Clan: %s, Classe: %s, LV: ", name, clan, getClas()));
        sb.append(getLevel());
        sb.append(String.format(" Vida: %.1f", getHealth()));
        sb.append(String.format("Velocidade: %.1f, Ataque: %.1f, Defesa: %.1f", getSpeed(), getAttack(), getDeffense()));

        return sb.toString();
    }
}
