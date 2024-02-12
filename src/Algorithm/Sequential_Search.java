package Algorithm;

import Structure.LinkedList.*;

public class Sequential_Search {
    /** 탐색 - 순차탐색 */
    public LinkedListNode sequentialSearch(LinkedListNode head, Object target) {
        LinkedListNode current = head;
        LinkedListNode match = null;

        while(current != null) {
            if(current.GetData() == target) {
                match = current;
                break;
            }
            else {
                current = current.GetNextNode();
            }
        }

        return match;
    }



    /** 순차탐색 - 전진 이동법 */
    public LinkedListNode moveToFront(LinkedListNode head, Object target) {
        LinkedListNode current = head;
        LinkedListNode previous = null;
        LinkedListNode match = null;

        while(current != null) {
            if(current.GetData() == target) {
                match = current;
                if(previous != null) {
                    previous.SetNextNode(current.GetNextNode());
                    current.SetNextNode(head);
                    head = current;
                }
                break;
            }
            else {
                previous = current;
                current = current.GetNextNode();
            }
        }
        return match;
    }



    /** 순차탐색 - 전위법 */
    public LinkedListNode transpose(LinkedListNode head, Object target) {
        LinkedListNode current = head;
        LinkedListNode pprevious = null;
        LinkedListNode previous = null;
        LinkedListNode match = null;

        while(current != null) {
            if(current.GetData() == target) {
                match = current;
                if(previous != null) {
                    if(pprevious != null) pprevious.SetNextNode(current);
                    else head = current;
                    previous.SetNextNode(current.GetNextNode());
                    current.SetNextNode(previous);
                }
                break;
            }
            else {
                if(previous != null) pprevious = previous;
                previous = current;
                current = current.GetNextNode();
            }
        }
        return match;
    }



    /* 순차탐색 - 계수법 */
}