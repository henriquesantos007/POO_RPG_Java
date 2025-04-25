package entities;

import java.util.ArrayList;
import java.util.List;

import characters.Person;
import entities.consumables.Consumable;

public class Inventory {
    private List<Iten> itens = new ArrayList<>();

    public Inventory(){}

    public void listItens(){
        if (itens.isEmpty()){
            System.out.println("\n========================= MY BAG =========================");
            System.out.println("Moscas saem da sua bolsa. Você não tem nada no inventário.");
            System.out.println("==========================================================\n");
            return;
        } else{
            System.out.println("\n========================= MY BAG =========================");
            for(Iten iten : itens){
                System.err.println(iten.toString());
            }
            System.out.println("==========================================================\n");
        }
    }

    public void addInBag(Iten iten){
        itens.add(iten);
        System.out.printf("Iten %s, %s adicionado ao inventário.\n", iten.getType(), iten.getName());
    }

    public void removeFromBag(Iten iten){
        if(itens.remove(iten)){
            System.out.printf("Iten %s, %s removido do inventário.\n", iten.getType(), iten.getName());
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
