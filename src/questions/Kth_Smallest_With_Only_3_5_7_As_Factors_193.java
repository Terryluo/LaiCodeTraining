import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.Set;

/*
Find the Kth smallest number s such that s = 3 ^ x * 5 ^ y * 7 ^ z, x > 0 and y > 0 and z > 0, x, y, z are all integers.

Assumptions

K >= 1
Examples

the smallest is 3 * 5 * 7 = 105
the 2nd smallest is 3 ^ 2 * 5 * 7 = 315
the 3rd smallest is 3 * 5 ^ 2 * 7 = 525
the 5th smallest is 3 ^ 3 * 5 * 7 = 945
 */
public class Kth_Smallest_With_Only_3_5_7_As_Factors_193 {
    public long kth(int k) {
        PriorityQueue<Long> pq = new PriorityQueue<>();
        Set<Long> hashset = new HashSet<>();
        pq.offer(3L * 5 * 7);
        hashset.add(3L * 5 * 7);
        for (int i = 1; i < k; i++) {
            long top = pq.poll();// poll out k - 1 time, then the top will be kth smallest
            long threeFactor = top * 3;
            long fiveFactor = top * 5;
            long sevenFactor = top * 7;
            if (!hashset.contains(threeFactor)) {
                pq.offer(threeFactor);
                hashset.add(threeFactor);
            }
            if (!hashset.contains(fiveFactor)) {
                pq.offer(fiveFactor);
                hashset.add(fiveFactor);
            }
            if (!hashset.contains(sevenFactor)) {
                pq.offer(sevenFactor);
                hashset.add(sevenFactor);
            }
        }
        return pq.peek();
    }
}
// TC: klogk
// SC: k
