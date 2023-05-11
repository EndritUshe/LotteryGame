import java.util.Random;

public class Main {
    public static void main(String[] args) {
        int[] array = new int[8];
        Random random = new Random();
        for (int i = 0; i < array.length; i++) {
            int randomNumber = random.nextInt(100);
            boolean isDuplicate = false;
            for (int j = 0; j < i; j++) {
                if (array[j] == randomNumber) {
                    isDuplicate = true;
                    break;
                }
            }
            if (isDuplicate) {
                i--;
            } else {
                array[i] = randomNumber;
            }
        }
        System.out.print("This program stimulates a lottery. It generates 8 random numbers and sorts them out.");
        System.out.print("\nOne condition is that the numbers generated should not be duplicates.");
        System.out.print("\nThe numbers of the lottery before sorted: ");
        print(array);
        quickSort(array, 0, array.length - 1);
        System.out.print("\nThe numbers of the lottery after sorted: ");
        print(array);
    }


    private static void print(int[] array) {
        for (int i : array) {
            System.out.print(i + " ");
        }
    }

    private static void quickSort(int[] array, int start, int end) {
        if (end <= start) return;
        int pivot = partition(array, start, end);
        quickSort(array, start, pivot - 1);
        quickSort(array, pivot + 1, end);
    }

    private static int partition(int[] array, int start, int end) {
        int pivot = array[end];
        int i = start - 1;
        for (int j = start; j < end; j++) {
            if (array[j] < pivot) {
                i++;
                int temp = array[i];
                array[i] = array[j];
                array[j] = temp;
            }
        }
        i++;
        int temp = array[i];
        array[i] = array[end];
        array[end] = temp;
        return i;
    }
}