package Structure.Stack;

import Structure.LinkedList.*;

/*
    연결 리스트 기반 Stack 주요 연산)
    1. 추가 연산
      - 단일 추가
      - 전체 추가

    2. 검색 연산
      - 단일 검색

    3. 삭제 연산
      - 단일 삭제
      - 전체 삭제
 */

public class LinkedListStack extends DoublyLinkedList {



    /** *연결 리스트 기반 스택 - 단일추가 연산 */
    public void Push(Object newData) {
        super.Append(newData);
    }

    /** 연결 리스트 기반 스택 - 전체추가 연산 */
    public void PushAll(Object[] newDatas) {
        super.AppendAll(newDatas);
    }



    /** *연결 리스트 기반 스택 - 단일검색 연산 */
    public Object Peek() {
        if(!IsEmpty()) {
            return super.Search(super.length - 1).GetData();
        }
        else {
            return null;
        }
    }



    /** *연결 리스트 기반 스택 - 단일삭제 연산 */
    public LinkedListNode Pop() {
        if(!IsEmpty()) {
            return super.Delete(super.length - 1);
        }
        else {
            return null;
        }
    }

    /** 연결 리스트 기반 스택 - 전체삭제 연산 */
    public Object[] PopAll() {
        if(!IsEmpty()) {
            LinkedListNode[] poppedListNodes = super.DeleteRange(0, super.length - 1);
            Object[] result = new Object[poppedListNodes.length];

            for(int i = 0; i < poppedListNodes.length; i++) {
                result[i] = poppedListNodes[i].GetData();
            }

            return result;
        }
        else {
            return null;
        }
    }



    public boolean IsEmpty() {
        return (super.length == 0);
    }
}
