package Structure.LinkedList;

import Structure.Node;

public class LinkedListNode extends Node {
    LinkedListNode nextNode;
    LinkedListNode previousNode;
    protected int length = 0;

    public LinkedListNode() {
        super.SetData(null);
    }
    public LinkedListNode(Object data) {
        super.SetData(data);
    }
    public int Length() { return length; }



    // 검색용 Property
    public  void SetNextNode(LinkedListNode nextNode) { this.nextNode = nextNode; }
    public LinkedListNode GetNextNode() { return nextNode; }
}