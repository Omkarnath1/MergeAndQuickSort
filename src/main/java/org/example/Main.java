package org.example;




public class Main {
    public static void main(String[] args) {
        int[] array1 = {1, 9, 2, 7, 8, 3, 4, 9};

        // Merge Sort
        int mergeSortInversions = mergeSort(array1);
        System.out.println("After Merge Sort:");
        printArray(array1);
        System.out.println("Inversions: " + mergeSortInversions);

        int[] array2 = {1, 9, 2, 7, 8, 3, 4, 9};
        // Quick Sort
        quickSort(array2);
        System.out.println("After Quick Sort:");
        printArray(array2);
    }

    private static void printArray(int[] array) {
        for (int num : array) {
            System.out.print(num + " ");
        }
        System.out.println();
    }
    // Merge Sort Algorithm
    public static int mergeSort(int[] array) {
        return mergeSortHelper(array, 0, array.length - 1);
    }

    private static int mergeSortHelper(int[] array, int start, int end) {
        if (start == end) return 0;

        int count = 0;
        int mid = (start + end) / 2;
        count += mergeSortHelper(array, start, mid);
        count += mergeSortHelper(array, mid + 1, end);
        count += merge(array, start, mid, end);
        return count;
    }

    private static int merge(int[] array, int start, int mid, int end) {
        int[] tempArray = new int[end - start + 1];
        int count = 0;
        int i = 0;
        int left = start;
        int right = mid + 1;

        while (left <= mid && right <= end) {
            if (array[left] <= array[right]) {
                tempArray[i++] = array[left++];
            } else {
                tempArray[i++] = array[right++];
                count += mid - left + 1;
            }
        }

        while (left <= mid) {
            tempArray[i++] = array[left++];
        }
        while (right <= end) {
            tempArray[i++] = array[right++];
        }

        System.arraycopy(tempArray, 0, array, start, tempArray.length);
        return count;
    }

    // Quick Sort Algorithm
    public static void quickSort(int[] array) {
        quickSortHelper(array, 0, array.length - 1);
    }

    private static void quickSortHelper(int[] array, int start, int end) {
        if (end > start) {
            int pivotIndex = partition(array, start, end);
            quickSortHelper(array, start, pivotIndex - 1);
            quickSortHelper(array, pivotIndex + 1, end);
        }
    }

    private static int partition(int[] array, int start, int end) {
        int pivot = array[start];
        int low = start;
        int high = end;

        while (low < high) {
            while (low <= end && array[low] <= pivot) {
                low++;
            }
            while (high >= start && array[high] > pivot) {
                high--;
            }
            if (low < high) {
                int temp = array[low];
                array[low] = array[high];
                array[high] = temp;
            }
        }

        array[start] = array[high];
        array[high] = pivot;

        return high;
    }
}
