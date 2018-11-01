import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class Main {

    static ArrayList<Element> elementList;

    public static void main(String[] args) {
        loadElements();
        System.out.println(elementList);
        Population population = new Population(20);
        int numGens = 0;
        population.generation();
//        while(numGens < 5000000){
////            population.generation();
//            numGens ++;
//        }
//        population.print();
    }

    public static void loadElements(){
        elementList = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader("./src/Elements.txt"))) {

            String sCurrentLine;

            while ((sCurrentLine = br.readLine()) != null) {
                String[] arr = sCurrentLine.split(" ");
                elementList.add(new Element(arr[0], Integer.parseInt(arr[1]), Integer.parseInt(arr[2])));
            }

        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public static Element randomElement(){
        Element result;
        int a = (int)(Math.random() * elementList.size() - 1);
        result = elementList.get(a);
        return result;
    }
    public static int randomElementindex(){
//    Element result;
        int a = (int)(Math.random() * elementList.size() - 1);
//    result = elementList.get(a);
        return a;
    }

   public static int value(int i){
        return elementList.get(i).getValue();
   }

    public static int weight(int i){
        return elementList.get(i).getWeight();
    }

}