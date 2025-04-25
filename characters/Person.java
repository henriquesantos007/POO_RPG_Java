package characters;


import enumeration.ClassType;
import enumeration.maps.A_Maldicao_de_Valka.Local;
import entities.Inventory;
import entities.Iten;

public abstract class Person {
    // Classe do personagem - Tipo enum (WARRIOR, ARCHER, WIZZARD)
    protected ClassType clas;

    // Onde o personagem se encontra
    protected Local local = Local.INICIO;

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
    public Inventory bag = new Inventory();


    public Inventory getBag() {
        return bag;
    }


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

    public Double getHealthMax() {
        return healthMax;
    }

    public void setHealth(Double health) {
        this.health = health;
    }

    public void setHealthMax(Double healthMax) {
        this.healthMax = healthMax;
    }

    public void setLocalization(Local local) {
        this.local = local;
    }
    
    public Local getLocal() {
        return local;
    }

    // Métodos principais

    // Método de ataque. Cada classe terá seu método específico
    public void attackMove (Person target){
        System.out.println("------------------------------------");
        System.out.printf("%s Ataca %s\n", name, target.getName());
    }

    // Método de sofrer dano. Cada classe terá seu método específico
    public void takeDamege(Double damege){
        if(health <= 0){
            System.out.println("------------------------------------");
            isAlive();
        }
    }


    // Define se o personagem está vivo ou não
    public boolean isAlive(){
        if (health > 0){
            //System.out.println("------------------------------------");
            //System.out.printf("O personagem %s está vivo!\n", name);
            return true;
        } else {
            //System.out.println("------------------------------------");
            //System.out.printf("O personagem %s está morto!\n", name);
            return false;
        }
    };


    // Uppar de level. Melhora os atributos do personagem
    public void uppLevel(){
        this.level++;
        System.out.printf("%s subiu para o Nível %d level!\n", name, level);
        health += level * 0.2;
        attack += level * 0.2;
        deffense += level * 0.2;
        speed += level * 0.2;
    }


    // Equipar íten com arma principal. Cada classe terá seu método específico
    public abstract void equipIten(Iten iten);


    // Verifica onde o usuário está no mapa
    public String knowLocalization() {
        return String.format("%s Você está em: %s\n", local.getDescription(), local.getName());
    }

    // Método para exibir o status do jogador
    public String status(){
        StringBuilder sb = new StringBuilder();
        sb.append(String.format("\n - Nome: %s\n - Clan: %s\n - Classe: %s\n - Weapon: %s\n - LV: ", name, clan, getClas(), weapon.getName()));
        sb.append(getLevel());
        sb.append(String.format("\n - Vida: %.1fHP\n", getHealth()));
        sb.append(String.format(" - Velocidade: %.1f\n - Ataque: %.1f\n - Defesa: %.1f", getSpeed(), getAttack(), getDeffense()));

        return sb.toString();
    }

    public void makeTurn(){}
}
