package Structure.LinkedList;

public class SinglyLinkedList extends LinkedListNode {
    LinkedListNode headNode = null;
    LinkedListNode tailNode = null;

    
    
    /** 싱글 링크드 리스트 - 단일추가 연산 */
    public void Append(Object newData) {
        LinkedListNode newNode = new LinkedListNode(newData);

        if(headNode == null) {
            headNode = newNode;
            tailNode = headNode;
        }
        else {
            tailNode.nextNode = newNode;
            tailNode = tailNode.nextNode;
        }

        super.length++;
    }

    /** 싱글 링크드 리스트 - 전체추가 연산 */
    public void AppendAll(Object[] newDatas) {
        LinkedListNode[] newNodes = new LinkedListNode[newDatas.length];
        int j;

        for(int i = 0; i < newDatas.length; i++) newNodes[i] = new LinkedListNode(newDatas[i]);

        if(headNode == null) headNode = newNodes[0];

        if(headNode != null) {
            tailNode = headNode;
            for(j = 1; j < newDatas.length; j++) {
                tailNode.nextNode = newNodes[j];
                tailNode = tailNode.nextNode;
            }
        }

        super.length += newDatas.length;
    }

    /** *싱글 링크드 리스트 - 단일삽입 연산 */
    public void Insert(Object newData, int index) {
        LinkedListNode newNode = new LinkedListNode(newData);
        LinkedListNode current = Search(index - 1);

        if(headNode == null) {
            Append(newData);
            return;
        }
        else if(index == 0) {
            newNode.nextNode = current;
            headNode = newNode;
        }
        else {
            newNode.nextNode = current.nextNode;
            current.nextNode = newNode;
        }

        super.length++;
    }



    /** *싱글 링크드 리스트 - 단일검색 연산 */
    public LinkedListNode Search(int index) {
        LinkedListNode current = headNode;

        while((current != null) && (--index) >= 0) current = current.nextNode;

        return current;
    }

    /** 싱글 링크드 리스트 - 전체검색 연산 */
    public Object[] SearchAll() {
        int i = 0;
        Object[] result = new Object[super.length];
        LinkedListNode current = headNode;

        while(current.nextNode != null) {
            result[i] = current.GetData();

            current = current.nextNode;
            i++;
        }

        return result;
    }



    /** *싱글 링크드 리스트 - 삭제 연산 */
    public LinkedListNode Delete(int index) {
        LinkedListNode removed = null;
        LinkedListNode current = Search(index - 1);

        if(index == 0) {
            headNode = current.nextNode;

            removed = current;
            current = null;
        }
        else {
            LinkedListNode temp = current.nextNode;
            current.nextNode = temp.nextNode;

            removed = temp;
            temp = null;
        }

        super.length--;
        return removed;
    }



    /** *싱글 링크드 리스트 - 출력 연산 */
    public void Traversal() {
        LinkedListNode current = headNode;

        while(current != null) {
            System.out.print(current.GetData() + " ");
            current = current.nextNode;
        }
    }
}