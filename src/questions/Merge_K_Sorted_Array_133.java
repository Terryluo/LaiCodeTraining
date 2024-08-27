import java.util.Comparator;
import java.util.PriorityQueue;

public class Merge_K_Sorted_Array_133 {
    public int[] merge(int[][] arrayOfArrays) {
        PriorityQueue<Element> minHeap = new PriorityQueue<>(new Comparator<Element>() {
            @Override
            public int compare(Element e1, Element e2) {
                return e1.val - e2.val;
            }
        });
        int length = 0;
        for (int i = 0; i < arrayOfArrays.length; i++) {
            int[] currArray = arrayOfArrays[i];
            length += currArray.length;
            if (currArray.length != 0) {
                minHeap.add(new Element(i, 0, arrayOfArrays[i][0]));
            }
        }
        int[] result = new int[length];
        int idx = 0;
        while (!minHeap.isEmpty()) {
            Element top = minHeap.poll();
            result[idx++] = top.val;
            if (top.col < arrayOfArrays[top.row].length) {
                minHeap.add(new Element(top.row, top.col + 1, arrayOfArrays[top.row][top.col]));
            }
        }
        return result;
    }

    class Element {
        int row;
        int col;
        int val;
        Element(int row, int col, int val) {
            this.row = row;
            this.col = col;
            this.val = val;
        }
    }
}
