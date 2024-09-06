/*
177. Longest Common Subsequence
Medium
Find the length of longest common subsequence of two given strings.

Assumptions

The two given strings are not null
Examples

S = “abcde”, T = “cbabdfe”, the longest common subsequence of s and t is {‘a’, ‘b’, ‘d’, ‘e’}, the length is 4.
 */
public class Longest_Common_Subsequence_177 {
    public int longest(String source, String target) {
        int[][] longest = new int[source.length() + 1][target.length() + 1];
        for (int i = 1; i <= source.length(); i++) { // should be equal because we need the last one
            for (int j = 1; j <= target.length(); j++) {
                if (source.charAt(i - 1) == target.charAt(j - 1)) {
                    longest[i][j] = longest[i - 1][j - 1] + 1;
                } else {
                    longest[i][j] = Math.max(longest[i - 1][j], longest[i][j - 1]);
                }
            }
        }
        return longest[source.length()][target.length()];
    }
}
