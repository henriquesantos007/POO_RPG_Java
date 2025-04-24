package entities.consumables;

import characters.Person;
import enumeration.ItenType;

public class HealerPotion extends Consumable{
    // Quanto cura
    private Double healthRange;


    // Construtor da poção
    public HealerPotion (String name, ItenType type){
        super(name, type);
        healthRange = 30.0;
        duration = 300.0;
        quantityOfDuration = 30.0;
    }


    // Getters e setters
    public Double getHealthRange() {
        return healthRange;
    }

    public void setHealthRange(Double healthRange) {
        this.healthRange = healthRange;
    }


    // Usar a poção de cura
    public void useItem(Person person){
        Double healtPerson = person.getHealth();
        Double healthMaxPerson = person.getHealthMax();


        if (healtPerson <= 0){
            System.out.println("Impossível usar esse íten em um personagem morto.");
        } else if (healtPerson <= healthMaxPerson - healthRange){
            person.setHealth(healtPerson += healthRange);
            System.out.printf("Poção usada com sucesso. Vida de %s restaurada para HP%.1f.\n",person.getName(),  person.getHealth());
        } else {
            person.setHealth(person.getHealthMax());
            System.out.printf("Poção usada com sucesso. Vida de %s restaurada para HP%.1f.\n",person.getName(), person.getHealth());
        }

        duration -= quantityOfDuration;

        if (duration <= 0){
            System.out.printf("O iten %s esgotou. ", getName());
        }
    }


    // Legenda com dados do iten
    public String toString(){
        StringBuilder sb = new StringBuilder();

        sb.append(String.format(" - Name: %s\n - Type: %s\n - Duration: %.1f\n - Quantity of Duration: %.1f\n - Healer Range: +%.1fHP\n", 
        getName(), getType(), getDuration(), getQuantityOfDuration(), getHealthRange()));
        sb.append("-----------------");

        return sb.toString();
    }
}
