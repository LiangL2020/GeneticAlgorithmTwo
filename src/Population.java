import java.util.*;

public class Population {

    private double elitism;
    private int size;
    private boolean elements;
    private Chromosome[] chromosome;


    public Population(int size){
        this.size = size;
        this.elements = false;
        this.elitism = 0.8;
        chromosome = new Chromosome[size];
        for (int i = 0; i < chromosome.length; i++) {
            chromosome[i] = new Chromosome();
        }
    }

    public void reset(){ //fill and kill
        while(chromosome.length < size){
            for (int i = chromosome.length; i < 0; i--) {
                if(i > elitism*chromosome.length){
                    int key1 = Main.randomElementindex();
                    int key2 = key1;
                    while(key2==key1)
                        key2 = Main.randomElementindex();

                    if(chromosome[key2].calScore()>chromosome[key1].calScore())
                        chromosome[key1] = chromosome[key2];
                    else
                        chromosome[key2] = chromosome[key1];

                }
            }
        }
    }

    public void sort(){
        List<Chromosome> asList = (ArrayList<Chromosome>)(Arrays.asList(chromosome));
        Collections.sort(asList, new Comparator<Chromosome>() {
            @Override
            public int compare(Chromosome o1, Chromosome o2) {
                return o1.calScore() - o2.calScore();
            }
        });

        for (int i = 0; i < asList.size(); i++) {
            chromosome[i] = asList.get(i);
        }

    }

    public void mate(){
//        int key1 = Main.randomElementindex();
//        int key2 = key1;
//        while(key2==key1)
//            key2 = Main.randomElementindex();

//        Element key3 = Main.randomElement();
//        Element key4 = key3;
//        while(key3==key4)
//            key3 = Main.randomElement();

        Chromosome[] kids = chromosome[0].mateWith(chromosome[1]);
        chromosome[chromosome.length-1] = kids[0];
        chromosome[chromosome.length-2] = kids[1];

    }

    public void generation(){
        reset();
        mate();
    }


}
