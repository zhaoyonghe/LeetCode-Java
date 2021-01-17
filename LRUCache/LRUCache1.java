package LRUCache;

/**
 * Assume the size of the cache is n.
 * Constructor Time Complexity: O(1)
 * find() Time Complexity: O(n)
 * get() Time Complexity: O(n)
 * put() Time Complexity: O(n)
 * heapify() Time Complexity: O(logn)
 * Space Complexity: O(n)
 * Runtime: 428ms
 * Rank: 8.84%
 */
public class LRUCache1 {

    private class DataChunk {
        public int key;
        public int value;
        public int time;

        public DataChunk(int key, int value, int time) {
            this.key = key;
            this.value = value;
            this.time = time;
        }
    }

    public int globalTime = Integer.MIN_VALUE;
    public DataChunk[] chunks = null;
    public int size = 0;
    public int capacity = 0;

    public LRUCache1(int capacity) {
        this.capacity = capacity;
        chunks = new DataChunk[capacity];
    }

    public int get(int key) {
        int index = find(key);
        if (index == -1) {
            return -1;
        } else {
            globalTime += 1;
            chunks[index].time = globalTime;
            int value = chunks[index].value;
            heapify(index);
            return value;
        }
    }

    public void put(int key, int value) {
        int index = find(key);
        globalTime += 1;
        if (index == -1) {
            DataChunk dataChunk = new DataChunk(key, value, globalTime);
            if (size == capacity) {
                chunks[0] = dataChunk;
                heapify(0);
            } else {
                size += 1;
                chunks[size - 1] = dataChunk;
            }
        } else {
            // update dataChunk
            chunks[index].value = value;
            chunks[index].time = globalTime;
            heapify(index);
        }
    }

    public int find(int key) {
        for (int i = 0; i < size; i++) {
            if (key == chunks[i].key) {
                return i;
            }
        }
        return -1;
    }

    public void heapify(int i) {
        int minIndex = i;
        while (i < size) {
            if (i * 2 + 1 < size && chunks[i * 2 + 1].time < chunks[minIndex].time) {
                minIndex = i * 2 + 1;
            }
            if (i * 2 + 2 < size && chunks[i * 2 + 2].time < chunks[minIndex].time) {
                minIndex = i * 2 + 2;
            }
            if (i == minIndex) {
                break;
            }
            swap(i, minIndex);
            i = minIndex;
        }
    }

    public void swap(int i, int j) {
        DataChunk dataChunk = chunks[i];
        chunks[i] = chunks[j];
        chunks[j] = dataChunk;

    }

}
