package Structure.LinkedList;

/*
    SinglyLinkedList 주요 연산)
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

public class SinglyLinkedList extends LinkedListNode {
    private LinkedListNode headNode = null;
    private LinkedListNode tailNode = null;

    
    
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

        for(int i = 0; i < newDatas.length; i++) {
            newNodes[i] = new LinkedListNode(newDatas[i]);
        }

        if(headNode == null) {
            headNode = newNodes[0];
        }

        if(headNode != null) {
            tailNode = headNode;

            for(int j = 0; j < newDatas.length; j++) {
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

        if(headNode != null) {
            if(index == 0) {
                newNode.nextNode = current;
                headNode = newNode;
            }
            else {
                newNode.nextNode = current.nextNode;
                current.nextNode = newNode;
            }

            super.length++;
        }
    }

    /** 싱글 링크드 리스트 - 전체삽입 연산 */
    public void InsertAll(Object[] newDatas, int index) {
        LinkedListNode[] newNodes = new LinkedListNode[newDatas.length];
        LinkedListNode current = Search(index);

        for(int i = 0; i < newDatas.length; i++) {
            newNodes[i] = new LinkedListNode(newDatas[i]);
        }

        if(headNode != null) {
            for(int j = 0; j < newDatas.length; j++) {
                newNodes[j].nextNode = current.nextNode;
                current.nextNode = newNodes[j];
                current = current.nextNode;
            }
        }

        super.length += newDatas.length;
    }



    /** *싱글 링크드 리스트 - 단일검색 연산 */
    public LinkedListNode Search(int index) {
        LinkedListNode current = headNode;

        while((current != null) && (--index) >= 0) {
            current = current.nextNode;
        }

        return current;
    }

    /** 싱글 링크드 리스트 - 전체검색 연산 */
    public LinkedListNode[] SearchAll() {
        LinkedListNode[] result = new LinkedListNode[super.length];
        LinkedListNode current = headNode;
        int i = 0;

        while(current != null) {
            result[i++] = current;
            current = current.nextNode;
        }

        return result;
    }

    /** 싱글 링크드 리스트 - 범위검색 연산 */
    public LinkedListNode[] SearchRange(int startIndex, int endIndex) {
        LinkedListNode[] result = new LinkedListNode[(Math.min(endIndex, (super.length - 1)) - startIndex) + 1];
        LinkedListNode current = Search(startIndex);
        int i = 0;

        while((current != null) && (--endIndex) >= (startIndex - 1)) {
            result[i++] = current;
            current = current.nextNode;
        }

        return result;
    }



    /** *싱글 링크드 리스트 - 단일삭제 연산 */
    public LinkedListNode Delete(int index) {
        LinkedListNode deleted = null;
        LinkedListNode current = Search(index - 1);

        if(index == 0) {
            headNode = current.nextNode;

            deleted = current;
        }
        else {
            LinkedListNode temp = current.nextNode;
            current.nextNode = temp.nextNode;

            deleted = temp;
        }

        super.length--;
        return deleted;
    }

    /** 싱글 링크드 리스트 - 범위삭제 연산 */
    public LinkedListNode[] DeleteRange(int startIndex, int endIndex) {
        LinkedListNode[] deleted = SearchRange(startIndex, endIndex);
        LinkedListNode startNode = Search(startIndex - 1);
        LinkedListNode endNode = Search(endIndex - 1);

        if(startIndex == 0) {
            headNode = (endNode != null ? endNode.nextNode : null);
        }
        else {
            LinkedListNode temp;
            temp = (endNode != null ? endNode.nextNode : null);
            startNode.nextNode = (temp != null ? temp.nextNode : null);
        }

        super.length -= deleted.length;
        return deleted;
    }



    /** *싱글 링크드 리스트 - 순회 연산 */
    public void Traversal() {
        LinkedListNode current = headNode;

        while(current != null) {
            System.out.print(current.GetData() + " ");
            current = current.nextNode;
        }
    }

    /** 싱글 링크트 리스트 - 범위출력 연산 */
    public void printRange(LinkedListNode[] nodes) {
        int i = 0;

        while(nodes != null && i < nodes.length) {
            System.out.print(nodes[i++].GetData() + " ");
        }
    }
}