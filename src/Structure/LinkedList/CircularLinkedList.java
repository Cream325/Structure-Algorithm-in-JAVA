package Structure.LinkedList;

/*
    CircularLinkedList 주요 연산)
    1. 추가 연산
      - 단일 추가
      - 전체 추가
      - 단일 삽입
      - 전체 삽입
    
    2. 검색 연산
      - 단일 검색
      - 전체 검색
      - 범위 검색
    
    3. 삭제 연산
      - 단일 삭제
      - 범위 삭제
      
    4. 출력 연산
      - 순회
      - 범위 출력
 */

public class CircularLinkedList extends LinkedListNode {
    LinkedListNode headNode;
    LinkedListNode tailNode;

    public CircularLinkedList() {
        this.headNode = null;
        this.tailNode = null;
    }



    /** *원형 링크드 리스트 - 단일추가 연산 */
    public void Append(Object newData) {
        LinkedListNode newNode = new LinkedListNode(newData);

        if(headNode == null) {
            headNode = newNode;
            tailNode = headNode;
        }
        else {
            tailNode.nextNode = newNode;
            newNode.previousNode = tailNode;
            tailNode = tailNode.nextNode;
        }

        headNode.previousNode = tailNode;
        headNode.nextNode = headNode;

        super.length++;
    }

    /** 원형 링크드 리스트 - 전체추가 연산 */
    public void AppendAll(Object[] newDatas) {
        LinkedListNode[] newNodes = new LinkedListNode[newDatas.length];

        for(int i = 0; i < newDatas.length; i++) {
            newNodes[i] = new LinkedListNode(newDatas[i]);
        }

        for(int j = 0; j < newNodes.length; j++) {
            if(headNode == null) {
                headNode = newNodes[0];
                tailNode = headNode;
            }
            else {
                tailNode.nextNode = newNodes[j];
                newNodes[j].previousNode = tailNode;
                tailNode = tailNode.nextNode;
            }
        }

        headNode.previousNode = tailNode;
        tailNode.nextNode = headNode;

        super.length += newDatas.length;
    }

    private void AppendAll(LinkedListNode[] newNodes) {
        for(int j = 0; j < newNodes.length; j++) {
            if(headNode == null) {
                headNode = newNodes[0];
                tailNode = headNode;
            }
            else {
                tailNode.nextNode = newNodes[j];
                newNodes[j].previousNode = tailNode;
                tailNode = tailNode.nextNode;
            }
        }

        headNode.previousNode = tailNode;
        tailNode.nextNode = headNode;

        super.length += newNodes.length;
    }

    /** 원형 링크드 리스트 - 단일삽입 연산 */
    public void Insert(Object newData, int index) {
        LinkedListNode newNode = new LinkedListNode(newData);
        LinkedListNode current = Search(index);

        if(headNode == null || index >= super.length) {
            Append(newData);
            return;
        }

        else {
            newNode.nextNode = current;

            if(index == 0) {
                current.previousNode = newNode;
                headNode = newNode;
            }
            else {
                current.previousNode.nextNode = newNode;
                newNode.previousNode = current.previousNode;
                current.previousNode = newNode;
            }
        }

        headNode.previousNode = tailNode;
        tailNode.nextNode = headNode;

        super.length++;
    }

    /** 원형 링크드 리스트 - 전체삽입 연산 */
    public void InsertAll(Object[] newDatas, int index) {
        LinkedListNode[] newNodes = new LinkedListNode[newDatas.length];
        LinkedListNode current = Search(index);

        for(int i = 0; i < newDatas.length; i++) {
            newNodes[i] = new LinkedListNode(newDatas[i]);
        }

        if(headNode == null || index >= super.length) {
            AppendAll(newNodes);
            return;
        }

        else {
            for(int j = 0; j < newDatas.length; j++) {
                newNodes[j].nextNode = current;

                if(index == 0 && headNode != newNodes[0]) {
                    current.previousNode = newNodes[0];
                    headNode = newNodes[0];
                }
                else {
                    current.previousNode.nextNode = newNodes[j];
                    newNodes[j].previousNode = current.previousNode;
                    current.previousNode = newNodes[j];
                }
            }
        }

        headNode.previousNode = tailNode;
        tailNode.nextNode = headNode;

        super.length += newDatas.length;
    }



    /** *원형 링크드 리스트 - 단일검색 연산 */
    public LinkedListNode Search(int index) {
        LinkedListNode current = (index <= (super.length / 2)) ? headNode : tailNode;

        if(current == headNode) {
            while((--index) >= 0) {
                current = current.nextNode;
            }
        }
        else {
            while((++index) <= (super.length - 1)) {
                current = current.previousNode;
            }
        }

        return current;
    }

    /** 원형 링크드 리스트 - 전체검색 연산 */
    public LinkedListNode[] SearchAll() {
        LinkedListNode[] result = new LinkedListNode[super.length];
        LinkedListNode current = headNode;
        int i = 0;

        do {
            result[i++] = current;
            current = current.nextNode;
        } while(current != headNode);

        return result;
    }

    /** 원형 링크드 리스트 - 범위검색 연산 */
    public LinkedListNode[] SearchRange(int startIndex, int endIndex) {
        endIndex = Math.min(endIndex, (super.length - 1));
        LinkedListNode[] result = new LinkedListNode[(endIndex - startIndex) + 1];
        LinkedListNode current = Search(startIndex);
        int i = 0;

        while((current != null) && (--endIndex) >= (startIndex - 1)) {
            result[i++] = current;
            current = current.nextNode;
        }

        return result;
    }



    /** *원형 링크드 리스트 - 단일삭제 연산 */
    public LinkedListNode Delete(int index) {
        LinkedListNode removed = null;
        LinkedListNode current = Search(index - 1);

        if(index == 0) {
            headNode = current.nextNode;

            removed = current;
            current = null;

            if(super.length == 1) {
                headNode = null;
                tailNode = null;
            }
            else {
                headNode.previousNode = tailNode;
                tailNode.nextNode = headNode;
            }
        }
        else {
            LinkedListNode temp = current.nextNode;

            temp.previousNode.nextNode = temp.nextNode;
            temp.nextNode.previousNode = temp.previousNode;

            removed = temp;
            temp = null;
        }

        super.length--;
        return removed;
    }

    /** 더블 링크드 리스트 - 범위삭제 연산 */
    public LinkedListNode[] DeleteRange(int startIndex, int endIndex) {
        endIndex = Math.min(endIndex, (super.length - 1));
        LinkedListNode[] deleted = SearchRange(startIndex, endIndex);
        LinkedListNode startNode = Search(startIndex - 1);
        LinkedListNode endNode = Search(endIndex - 1);

        if(startIndex == 0) {
            headNode = (endNode != null ? endNode.nextNode : null);
        }
        else {
            LinkedListNode temp = (endNode != null ? endNode.nextNode : null);
            startNode.nextNode = (temp != null ? temp.nextNode : null);

            if(temp != null && temp.nextNode != null) {
                temp.nextNode.previousNode = endNode;
            }
        }

        super.length -= deleted.length;
        return deleted;
    }


    /** *원형 링크드 리스트 - 순회 연산 */
    public void Traversal() {
        LinkedListNode current = headNode;

        if(headNode == null) return;

        do {
            System.out.print(current.GetData() + " ");
            current = current.nextNode;
        } while(current != headNode);
    }

    /** 원형 링크드 리스트 - 범위출력 연산 */
    public void printRange(LinkedListNode[] nodes) {
        int i = 0;

        while(nodes != null && i < nodes.length) {
            System.out.print(nodes[i++].GetData() + " ");
        }
    }
}
