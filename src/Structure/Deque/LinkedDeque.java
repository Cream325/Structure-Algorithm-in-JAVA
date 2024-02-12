package Structure.Deque;

import Structure.LinkedList.*;

public class LinkedDeque extends DoublyLinkedList {

    public void PushFront(Object newData) {
        super.Insert(newData, 0);
    }

    public void PushBack(Object newData) {
        super.Append(newData);
    }

    public LinkedListNode PopFront() {
        if(IsEmpty()) return null;
        else return super.Delete(0);
    }

    public LinkedListNode PopBack() {
        if(IsEmpty()) return null;
        else return super.Delete(super.length - 1);
    }

    public LinkedListNode Front() {
        if(IsEmpty()) return null;
        else return super.Search(0);
    }

    public LinkedListNode Back() {
        if(IsEmpty()) return null;
        else return super.Search(super.length - 1);
    }

    public boolean IsEmpty() {
        return (super.length == 0);
    }
}
