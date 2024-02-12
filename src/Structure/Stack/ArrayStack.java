package Structure.Stack;

/*
    배열 기반 Stack 주요 연산)
    1. 추가 연산
      - 단일 추가
      - 전체 추가

    2. 검색 연산
      - 단일 검색

    3. 삭제 연산
      - 단일 삭제
      - 전체 삭제
 */

public class ArrayStack extends StackNode {
    public ArrayStack(int capacity) {
        super(capacity);
    }



    /** *배열 기반 스택 - 단일추가 연산 */
    public void Push(Object newData) {
        if(!IsFull()) {
            super.array[++super.top] = newData;
        }
        else {
            throw new ArrayIndexOutOfBoundsException();
        }
    }

    /** 배열 기반 스택 - 전체추가 연산 */
    public void PushAll(Object[] newDatas) {
        for(int i = 0; i < newDatas.length; i++) {
            if(!IsFull()) {
                super.array[++super.top] = newDatas[i];
            }
            else {
                throw new ArrayIndexOutOfBoundsException();
            }
        }
    }



    /** *배열 기반 스택 - 단일검색 연산 */
    public Object Peek() {
        if(!IsEmpty()) {
            return super.array[super.top];
        }
        else {
            return null;
        }
    }



    /** *배열 기반 스택 - 단일삭제 연산 */
    public Object Pop() {
        if(!IsEmpty()) {
            return super.array[super.top--];
        }
        else {
            return null;
        }
    }

    /** 배열 기반 스택 - 전체삭제 연산 */
    public Object[] PopAll() {
        if(!IsEmpty()) {
            Object[] result = super.array;
            super.top = -1;
            return result;
        }
        else {
            return null;
        }
    }



    public boolean IsEmpty() {
        return (super.top == -1);
    }

    public boolean IsFull() {
        return (super.top > super.capacity);
    }
}
