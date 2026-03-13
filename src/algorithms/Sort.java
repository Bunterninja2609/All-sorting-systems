package algorithms;

public class Sort {
    public static void quick(int[] array){
        System.out.println("Starting Quicksort");
        int operations = 0;
        operations = quicksort(array, 0, array.length-1);
        System.out.println("needed operations for "+array.length + " integers: "+ operations);
        System.out.println(operations/array.length+ " operations per int");
    }
    private static int quicksort(int[] array, int start, int end){
        int operations = 0;
        int pivotIndex = (int)(Math.random()*(end-start));
        int pivot = array[pivotIndex];
        //TODO Rearrange Array, so all numbers smaller than the pivot are on the left, and all numbers bigger are on the right


        return operations + quicksort(array, start, pivotIndex -1) + quicksort(array, pivotIndex+1, end);
    }

    public static SortState bubble(int[] array){
        SortState sortState = new SortState(array);
        System.out.println("Starting Bubblesort");
        int operations = 0;
        while (true){
            boolean sorted = true;
            for (int i = 0; i < array.length - 1; i++) {
                if (array[i] > array[i + 1]) {
                    sorted = false;
                    int curr = array[i];
                    array[i] = array[i + 1];
                    array[i + 1] = curr;
                    sortState.switchPlaces(i, i + 1);
                }
                operations++;
            }
            if (sorted) break;
        }
        System.out.println("needed operations for "+array.length + " integers: "+ operations);
        System.out.println(operations/array.length+ " operations per int");
        return sortState;
    }

    public static SortState selection(int[] array){
        SortState sortState = new SortState(array);

        System.out.println("Starting Selectionsort");
        int operations = 0;
        for (int i = 0; i < array.length - 1; i++) {
            int current = array[i];
            int smallestIndex = i+1;
            for (int j = i+1; j < array.length; j++) {
                if (array[smallestIndex] > array[j]) {
                    smallestIndex = j;
                }
                operations++;
            }
            array[i] = array[smallestIndex];
            array[smallestIndex] = current;
        }
        System.out.println("needed operations for "+array.length + " integers: "+ operations);
        System.out.println(operations/array.length+ " operations per int");
        return sortState;
    }

    public static SortState insertion(int[] array){
        SortState sortState = new SortState(array);

        System.out.println("Starting Insertionsort");
        int operations = 0;
        for (int i = 1; i < array.length; i++) {
            int current = array[i];
            int j = i-1;
            // [ 4, 2, 6, 1 ]
            // [ 2, 4, 6, 1 ]
            // [ 1, 2, 4, 6 ]

            while(j >= 0 && array[j] > current){
                array[j+1] = array[j];
                j--;
                operations++;
            }
            array[j+1] = current;
        }
        System.out.println("needed operations for "+array.length + " integers: "+ operations);
        System.out.println(operations/array.length+ " operations per int");
        return sortState;
    }

    public static int[] getTestArray(int n){
        int[] array = new int[n];
        for (int i = 0; i < n; i++) {
            array[i] = (int)(Math.random()*n);
        }
        return array;
    }

    public static void  printArray(int[] array){
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i] + " ");
        }
        System.out.println("");
    }
}
