package Structure.Queue;

public class CircularQueue extends QueueNode {
    public CircularQueue(int capacity) { super(capacity); }

    public void Enqueue(Object newData) {
        int position = 0;

        if(super.rear == super.capacity) {
            position = super.rear;
            super.rear = 0;
        }
        else position = super.rear++;

        super.array[position] = newData;
    }

    public Object Dnqueue() {
        int position = super.front;

        if(super.front == super.capacity) super.front = 0;
        else super.front++;

        return super.array[position];
    }


}
