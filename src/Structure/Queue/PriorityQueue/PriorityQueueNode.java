package Structure.Queue.PriorityQueue;

public class PriorityQueueNode {
    protected int capacity = 0;
    protected int usedSize = 0;
    protected PriorityData[] priorityArray;

    public PriorityQueueNode(int capacity) {
        this.capacity = capacity;
        priorityArray = new PriorityData[capacity];
    }

    public int GetCapacity() { return capacity; }

    public static class PriorityData {
        int priority;
        Object data;

        public PriorityData(int priority, Object data) {
            this.priority = priority;
            this.data = data;
        }

        public int GetPriority() { return priority; }
        public Object GetData() { return data; }
    }
}
