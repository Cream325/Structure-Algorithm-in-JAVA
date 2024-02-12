package Structure.Tree.BinaryTree.Heap;

public class ArrayHeap extends HeapNode {
    Object root;
    public ArrayHeap(int capacity) { super(capacity); }

    private int GetParent(int index) { return (int)((index - 1) / 2); }
    private int GetLeftChild(int index) { return (index * 2) + 1; }
    private Object[] ExpandArray(Object[] array, int capacity) {
        Object[] newArray = new Object[capacity];
        for(int i = 0; i < array.length; i++) newArray[i] = array[i];
        return newArray;
    }
    public Object GetRoot() { return root; }



    /** *힙 - 삽입 연산 */
    public void Insert(Object newData) {
        int currentPosition = super.usedSize;
        int parentPosition =GetParent(currentPosition);

        if(super.usedSize == super.capacity) {
            super.array = ExpandArray(super.array, (super.capacity * 2) + 1);
        }

        super.array[currentPosition] = newData;

        while(currentPosition > 0 &&
                (Integer)super.array[currentPosition] < (Integer)super.array[parentPosition]) {
            Object temp;
            temp = super.array[currentPosition];
            super.array[currentPosition] = super.array[parentPosition];
            super.array[parentPosition] = temp;

            currentPosition = parentPosition;
            parentPosition = GetParent(currentPosition);
        }

        super.usedSize++;
    }



    /** *힙 - 최솟값 삭제 연산 */
    public void DeleteMin() {
        int parentPosition = 0;
        int leftPosition = 0;
        int rightPosition = 0;

        this.root = super.array[0];
        super.usedSize--;
        super.array[0] = super.array[usedSize];

        leftPosition = GetLeftChild(0);
        rightPosition = leftPosition + 1;

        while(true) {
            int selectedChild = 0;

            if(leftPosition >= super.usedSize) break;

            if(rightPosition >= super.usedSize) selectedChild = leftPosition;
            else {
                if((Integer)super.array[leftPosition] > (Integer)super.array[rightPosition]) selectedChild = rightPosition;
                else selectedChild = leftPosition;
            }

            if((Integer)super.array[selectedChild] < (Integer)super.array[parentPosition]) {
                Object temp;
                temp = super.array[selectedChild];
                super.array[selectedChild] = super.array[parentPosition];
                super.array[parentPosition] = temp;

                parentPosition = selectedChild;
            }
            else break;

            leftPosition = GetLeftChild(parentPosition);
            rightPosition = leftPosition + 1;
        }

        if(super.usedSize != 0 && super.usedSize < (super.capacity / 2)) {
            super.array = ExpandArray(super.array, (super.capacity / 2));
        }
    }



    public void Traversal() {
        for(int i = 0; i < super.usedSize; i++) {
            System.out.print(super.array[i] + " ");
        }
        System.out.println();
    }
}
