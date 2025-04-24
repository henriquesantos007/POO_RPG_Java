package entities.consumables;

import characters.Person;
import enumeration.ItenType;

public class Key extends Consumable{

    public Key (String name, ItenType type){
        super(name, type);
        duration = 1.0;
        quantityOfDuration = 1.0;
    }

    public void useItem(Person person){
        if (duration > 0){
            duration -= quantityOfDuration;
            System.out.printf("%s usou a chave %s com sucesso. ", person.getName(), getName());
        } else {
            System.out.println("Iten indisponível.");
        }
    }

    
}
