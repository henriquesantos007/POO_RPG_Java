package entities.consumables;

import characters.Person;
import entities.Iten;
import enumeration.ItenType;

public abstract class Consumable extends Iten{
    protected Double duration;
    protected Double quantityOfDuration;

    // Construtor de Iten
    public Consumable (String name, ItenType type){
        super(name, type);
    }

    // Getters e Setters
    public Double getDuration() {
        return duration;
    }

    public void setDuration(Double duration) {
        this.duration = duration;
    }

    public Double getQuantityOfDuration() {
        return quantityOfDuration;
    }

    public void setQuantityOfDuration(Double quantityOfDuration) {
        this.quantityOfDuration = quantityOfDuration;
    }

    public abstract void useItem(Person person);
}
