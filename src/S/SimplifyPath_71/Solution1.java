package S.SimplifyPath_71;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Iterator;

/**
 * $$ Assume n is path.length().
 * $$ Time Complexity: O(n)
 * $$ Space Complexity: O(n)
 */
public class Solution1 {
    // Important constraints:
// 1. path is a valid absolute Unix path starting with '/'.
    public String simplifyPath(String path) {
        Deque<String> st = new ArrayDeque<>();
        String[] ss = path.split("/");
        for (String s : ss) {
            if (s.equals("") || s.equals(".")) {
                continue;
            }
            if (s.equals("..")) {
                if (!st.isEmpty()) {
                    st.pop();
                }
                continue;
            }
            st.push(s);
        }
        StringBuilder sb = new StringBuilder();
        Iterator<String> it = st.descendingIterator();
        while (it.hasNext()) {
            sb.append("/").append(it.next());
        }
        String res = sb.toString();
        if (res.equals("")) {
            return "/";
        }
        return res;
    }
}