package A;

import java.util.*;

public class S {
    public static class Node {
        public Node zero;
        public Node one;
        public int index;

        public Node(int index) {
            this.index = index;
        }
    }

    public static void cal(String s) {
        int n = s.length();

        int[] arr = new int[n];

        int len = 0, i = 1;
        while (i < n) {
            if (s.charAt(i) == s.charAt(len)) {
                arr[i] = len + 1;
                len++;
                i++;
            } else {
                if (len > 0) {
                    len = arr[len - 1];
                } else {
                    arr[i] = len;
                    i++;
                }
            }
        }

        for (int k = 0; k < n; k++) {
            System.out.printf("%d ", arr[k]);
        }
        System.out.println("");
    }

    public static void main(String[] args) {

        int[] a = new int[4];


        cal("ababcabaa");
        cal("aaaaaaaaaaaa");
        cal("asfdasfewf");


    }
}
