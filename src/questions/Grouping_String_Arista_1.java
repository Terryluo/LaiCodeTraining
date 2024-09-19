/*
Given S="0 - 221985 -- 324"
the function should return "0221985324"
将String分组优先一组三个或两个字符优先三个
* */
public class Grouping_String_Arista_1 {
    public String groupingString(String input) {
        if (input == null || input.length() <= 3) {
            return input;
        }
        int length = 0;
        char[] charInput= input.trim().toCharArray();
        for (char c : charInput) {
            if (c >= '0' && c <= '9') {
                length++;
            }
        }
        StringBuilder sb = new StringBuilder();
        int count = 0;
        for (char c : charInput) {
            if (c >= '0' && c <= '9') {
                if (length == 0) {
                    break;
                }
                sb.append(c);
                count++;
                length--;
                if ((count == 2 && length < 3) || (count == 3)) {
                    sb.append(' ');
                    count = 0;
                }
            }
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        Grouping_String_Arista_1 gsa = new Grouping_String_Arista_1();
        String s = "        0 - 221985 -- 324 ";
        System.out.println(gsa.groupingString(s));
    }
}
