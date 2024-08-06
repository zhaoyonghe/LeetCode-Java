package DesignCircularQueue_622;

/**
 * $$ enQueue() Time Complexity: O(1)
 * $$ deQueue() Time Complexity: O(1)
 * $$ Front() Time Complexity: O(1)
 * $$ Rear() Time Complexity: O(1)
 * $$ isEmpty() Time Complexity: O(1)
 * $$ isFull() Time Complexity: O(1)
 * $$ Space Complexity: O(k)
 */
public class MyCircularQueue1 {
    private final int[] arr;
    private int start = 0;
    private int end = 0;

    public MyCircularQueue1(int k) {
        arr = new int[k + 1];
    }

    private int next(int i) {
        return (i + arr.length + 1) % arr.length;
    }

    private int prev(int i) {
        return (i + arr.length - 1) % arr.length;
    }

    public boolean enQueue(int value) {
        if (isFull()) {
            return false;
        }
        arr[end] = value;
        end = next(end);
        return true;
    }

    public boolean deQueue() {
        if (isEmpty()) {
            return false;
        }
        start = next(start);
        return true;
    }

    public int Front() {
        return isEmpty() ? -1 : arr[start];
    }

    public int Rear() {
        return isEmpty() ? -1 : arr[prev(end)];
    }

    public boolean isEmpty() {
        return start == end;
    }

    public boolean isFull() {
        return start == next(end);
    }
}
