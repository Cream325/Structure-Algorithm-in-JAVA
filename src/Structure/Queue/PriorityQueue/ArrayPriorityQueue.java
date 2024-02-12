package Structure.Queue.PriorityQueue;

public class ArrayPriorityQueue extends PriorityQueueNode {
    PriorityData root;
    public ArrayPriorityQueue(int capacity) { super(capacity); }

    private int GetParent(int index) { return (int)((index - 1) / 2); }
    private int GetLeftChild(int index) { return (index * 2) + 1; }
    private PriorityData[] ExpandArray(PriorityData[] array, int capacity) {
        PriorityData[] newArray = new PriorityData[capacity];
        for(int i = 0; i < array.length; i++) newArray[i] = array[i];
        return newArray;
    }
    public PriorityData GetRoot() { return root; }



    public void Enqueue(int priority, Object newData) { Enqueue(new PriorityData(priority, newData)); }

    private void Enqueue(PriorityData newData) {
        int currentPosition = super.usedSize;
        int parentPosition = GetParent(currentPosition);

        if(super.usedSize == super.capacity) {
            super.priorityArray = ExpandArray(super.priorityArray, (super.capacity * 2));
        }

        super.priorityArray[currentPosition] = newData;

        while(currentPosition > 0 &&
                super.priorityArray[currentPosition].GetPriority() < super.priorityArray[parentPosition].GetPriority()) {
            PriorityData temp;
            temp = super.priorityArray[currentPosition];
            super.priorityArray[currentPosition] = super.priorityArray[parentPosition];
            super.priorityArray[parentPosition] = temp;

            currentPosition = parentPosition;
            parentPosition = GetParent(currentPosition);
        }

        super.usedSize++;
    }



    public PriorityData Dequeue() {
        int parentPosition = 0;
        int leftPosition = 0;
        int rightPosition = 0;

        this.root = super.priorityArray[0];
        super.usedSize--;
        if(super.usedSize == -1) return null;

        super.priorityArray[0] = super.priorityArray[usedSize];

        leftPosition = GetLeftChild(0);
        rightPosition = leftPosition + 1;

        while (true) {
            int selectedChild = 0;

            if (leftPosition >= super.usedSize) break;

            if (rightPosition >= super.usedSize) selectedChild = leftPosition;
            else {
                if (super.priorityArray[leftPosition].GetPriority() > super.priorityArray[rightPosition].GetPriority())
                    selectedChild = rightPosition;
                else selectedChild = leftPosition;
            }

            if (super.priorityArray[selectedChild].GetPriority() < super.priorityArray[parentPosition].GetPriority()) {
                PriorityData temp;
                temp = super.priorityArray[selectedChild];
                super.priorityArray[selectedChild] = super.priorityArray[parentPosition];
                super.priorityArray[parentPosition] = temp;

                parentPosition = selectedChild;
            } else break;

            leftPosition = GetLeftChild(parentPosition);
            rightPosition = leftPosition + 1;
        }

        if (super.usedSize != 0 && super.usedSize < (super.capacity / 2)) {
            super.priorityArray = ExpandArray(super.priorityArray, (super.capacity / 2));
        }

        return root;
    }
    


    public void PrintAllAfterDequeue() {
        while(true) {
            PriorityData priorityData = Dequeue();
            if(priorityData != null) System.out.println("Priority: " + priorityData.GetPriority() + ", Data: " + priorityData.GetData());
            else return;
        }
    }
}
