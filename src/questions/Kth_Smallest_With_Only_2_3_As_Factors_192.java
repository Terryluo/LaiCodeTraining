import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.Set;

/*
Find the Kth smallest number s such that s = 2 ^ x * 3 ^ y, x >= 0 and y >= 0, x and y are all integers.

Assumptions

K >= 1
Examples

the smallest is 1
the 2nd smallest is 2
the 3rd smallest is 3
the 5th smallest is 2 * 3 = 6
the 6th smallest is 2 ^ 3 * 3 ^ 0 = 8
 */
public class Kth_Smallest_With_Only_2_3_As_Factors_192 {
    public int kth(int k) {
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        Set<Integer> record = new HashSet<>();
        minHeap.offer(1);
        record.add(1);
        for (int i = 1; i < k; i++) {
            int top = minHeap.poll();
            int twoFactor = top * 2;
            int threeFactor = top * 3;
            if (!record.contains(twoFactor)) {
                minHeap.offer(twoFactor);
                record.add(twoFactor);
            }
            if (!record.contains(threeFactor)) {
                minHeap.offer(threeFactor);
                record.add(threeFactor);
            }
        }
        return minHeap.peek();
    }
}
