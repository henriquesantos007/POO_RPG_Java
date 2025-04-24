package entities;

import java.util.ArrayList;
import java.util.List;

import characters.Person;
import entities.consumables.Consumable;

public class Inventory {
    private List<Iten> itens = new ArrayList<>();

    public Inventory(){}

    public void listItens(){
        System.out.println("========================= MY BAG =========================");
        for(Iten iten : itens){
            System.err.println(iten.toString());
        }
        System.out.println("==========================================================");
    }

    public void addInBag(Iten iten){
        itens.add(iten);
        System.out.println("Iten %s adicionado ao inventário.".formatted(iten.getName()));
    }

    public void removeFromBag(Iten iten){
        if(itens.remove(iten)){
            System.out.println("Iten %s removido do inventário.".formatted(iten.getName()));
        }else{
            System.out.println("Iten não encontrado no inventário.");
        }
    }

    public void useIten(Consumable iten, Person person){
        if(itens.contains(iten)){
            iten.useItem(person);
            //System.out.println("Iten %s usado.".formatted(iten.getName()));
            if (iten.getDuration() <= 0){
                itens.remove(iten);
                System.out.println("Iten %s removido do inventário.".formatted(iten.getName()));
            }
        }else{
            System.out.println("Iten não encontrado no inventário.");
        }
    }
}
