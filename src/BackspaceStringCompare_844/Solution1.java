package BackspaceStringCompare_844;

/**
 * $$ Time Complexity: O(s.length() + t.length())
 * $$ Space Complexity: O(s.length() + t.length())
 */
public class Solution1 {
    public boolean backspaceCompare(String s, String t) {
        return convert(s).equals(convert(t));
    }

    private String convert(String s) {
        int end = 0;
        char[] arr = new char[s.length()];
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '#') {
                if (end > 0) {
                    end--;
                }
                continue;
            }
            arr[end] = s.charAt(i);
            end++;
        }
        return new String(arr, 0, end);
    }
}
