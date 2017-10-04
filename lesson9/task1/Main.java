package homeworks.lesson9.lesson9b;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Random;

public class Main {

    public static void main(String[] args){

        listCreator(10);
        
  }

   public static void listCreator(int size){

        List<Integer> listOfInteger = new ArrayList<>();

        Random rd = new Random();
        for(int i = 0; i < size; i++){
            listOfInteger.add(rd.nextInt(100));
        }

        System.out.println(listOfInteger);

        listOfInteger.remove(0);
        listOfInteger.remove(0);
        listOfInteger.remove(listOfInteger.size() - 1);

        System.out.println(listOfInteger);
    }
}
