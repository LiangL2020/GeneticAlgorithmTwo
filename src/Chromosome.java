import com.sun.org.apache.xpath.internal.operations.Bool;

public class Chromosome {

    private boolean[] code; //taking the element or not
    private int cost, maxWeight, weight, value;


   public Chromosome(){
       code = new boolean[Main.elementList.size()];
       weight = 0;
       value = 0;
       maxWeight = 1000;
       cost = 0;
   }

    public Chromosome(boolean[] other) {
        code = new boolean[Main.elementList.size()];
        weight = 0;
        value = 0;
        maxWeight = 1000;
        cost = 0;
        other = other;
    }

        public void mutate(double chance) {
        if (Math.random() > chance) {
            return;
        }

        int index = Main.randomElementindex();
        if (code[index]){
            code[index] = false;
        }else if(!code[index]){
            code[index] = true;
        }
    }

    public int calScore(){
        //TODO: if score then score????

        for (int i = 0; i < code.length; i++) {
            if(code[i]){
                value += Main.value(i);
                weight += Main.weight(i);
            }
        }
        cost = value;

        if(this.weight > maxWeight)
            cost -= (weight-maxWeight)*50;

        return cost;

    }

/*
//pivot at middle. returns 2 offspring
    public Chromosome[] mate(Chromosome other){
        int pivot = code.length()/2+1;
        String firstChild = code.substring(0, pivot) + other.getCode().substring(pivot);
        String secondChild = other.getCode().substring(0, pivot) + code.substring(pivot);
        Chromosome[] kids = {new Chromosome(firstChild), new Chromosome(secondChild)};
        return kids;
    }

    //alternating chars.  Experimenting.
    public Chromosome[] mate2(Chromosome other){
        String kid1 = "";
        String kid2 = "";
        for (int i = 0; i < code.length(); i++) {
            if(i % 2 == 0) {
                kid1 += code.charAt(i);
                kid2 += other.code.charAt(i);
            }else{
                kid2 += code.charAt(i);
                kid1 += other.code.charAt(i);
            }
        }
        Chromosome[] ans = {new Chromosome(kid1), new Chromosome(kid2)};
        return ans;

    }
 */

    public Chromosome[] mateWith(Chromosome other){
        int pivot = (int)(Math.random() * code.length - 1);
        boolean[] child1 = new boolean[code.length];
        boolean[] child2 = new boolean[code.length];

        for (int i = 0; i < code.length; i++) {
            if(i<pivot){
                child1[i] = code[i];
                child2[i] = other.code[i];
            }
            else{
                child2[i] = code[i];
                child1[i] = other.code[i];
            }
        }

        Chromosome[] ans = {new Chromosome(child1), new Chromosome(child2)}; //TODO: what does this do???
        return ans;
    }

    public boolean getCode() {
        for (int i = 0; i < code.length; i++) {
            if (code[i])
                return true;
        }
        return false;
    }
    public int getCost() {
        return cost;
    }
}
