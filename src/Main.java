import algorithms.Sort;

public class Main {
    public static void main(String[] args) {
        int[] testArray = Sort.getTestArray(10);
        Sort.selection(testArray);
        Sort.printArray(testArray);
    }
}