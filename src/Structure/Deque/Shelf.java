package Structure.Deque;

public class Shelf extends DequeNode {
    public Shelf(int capacity) { super(capacity); }

    public void PushFront(Object newData) {
        int position = 0;

        if(super.front == super.capacity) {
            position = super.front;
            super.front = 0;
        }
        else position = super.front++;

        super.array[position] = newData;
    }

    public void PushBack(Object newData) {
        int position = 0;

        if(super.back == 0) {
            position = super.back;
            super.back = super.capacity;
        }
        else position = super.back--;

        super.array[position] = newData;
    }

    public Object Pop() {
        if(IsEmpty()) return null;
        else {
            if (super.back == super.capacity) super.back = 0;

            int position = super.back++;

            return super.array[position];
        }
    }

    public boolean IsEmpty() { return super.front == super.back; }
    public boolean IsFull() {
        int index = super.back - 1;
        if(index == -1) index = super.capacity;

        return ((super.front % super.capacity) == super.back) && ((index) == super.front);
    }

    public void print() {
        for(int i = 0; i < capacity; i++) {
            System.out.println(super.array[i]);
        }
    }
}
