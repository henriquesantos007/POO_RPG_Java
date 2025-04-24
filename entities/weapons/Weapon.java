package entities.weapons;

import entities.Iten;
import enumeration.ItenRarity;
import enumeration.ItenType;

public class Weapon extends Iten {
    private Double power;
    private Double duration;
    private ItenRarity rarity;

    public Weapon (String name, ItenType type, ItenRarity rarity, Double power){
        super(name, type);
        this.power = power;
        this.rarity = rarity;
    }

    public Double getPower() {
        return power;
    }

    public void setPower(Double power) {
        this.power = power;
    }

    public ItenRarity getRarity() {
        return rarity;
    }

    public void setRarity(ItenRarity rarity) {
        this.rarity = rarity;
    }

    public Double getDuration() {
        return duration;
    }

    public void setDuration(Double duration) {
        this.duration = duration;
    }


    @Override
    public String toString(){
        StringBuilder sb = new StringBuilder();

        sb.append(String.format(" - Name: %s\n - Type: %s\n - Rarity: %s\n - Power: %.1f\n", getName(), getType(), getRarity(), getPower()));
        sb.append("-----------------");
        return sb.toString();
    }
}
