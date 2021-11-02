package Lists;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

public class ListMain {
    public static void main(String[] args) throws Exception {
        List<String> myStringList = new ArrayList<String>();
        List<Integer> myIntList = new ArrayList<Integer>();
        WorkingWithLists obj = new WorkingWithLists();

        // Fill values in string list
        myStringList.add("Cat");
        myStringList.add("Dog");
        myStringList.add("Cow");
        myStringList.add("Horse");
        myStringList.add("Giraffe");

        // Fill random values in integer list
        for (int i = 0; i < 10; i++) {
            myIntList.add(ThreadLocalRandom.current().nextInt(-5, 5));
        }

        // Print the random values received
        obj.printList(myStringList);

        // Ex 1
        System.out.println("Ex 1:");
        try {
            obj.printValueAtIndex(myStringList, 5);
        }catch (ArrayIndexOutOfBoundsException  e){
            System.out.println(e);
        }

        // Ex 2
        System.out.println("Ex 2:");
        try {
            obj.updateValueAtSpecificIndex(myStringList, "Bee", 2);
        }catch (ArrayIndexOutOfBoundsException  e){
            System.out.println(e);
        }
        obj.printList(myStringList);

        // Ex 3
        System.out.println("Ex 3:");
        obj.swapTwoValues(myStringList, "Bee","Cat");
        obj.printList(myStringList);

        // Ex 4
        System.out.println("Ex 4:");
        try {
            obj.addValueAtIndex(myStringList, "Rabbit", 3);
        }catch (ArrayIndexOutOfBoundsException  e){
            System.out.println(e);
        }
        obj.printList(myStringList);

        // Ex 5
        System.out.println("Ex 5:");
        System.out.println(obj.checkIfExists(myStringList, "Cow"));

        // Ex 6
        System.out.println("Ex 6:");
        obj.sortListBigToSmall(myIntList);
        obj.printList(myIntList);

        // Ex 7
        System.out.println("Ex 7:");
        obj.shuffleList(myIntList);
        obj.printList(myIntList);
    }
}
