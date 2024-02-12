package Structure.Tree.BinaryTree.Heap;

import Structure.Node;

public class HeapNode extends Node {
    protected int capacity = 0;
    protected int usedSize = 0;
    protected Object[] array;

    public HeapNode(int capacity) {
        this.capacity = capacity;
        array = new Object[capacity + 1];

        System.out.println("Heap Size: " + this.capacity);
    }

    public int GetCapacity() { return capacity; }
}
