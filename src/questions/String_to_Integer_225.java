import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/*
Implement atoi to convert a string to an integer. Hint: Carefully consider all possible input cases. If you want a challenge, please do not see below and ask yourself what are the possible input cases. Notes: It is intended for this problem to be specified vaguely (ie, no given input specs). You are responsible to gather all the input requirements up front.

The function first discards as many whitespace characters as necessary until the first non-whitespace character is found. Then, starting from this character, takes an optional initial plus or minus sign followed by as many numerical digits as possible, and interprets them as a numerical value.

The string can contain additional characters after those that form the integral number, which are ignored and have no effect on the behavior of this function.

If the first sequence of non-whitespace characters in str is not a valid integral number, or if no such sequence exists because either str is empty or it contains only whitespace characters, no conversion is performed.

If no valid conversion could be performed, a zero value is returned. If the correct value is out of the range of representable values, return INT_MAX (2147483647) if it is positive, or INT_MIN (-2147483648) if it is negative.
 */
public class String_to_Integer_225 {
    Set<Character> signAndNumber = new HashSet<>(Arrays.asList('0','1','2','3','4','5','6','7','8','9'));
    public int atoi(String str) {
        // trim the string only contains sign and number
        String s = trim(str.trim());
        // read the string
        // if it is a number, put number
        // if it is not a number return 0
        // if it is out of bound return INT_MAX or INT_MIN
        long result = Long.valueOf(s);
        if (result < Integer.MIN_VALUE) {
            return Integer.MIN_VALUE;
        } else if (result > Integer.MAX_VALUE) {
            return Integer.MAX_VALUE;
        }
        return Integer.valueOf(s);
    }
    private String trim(String s) {
        char[] c = s.toCharArray();
        int scan = 0;
        int end = 0;
        boolean start = false;
        while (scan < c.length) {
            if (!start) {
                if (!signAndNumber.contains(c[scan]) && c[scan] != '+' && c[scan] != '-') {
                    return "0";
                } else if (c[scan] == '0') {
                    return "0";
                }
                swap(c, scan, end);
                scan++;
                end++;
                start = true;
                continue;
            }
            if (signAndNumber.contains(c[scan])) {
                swap(c, scan, end);
                scan++;
                end++;
            } else {
                if (c[scan - 1] == '+' || c[scan - 1] == '-') {
                    return "0";
                }
                return new String(c, 0, end);
            }
        }
        return new String(c, 0, end);
    }
    private void swap(char[] c, int a, int b) {
        char temp = c[a];
        c[a] = c[b];
        c[b] = temp;
    }
}
