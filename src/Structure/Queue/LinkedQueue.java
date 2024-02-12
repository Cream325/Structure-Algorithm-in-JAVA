package Structure.Queue;

import Structure.LinkedList.*;

public class LinkedQueue extends DoublyLinkedList {
    public void Enqueue(Object newData) {
        super.Append(newData);
    }

    public LinkedListNode Dequeue() {
        if(IsEmpty()) return null;
        else return super.Delete(0);
    }

    public LinkedListNode Peek() {
        if(IsEmpty()) return null;
        else return super.Search(0);
    }

    public boolean IsEmpty() {
        return (super.length == 0);
    }
}
