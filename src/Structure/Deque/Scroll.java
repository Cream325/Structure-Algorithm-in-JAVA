package Structure.Deque;

public class Scroll extends DequeNode {
    public Scroll(int capacity) { super(capacity); }

    public void Push(Object newData) {
        int position = 0;

        if(super.front == super.capacity) {
            position = super.front;
            super.front = 0;
        }
        else position = super.front++;

        super.array[position] = newData;
    }

    public Object PopFront() {
        if(IsEmpty()) return null;
        else {
            if (super.front == 0) super.front = super.capacity;

            int position = --super.front;

            return super.array[position];
        }
    }

    public Object PopBack() {
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
