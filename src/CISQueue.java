import java.util.Arrays;

public class CISQueue {

    // Array property.
    private Integer[] queue;

    // Size property.
    private int size;

    // Index pointer. Indicates the index of the most recently added element.
    private int pointer;

    // Constructor.
    public CISQueue(int capacity) {
        queue = new Integer[capacity];
        size = 0;
        pointer = -1;
    }

    // Enqueue. This method adds a node to the end of the linked list.
    public void enqueue(int value) {
        if (pointer + 1 < queue.length) {
            pointer++;
            queue[pointer] = value;
            size++;
        } else {
            throw new IllegalStateException("Queue is full");
        }
    }

    // Dequeue. This method removes a node from the beginning of the linked list.
    public Integer dequeue() {
        if (isEmpty()) {
            return null;
        }
        int value = queue[0];
        reshuffle();
        pointer--;
        size--;
        return value;
    }

    // isEmpty. Returns a boolean indicating whether the linked list is empty.
    public boolean isEmpty() {
        return size == 0;
    }

    // size. Returns the size of the queue.
    public int size() {
        return size;
    }

    // reshuffle. Moves each element down one index. Called whenever we dequeue.
    private void reshuffle() {
        for (int i = 0; i < pointer; i++) {
            queue[i] = queue[i + 1];
        }
        queue[pointer] = null;
    }
    // toString. Returns a description of the queue in, for example, the following format:
    // CISQueue{queue=[7, 11], size=2, pointer=1}
    @Override
    public String toString() {
        return "CISQueue{queue=" + Arrays.toString(queue) + ", size=" + size + ", pointer=" + pointer + "}";
    }
}