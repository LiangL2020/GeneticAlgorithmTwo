public class Element {

    private int weight, value;
    private String name;

    public Element(String name,int weight, int value) {
        this.weight = weight;
        this.value = value;
        this.name = name;
    }

    public String toString(){
        return name + " weight: " + weight + " value: " + value;
    }

    public int getValue(){return value;}

    public int getWeight(){return weight;}
}