package DesignCircularDeque_641;

/**
 * $$ insertFront() Time Complexity: O(1)
 * $$ insertLast() Time Complexity: O(1)
 * $$ deleteFront() Time Complexity: O(1)
 * $$ deleteLast() Time Complexity: O(1)
 * $$ getFront() Time Complexity: O(1)
 * $$ getRear() Time Complexity: O(1)
 * $$ isEmpty() Time Complexity: O(1)
 * $$ isFull() Time Complexity: O(1)
 * $$ Space Complexity: O(k)
 */
class MyCircularDeque1 {

    private int[] arr;
    private int start = 0;
    private int end = 0;

    private int next(int i) {
        return (i + arr.length + 1) % arr.length;
    }

    private int prev(int i) {
        return (i + arr.length - 1) % arr.length;
    }

    public MyCircularDeque1(int k) {
        arr = new int[k+1];
    }

    public boolean insertFront(int value) {
        if (isFull()) {
            return false;
        }
        start = prev(start);
        arr[start] = value;
        return true;
    }

    public boolean insertLast(int value) {
        if (isFull()) {
            return false;
        }
        arr[end] = value;
        end = next(end);
        return true;
    }

    public boolean deleteFront() {
        if (isEmpty()) {
            return false;
        }
        start = next(start);
        return true;
    }

    public boolean deleteLast() {
        if (isEmpty()) {
            return false;
        }
        end = prev(end);
        return true;
    }

    public int getFront() {
        return isEmpty() ? -1 : arr[start];
    }

    public int getRear() {
        return isEmpty() ? -1 : arr[prev(end)];
    }

    public boolean isEmpty() {
        return start == end;
    }

    public boolean isFull() {
        return start == next(end);
    }
}
