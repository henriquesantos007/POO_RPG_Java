package entities.consumables;

import enumeration.ItenType;

public class Key extends Consumable{

    public Key (String name, ItenType type){
        super(name, type);
        duration = 1.0;
        quantityOfDuration = 1.0;
    }

    public void useKey(){
        if (duration > 0){
            duration -= quantityOfDuration;
            System.out.printf("Chave %s usada com sucesso.", getName());
        } else {
            System.out.println("Iten indisponível.");
        }
    }

    
}
