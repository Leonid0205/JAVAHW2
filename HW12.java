import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

/**
Алгоритм сортировки вставками
 */
public class HW12 {
    /** Function creates an array of a certain size
    * @param size a size of an array
    */  
    public static int[] createArray(int size) {
        int[] array = new int[size];
        Random random = new Random();
        for (int i = 0; i < size; i++) {
            array[i] = random.nextInt(0, 77);
        }
        return array;
    }
    /** Function sorts an array by inserts
    * @param array an array
    */  
    public static int[] sortPaste(int[] array) {
        for (int i = 1; i < array.length; i++) {
            int currentNumber = array[i];
            int previousInd = i -1;
            while (previousInd >= 0 && array[previousInd] > currentNumber) {
                array[previousInd + 1] = array[previousInd];
                array[previousInd] = currentNumber;
                previousInd--;
            }
        }
        return array;
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Input a size of an array: ");
        int size = scanner.nextInt();
        scanner.close();
        int[] array = createArray(size);
        System.out.println(String.format("%-10s= %s", "Initial array ", Arrays.toString(array)));
        int[] arraySorted = sortPaste(array);
        System.out.println(String.format("%-10s= %s", "Sorted array ", Arrays.toString(arraySorted)));
    }
}
