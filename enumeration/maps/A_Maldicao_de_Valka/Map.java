package enumeration.maps.A_Maldicao_de_Valka;

public class Map {


    public static void showMap(Local local) {
        if (local == Local.TORRE) {
            System.out.println(
                    "\n============== MAPA =============="+
                    "\n[@] - Você"+
                    "\n[P] - Pico da Tempestade"+
                    "\n[S] - Santuário de Fogo"+
                    "\n[V] - Vale das Sombras"+
                    "\n[R] - Ruínas de Tal'Rakar"+
                    "\n[C] - Caverna de Valkar"+
                    "\n                                  "+
                    "\n----------------------------------"+
                    "\n[ ] [ ] [@] [ ] [P]"+
                    "\n[ ] [ ] [ ] [ ] [ ]"+
                    "\n[ ] [ ] [S] [ ] [ ]"+
                    "\n[ ] [V] [ ] [ ] [ ]"+
                    "\n[ ] [ ] [ ] [R] [ ]"+
                    "\n[ ] [ ] [ ] [ ] [ ]"+
                    "\n[ ] [ ] [ ] [ ] [ ]"+
                    "\n[ ] [ ] [ ] [C] [ ]\n");
        }
    }
}
