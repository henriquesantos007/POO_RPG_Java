package entities.consumables;

import characters.Person;
import enumeration.ItenType;

public class PoisonPotion extends Consumable {
    // Quanto cura
    private Double damageRange;


    // Construtor da poção
    public PoisonPotion (String name, ItenType type){
        super(name, type);
        damageRange = 50.0;
        duration = 200.0;
        quantityOfDuration = 50.0;
    }


    // Getters e setters
    public Double getHealthRange() {
        return damageRange;
    }

    public void setHealthRange(Double damageRange) {
        this.damageRange = damageRange;
    }


    // Usar a poção de cura
    public void usePotion(Person person){
        Double healtPerson = person.getHealth();

        if (healtPerson <= 0){
            System.out.println("Impossível usar esse íten em um personagem morto.");
        } else if (healtPerson <= damageRange){
            person.setHealth(healtPerson -= damageRange);
            System.out.printf("Veneno usado com sucesso. %s foi morto HP%.1f.\n", person.getName(), person.getHealth());
        } else {
            person.setHealth(person.getHealthMax());
            System.out.printf("Veneno usado com sucesso.. Vida de %s reduzida para HP%.1f.\n",person.getName(), person.getHealth());
        }

        duration -= quantityOfDuration;

        if (duration <= 0){
            System.out.printf("O iten %s esgotou.", getName());
        }
    }


    // Legenda com dados do iten
    public String toString(){
        StringBuilder sb = new StringBuilder();

        sb.append(String.format(" - Name: %s\n - Type: %s\n - Duration: %.1f\n - Quantity of Duration: %.1f\n - Damege Range: -%.1fHP\n", 
        getName(), getType(), getDuration(), getQuantityOfDuration(), getHealthRange()));
        sb.append("-----------------");

        return sb.toString();
    }
}
