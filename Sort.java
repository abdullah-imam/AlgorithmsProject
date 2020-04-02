import java.util.Random;

class Sort {

    static void inseartionSort(int arr[]) {
        int temp, j;

        for (int i = 1; i < arr.length; i++) {
            temp = arr[i];
            j = i - 1;

            while (j >= 0 && arr[j] < temp) {
                arr[j + 1] = arr[j];
                j--;
            }
            arr[j + 1] = temp;
        }
    }

    static void maxHeapify(int t, int arr[], int n, int i)  // here
    { 
        int largest = i;
        int l = 2*i + 1;
        int r = 2*i + 2;
  
        if (l < n && ((t == 0 && arr[l] > arr[largest]) || (t == 1 && arr[l] < arr[largest]))) // here
            largest = l; 
  
        if (r < n && ((t == 0 && arr[r] > arr[largest]) || (t == 1 && arr[r] < arr[largest])))  // here
            largest = r; 
  
        if (largest != i) 
        { 
            int swap = arr[i]; 
            arr[i] = arr[largest]; 
            arr[largest] = swap; 
  
            maxHeapify(t, arr, n, largest);  // here
        } 
    } 

    static void buildMaxHeap(int t, int[] arr) { // here
        int heapSize = arr.length;

        for (int i = (heapSize / 2) - 1; i >= 0; i--)
            maxHeapify(t, arr, heapSize, i); // here
    }

    
    static void heapSort(int t, int arr[]) // here
    { 
        int n = arr.length; 
        
        buildMaxHeap(t, arr); // here
  
         
        for (int i=n-1; i>0; i--) {
         
             
            swap(arr, i, 0);
  
           
            maxHeapify(t, arr, i, 0); // here
        } 
    }

    
    static void arrayFill(int[] arr) {
        Random random = new Random();
        for (int i = 0; i < arr.length; i++) {
            arr[i] = random.nextInt(100);
        }
    }

    
    static void swap(int arr[], int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    
    static void printArr(int[] arr) {
        for (int i =0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        int[] arr5 = new int[5];
        arrayFill(arr5);


        System.out.print("Before: ");
        printArr(arr5);

        heapSort(0, arr5); // here

        System.out.print("After (minHeap): ");
        printArr(arr5);

        heapSort(1, arr5); // here

        System.out.print("After (maxHeap): ");
        printArr(arr5);

    }
}