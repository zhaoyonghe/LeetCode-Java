package LFUCache_460;

/**
 * Constructor Time Complexity: O(1)
 * get() Time Complexity: O(1)
 * put() Time Complexity: O(1)
 * Space Complexity: O(capacity)
 * Runtime: 48ms
 * Rank: 92.62%
 */
import java.util.*;

public class LFUCache {
    private class Node {
        int key;
        int value;
        int freq;
        Node prev;
        Node next;
        public Node() {

        }
        public Node(int key, int value, int freq) {
            this.key = key;
            this.value = value;
            this.freq = freq;
        }
    }

    private int minFreq;
    private HashMap<Integer, Node> track = new HashMap<>();
    private HashMap<Integer, Node> freq = new HashMap<>();
    private int capacity;

    public LFUCache(int capacity) {
        this.capacity = capacity;
    }

    public int get(int key) {
        if (!track.containsKey(key)) {
            return -1;
        }
        Node node = track.get(key);
        promoteNode(node);
        return node.value;
    }

    private void promoteNode(Node node) {
        removeNodeFromLinkedList(node);
        if (isEmptyFreqList(node.freq) && node.freq == minFreq) {
            minFreq++;
        }
        node.freq++;
        offer(getFreqList(node.freq), node);
    }

    private void offer(Node head, Node node) {
        node.prev = head;
        node.next = head.next;
        node.prev.next = node;
        node.next.prev = node;
    }

    private Node poll(Node head) {
        Node toRemove = head.prev.prev;
        removeNodeFromLinkedList(toRemove);
        return toRemove;
    }

    private void removeNodeFromLinkedList(Node node) {
        node.prev.next = node.next;
        node.next.prev = node.prev;
        node.prev = null;
        node.next = null;
    }

    private boolean isEmptyFreqList(int f) {
        if (!freq.containsKey(f)) {
            return true;
        }
        Node head = freq.get(f);
        return head.next.next == head;
    }

    private Node getFreqList(int f) {
        if (freq.containsKey(f)) {
            return freq.get(f);
        }
        Node head = new Node();
        Node tail = new Node();
        head.prev = tail;
        head.next = tail;
        tail.prev = head;
        tail.next = head;
        freq.put(f, head);
        return head;
    }


    public void put(int key, int value) {
        if (capacity == 0) {
            return;
        }
        if (track.containsKey(key)) {
            Node node = track.get(key);
            node.value = value;
            promoteNode(node);
            return;
        }
        if (track.size() == capacity) {
            // Remove the least frequently used.
            Node head = freq.get(minFreq);
            track.remove(poll(head).key);
        }
        Node node = new Node(key, value, 1);
        track.put(key, node);
        offer(getFreqList(1), node);
        minFreq = 1;
    }
}