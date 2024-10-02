import java.util.Scanner;

interface SortingAlgorithm {
    void sort(int[] array);
}

class BubbleSortAlgorithm implements SortingAlgorithm {
    public void sort(int[] array) {
        System.out.println("Sorting using Bubble Sort");
        for (int i = 0; i < array.length - 1; i++) {
            for (int j = 0; j < array.length - i - 1; j++) {
                if (array[j] > array[j + 1]) {
                    int temp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = temp;
                }
            }
        }
        printArray(array);
    }

    private void printArray(int[] array) {
        for (int j : array) {
            System.out.print(j + " ");
        }
        System.out.println();
    }
}

class QuickSortAlgorithm implements SortingAlgorithm {
    public void sort(int[] array) {
        System.out.println("Sorting using Quick Sort");
        quickSort(array, 0, array.length - 1);
        printArray(array);
    }

    private void quickSort(int[] array, int low, int high) {
        if (low < high) {
            int partitionIndex = partition(array, low, high);
            quickSort(array, low, partitionIndex - 1);
            quickSort(array, partitionIndex + 1, high);
        }
    }

    private int partition(int[] array, int low, int high) {
        int pivot = array[high];
        int i = (low - 1);
        for (int j = low; j < high; j++) {
            if (array[j] <= pivot) {
                i++;
                int temp = array[i];
                array[i] = array[j];
                array[j] = temp;
            }
        }
        int temp = array[i + 1];
        array[i + 1] = array[high];
        array[high] = temp;
        return i + 1;
    }

    private void printArray(int[] array) {
        for (int j : array) {
            System.out.print(j + " ");
        }
        System.out.println();
    }
}

class SortingContext {
    private SortingAlgorithm algorithm;

    public void setAlgorithm(SortingAlgorithm algorithm) {
        this.algorithm = algorithm;
    }

    public void executeSort(int[] array) {
        if (algorithm != null) {
            algorithm.sort(array);
        } else {
            System.out.println("No sorting algorithm selected.");
        }
    }
}

public class StrategyPattern {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        SortingContext context = new SortingContext();

        System.out.println("Choose a sorting algorithm: (1) Bubble Sort (2) Quick Sort");
        int choice = scanner.nextInt();

        int[] numbers = {5, 2, 9, 1, 5, 6};

        switch (choice) {
            case 1:
                context.setAlgorithm(new BubbleSortAlgorithm());
                break;
            case 2:
                context.setAlgorithm(new QuickSortAlgorithm());
                break;
            default:
                System.out.println("Invalid choice. Please choose 1 or 2.");
                return;
        }

        System.out.println("Sorting the array...");
        context.executeSort(numbers);

        scanner.close();
    }
}
