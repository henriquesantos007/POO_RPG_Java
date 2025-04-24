package entities;


import enumeration.ItenRarity;
import enumeration.ItenType;

public class Iten {
    private String name;
    private ItenRarity rarity;
    private ItenType type;
    private Double power;

    public Iten (String name, ItenType type, ItenRarity rarity, Double power){
        this.name = name;
        this.type = type;
        this.rarity = rarity;
        this.power = power;
    }

    public Iten (String name, ItenType type, ItenRarity rarity){
        this.name = name;
        this.type = type;
        this.rarity = rarity;
    }

    public String getName() {
        return name;
    }

    public ItenRarity getRarity() {
        return rarity;
    }
    
    public ItenType getType() {
        return type;
    }

    public Double getPower() {
        return power;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setRarity(ItenRarity rarity) {
        this.rarity = rarity;
    }

    public void setType(ItenType type) {
        this.type = type;
    }

    public void setPower(Double power) {
        this.power = power;
    }

    public String toString(){
        StringBuilder sb = new StringBuilder();

        sb.append(String.format(" - Name: %s, Type: %s, Rarity %s.", name, type, rarity));

        return sb.toString();
    }
}
