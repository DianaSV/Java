package Lists;

import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

public class WorkingWithLists {

    public void printList(List list) {
        System.out.print("The list is: ");
        for (Object value : list)
            System.out.print(value + " ");
        System.out.println(".");
    }

    // Ex 01 - Print out the value at specific index
    public void printValueAtIndex(List list, int index) throws Exception {
        if (index < list.size() - 1)
            System.out.println("The value at index '" + index + "' is: " + list.get(index));
        else
            throw new ArrayIndexOutOfBoundsException("Index out of bounds when the list is size of "
                    + list.size() + " but the index received was " + index + ".");
    }

    // Ex 02 - Add a value at specific index
    public void updateValueAtSpecificIndex(List list, String value, int index) {
        if (index < 0)
            throw new ArrayIndexOutOfBoundsException("Index cannot be under 0.");
        list.set(index, value);
    }

    // Ex 03 - Swap between 2 values
    public void swapTwoValues(List list, String value1, String value2) {
        if (!(list.contains(value1) && list.contains(value2))) {
            System.out.println("One or both values don't exist in the list, cannot swap.");
            return;
        }
        int index1 = list.indexOf(value1), index2 = list.indexOf(value2);
        list.set(index1, value2);
        list.set(index2, value1);
    }

    // Ex 04 - Add a value att specific index
    public void addValueAtIndex(List list, String value, int index) {
        if (index < 0)
            throw new ArrayIndexOutOfBoundsException("Index cannot be under 0.");
        list.add(0);
        for (int i = list.size() - 1; i >= 0; i--) {
            if (i == index) {
                list.set(index, value);
                break;
            }
            list.set(i, list.get(i - 1));
        }
    }

    // Ex 05 - Check if value exists in list
    public String checkIfExists(List list, String value) {
        if (list.contains(value))
            return "The value: '" + value + "' exists in this list";
        return "The value: '" + value + "' doesn't exist in this list";
    }

    // Ex 06 - Sort the values from big to small
    public void sortListBigToSmall(List list) {
        int temp, size = list.size();

        for (int i = 0; i < size - 1; i++) {
            for(int j = 0; j < size - 1; j++) {
                if ((int) list.get(j) < (int) list.get(j + 1)) {
                    temp = (int) list.get(j);
                    list.set(j, list.get(j + 1));
                    list.set(j + 1, temp);
                }
                temp = 0;
            }
        }
    }

    // Ex 07
    // More info on ThreadLocalRandom:
    // https://www.baeldung.com/java-thread-local-random
    public void shuffleList(List list){
        int randIndex1 = 0;
        int randIndex2 = 0;
        int randShuffleTimes = ThreadLocalRandom.current().nextInt(7, 15);

        for(int i = 0; i < randShuffleTimes; i++){
            // If the indexes will be equal, it won't count as a successful shuffle
            do{
                randIndex1 = ThreadLocalRandom.current().nextInt(0, list.size());
                randIndex2 = ThreadLocalRandom.current().nextInt(0, list.size());
            }while((randIndex1 == randIndex2));

            // Swap 2 values
            int temp = (int) list.get(randIndex1);
            list.set(randIndex1, list.get(randIndex2));
            list.set(randIndex2, temp);
        }
    }
}

