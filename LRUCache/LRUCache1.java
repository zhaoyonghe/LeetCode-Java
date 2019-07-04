package LRUCache;

import java.util.HashMap;
/**
 * Assume the size of the cache is n. 
 * Constructor Time Complexity: O(1) 
 * get() Time Complexity: O(1)
 * put() Time Complexity: O(1)
 * Space Complexity: O(n) 
 * Runtime: 128ms 
 * Rank: 91.23%
 */
public class LRUCache1 {
	class Node {
		public int key;
		public int value;
		public Node prev;
		public Node next;

		public Node(int key, int value) {
			this.key = key;
			this.value = value;
			this.prev = null;
			this.next = null;
		}
	}

	private HashMap<Integer, Node> map = new HashMap<>();
	private int size = 0;
	private int capacity = 0;
	private Node head = new Node(0, 0);
	private Node tail = new Node(0, 0);

	public LRUCache1(int capacity) {
		this.capacity = capacity;
		head.next = tail;
		tail.prev = head;
	}

	private void remove(Node node) {
		node.prev.next = node.next;
		node.next.prev = node.prev;
		node.prev = null;
		node.next = null;
	}

	private void addTail(Node node) {
		node.prev = tail.prev;
		node.next = tail;
		tail.prev = node;
		node.prev.next = node;
	}

	public int get(int key) {
		if (map.containsKey(key)) {
			// System.out.println(key);
			Node node = map.get(key);
			remove(node);
			addTail(node);
			return node.value;
		} else {
			return -1;
		}
	}

	public void put(int key, int value) {
		if (map.containsKey(key)) {
			Node node = map.get(key);
			node.value = value;
			remove(node);
			addTail(node);
		} else {
			Node node = new Node(key, value);
			if (size < capacity) {
				addTail(node);
				map.put(key, node);
				size += 1;
			} else {
				// size == capacity
				map.remove(head.next.key);
				remove(head.next);
				addTail(node);
				map.put(key, node);
			}
		}
	}

}
