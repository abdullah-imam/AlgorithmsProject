import java.util.Random;
import java.lang.System;

public class Sort {

    // insertionSort Method
    public void insertionSort(int arr[]) {

        int key, j;

        for (int i = 1; i < arr.length; i++) {

            key = arr[i];
            j = i - 1;

            while (j >= 0 && arr[j] > key) {

                arr[j + 1] = arr[j];
                j--;

            }

            arr[j + 1] = key;
            
        }

    }

    // heapify Method
    public void heapify(int arr[], int node, int index, int heapType) { 

        int parent = index; // Initialize "parent" As Root 
        int left = 2 * parent + 1; // Get Left Child From "parent"
        int right = 2 * parent + 2; // Get Right Child From "parent"

        /**
          * If ("heapType" == 0) => It's Min-Heap
          * If ("heapType" == 1) => It's Max-Heap
        **/
        
        // If Left Child Is Larger Than Parent
        if (left < node && ((heapType == 0 && arr[left] > arr[parent]) || (heapType == 1 && arr[left] < arr[parent]))) 

            parent = left; // Make The Left Child As Parent
  
        // If Right Child Is Larger Than Parent
        if (right < node && ((heapType == 0 && arr[right] > arr[parent]) || (heapType == 1 && arr[right] < arr[parent])))

            parent = right; // Make The Right Child As Parent
  
        if (parent != index) {

            swap(arr, index, parent);
            
            heapify(arr, node, parent, heapType);

        } 

    } 

    // buildHeap Method
    public void buildHeap(int[] arr, int heapType) {

        int heapSize = arr.length;

        for (int i = (heapSize / 2) - 1; i >= 0; i--)
        
            heapify(arr, heapSize, i, heapType);

    }

    // heapSort Method
    public void heapSort(int arr[], int heapType) { 
        
        buildHeap(arr, heapType); 
  
        for (int i = arr.length - 1; i > 0; i--) {
         
            swap(arr, i, 0);
  
            heapify(arr, i, 0, heapType); 

        } 

    }

    // Make A Swap In Position Between The Child And The Parent In The Array
    public void swap(int arr[], int i, int j) {

        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;

    }

    // Fill Array With Random Numbers
    public void fillArray(int[] arr) {

        int numbersRange = 100; // Make The Range between 0 To 100

        for (int i = 0; i < arr.length; i++)

            arr[i] = new Random().nextInt(numbersRange + 1);

    }

    // Print The Array Elements
    public void printArray(int[] arr) {

        System.out.print("   ");
        
        for (int i = 0; i < arr.length; i++)

            System.out.print(arr[i] + " ");

        System.out.println();

    }

    public static void main(String[] args) {

        Sort sortAlgorithms = new Sort();
        long startTime, endTime;
        int[] arr;

        // Task 1
        System.out.println("\nTask 1: Using Inseartion Sort Algorithm");
        
        System.out.println("\n   Example: Sort 5 Elements Within The Array");
        arr = new int[5];
        sortAlgorithms.fillArray(arr);
        
        System.out.println("\n   Before Sort:");
        sortAlgorithms.printArray(arr);
        
        System.out.println("\n   After Sort:");
        
        startTime = System.currentTimeMillis();
        sortAlgorithms.insertionSort(arr);
        endTime = System.currentTimeMillis();

        sortAlgorithms.printArray(arr);
        System.out.println("\n   Running Time: " + (endTime - startTime) + " ms");



        // Task 2
        System.out.println("\n\nTask 2: Using Heap Sort Algorithm");
         
        // Example 1
        System.out.println("\n   Example: Sort 10 Elements By Using Ascending Order");
        arr = new int[10];
        sortAlgorithms.fillArray(arr);
        
        System.out.println("\n   Before Sort:");
        sortAlgorithms.printArray(arr);
        
        System.out.println("\n   After Sort:");

        startTime = System.currentTimeMillis();
        sortAlgorithms.heapSort(arr, 0);
        endTime = System.currentTimeMillis();
        
        sortAlgorithms.printArray(arr);
        System.out.println("\n   Running Time: " + (endTime - startTime) + " ms");

        // Example 2
        System.out.println("\n   Example: Sort 15 Elements By Using Descending Order");
        arr = new int[15];
        sortAlgorithms.fillArray(arr);
        
        System.out.println("\n   Before Sort:");
        sortAlgorithms.printArray(arr);
        
        System.out.println("\n   After Sort:");
        startTime = System.currentTimeMillis();
        sortAlgorithms.heapSort(arr, 1);
        endTime = System.currentTimeMillis();
        
        sortAlgorithms.printArray(arr);
        System.out.println("\n   Running Time: " + (endTime - startTime) + " ms");

    }

}