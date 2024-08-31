/*
Given a binary min heap in array format. Update the element at a specified index.

Assumptions:

The given array is not null or empty.
The specified index is guaranteed to be within the range.
Examples:

array = {1, 2, 3, 4}, update the element at index 1 to 5, the array becomes {1, 4, 3, 5}
 */
public class Heap_Update_Operation_367 {
    public int[] updateHeap(int[] array, int index, int ele) {
        array[index] = ele;
        if (index != 0 && array[index] < array[parent(index)]) {
            percolateUp(array, index);
        } else {
            percolateDown(array, index);
        }
        return array;
    }
    private int parent(int index) {
        return (index - 1) / 2;
    }
    private int leftChild(int index) {
        return index * 2 + 1;
    }
    private int rightChild(int index) {
        return index * 2 + 2;
    }
    private void percolateUp(int[] array, int index) {
        while (index != 0 && array[index] < array[parent(index)]) {
            swap(array, index, parent(index));
            index = parent(index);
        }
    }
    private void percolateDown(int[] array, int index) {
        int leftChild = leftChild(index) < array.length ? leftChild(index) : -1;
        int rightChild = rightChild(index) < array.length ? rightChild(index) : -1;
        int compareCandidate = -1;
        if (leftChild != -1 && rightChild != -1) {
            compareCandidate = array[leftChild] < array[rightChild] ? leftChild : rightChild;
        } else if (leftChild != -1 && rightChild == -1) {
            compareCandidate = leftChild;
        }
        if (compareCandidate != -1 && array[index] > array[compareCandidate]) {
            swap(array, index, compareCandidate);
            index = compareCandidate;
            percolateDown(array, index);
        }
        return;
    }
    private void swap(int[] array, int a, int b) {
        int temp = array[a];
        array[a] = array[b];
        array[b] = temp;
    }
}
