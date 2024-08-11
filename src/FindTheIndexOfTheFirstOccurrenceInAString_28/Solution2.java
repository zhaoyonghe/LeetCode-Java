package FindTheIndexOfTheFirstOccurrenceInAString_28;


import java.util.HashMap;

/**
 * $$ Assume the length of haystack is n, the length of needle is m.
 * $$ Time Complexity: O(3n)
 * $$ Space Complexity: O(m)
 */

public class Solution2 {
    public int strStr(String haystack, String needle) {
        int n = haystack.length();
        int m = needle.length();

        // key: char in needle.
        // value: last index of this char in needle.
        HashMap<Character, Integer> indexMap = new HashMap<>();
        for (int i = 0; i < m; i++) {
            indexMap.put(needle.charAt(i), i);
        }

        int[] suffix = new int[m + 1];
        boolean[] prefix = new boolean[m + 1];
        generateTables(suffix, prefix, needle);

        int start = 0;
        int end = m - 1;

        while (end < n) {
            assert end - start == m - 1;
            int i = end;
            // start <= i <= end
            for (; i >= start; i--) {
                if (haystack.charAt(i) != needle.charAt(i - start)) {
                    break;
                }
            }
            // match
            if (i == start - 1) {
                return i + 1;
            } else { // start <= i <= end. Does not match. Slide backward.
                // i is the index of bad character

                // offset generated by bad character strategy.

                // case1:
                // 0123456789
                // asdfagwqagqwererr asdfagwqagqwererr
                //     qadwag               qadwag

                // case2:
                // 0123456789
                // asdfagwqagqwererr asdfagwqagqwererr
                //    aeadwag                  aeadwag

                int offset1;
                if (indexMap.containsKey(haystack.charAt(i))) {
                    // case1
                    offset1 = i - (start + indexMap.get(haystack.charAt(i)));
                } else {
                    // case2
                    offset1 = i - start + 1;
                }

                // offset generated by good suffix strategy.

                // case1:
                // 0123456789
                // asdfagwqagqwererr asdfagwqagqwererr
                //     cagwag               cagwag

                // case2:
                // 0123456789
                // asdfagwqagqwererr asdfagwqagqwererr
                //     qamwag                  qamwag

                // case3:
                // 0123456789
                // asdfagwqagqwererr asdfagwqagqwererr
                //     gamwag                 gamwag

                // speecial case, a combination of case1 and 3:
                // 0123456789
                // asdfagwqagqwererr asdfagwqagqwererr
                //    gagmwag               gagmwag
                int offset2;
                int suffixLen = end - i;
                if (suffixLen == 0) {
                    start += offset1;
                    end += offset1;
                    continue;
                }
                int finalSuffixIndex = -1;
                boolean isPrefix = false;
                int vlen = suffixLen;
                if (suffix[vlen] != -1) {
                    // have good suffix before bad character
                    finalSuffixIndex = suffix[vlen];
                    isPrefix = prefix[vlen];
                } else {
                    // do not have good suffix before bad character
                    // find the longest sub good suffix which is also a prefix of needle
                    vlen--;
                    for (; vlen >= 1; vlen--) {
                        if (prefix[vlen]) {
                            finalSuffixIndex = suffix[vlen];
                            isPrefix = prefix[vlen];
                            break;
                        }
                    }
                }

                if (finalSuffixIndex == -1) {
                    // or vlen == 0
                    offset2 = m;
                } else { // vlen >= 1
                    offset2 = end - vlen - (start + finalSuffixIndex) + 1;
                }

                start += offset1 > offset2 ? offset1 : offset2;
                end += offset1 > offset2 ? offset1 : offset2;
            }
        }
        return -1;
    }

    public void generateTables(int[] suffix, boolean[] prefix, String needle) {
        int m = needle.length();
        // initialize
        // suffix.length() == prefix.length == m + 1
        for (int i = 1; i <= m; i++) {
            suffix[i] = -1;
            prefix[i] = false;
        }
        int start = 0;
        for (int end = m - 2; end >= start; end--) {
            // i is always in the front of j
            int i = end; // At the end of substring of needle.
            int j = m - 1; // At the end of needle.
            while (i >= 0 && needle.charAt(i) == needle.charAt(j)) {
                i--;
                j--;
            }
            // needle and the substring of needle do not have same suffix
            if (i == end) {
                // i == end && j == m - 1
                continue;
            } else {
                int length = end - i;
                // We need to find the last start index of the suffix of needle,
                // so we cannot assign when suffix[length] != -1.
                if (suffix[length] == -1) {
                    suffix[length] = i + 1;
                    if (i == -1) {
                        prefix[length] = true;
                    }
                }
            }
        }
    }
}