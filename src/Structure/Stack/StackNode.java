package Structure.Stack;

import Structure.Node;

public class StackNode extends Node {
    int top = -1;
    int capacity;
    Object[] array;

    public StackNode(int capacity) {
        this.capacity = capacity;
        array = new Object[capacity];
    }

    public int GetCapacity() { return capacity; }
}