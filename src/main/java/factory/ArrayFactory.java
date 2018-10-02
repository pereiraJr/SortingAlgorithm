package factory;

import java.util.Random;

public class ArrayFactory {

    public static int[] intArray(int arraySize, int bound){
        int[] randomArray = new int[arraySize];
        Random random = new Random();
        for (int i = 0; i < arraySize; i++) randomArray[i] = random.nextInt(bound);
        return randomArray;
    }
}
