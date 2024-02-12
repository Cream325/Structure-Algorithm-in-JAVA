package Structure.Queue;

import Structure.Node;

public class QueueNode extends Node {
    protected int front = 0;
    protected int rear = 0;
    protected int capacity = 0;
    protected Object[] array;

    public QueueNode(int capacity) {
        this.capacity = capacity;
        array = new Object[capacity+1];
    }

    public int GetCapacity() { return capacity; }
}