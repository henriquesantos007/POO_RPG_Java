package entities;

import java.util.ArrayList;
import java.util.List;

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
    
    public void equipIten(Iten iten){};
}
