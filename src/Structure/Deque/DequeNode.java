package Structure.Deque;

import Structure.Node;

public class DequeNode extends Node {
    protected int front = 0;
    protected int back = 0;
    protected int capacity = 0;
    protected Object[] array;

    public DequeNode(int capacity) {
        this.capacity = capacity;
        array = new Object[capacity+1];
    }

    public int GetCapacity() { return capacity; }
}