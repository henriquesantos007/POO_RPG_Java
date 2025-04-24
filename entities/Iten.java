package entities;


import enumeration.ItenType;

public class Iten {
    private String name;
    private ItenType type;


    public Iten (String name, ItenType type){
        this.name = name;
        this.type = type;
    }

    public String getName() {
        return name;
    }

    
    public ItenType getType() {
        return type;
    }


    public void setName(String name) {
        this.name = name;
    }


    public void setType(ItenType type) {
        this.type = type;
    }


    public String toString(){
        StringBuilder sb = new StringBuilder();

        sb.append(String.format(" - Name: %s\n - Type: %s\n", name, type));
        sb.append("-----------------");

        return sb.toString();
    }
}
