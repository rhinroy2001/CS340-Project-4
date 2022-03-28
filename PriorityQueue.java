public class PriorityQueue extends Heap{
    public PriorityQueue(int maxsize){
        super();
        heapSize = 0;
        location = new int[maxsize];
    }

    public void insert(Node newNode){
        if(this.isEmpty()) {
            heap[heapSize] = newNode;
            location[heapSize] = newNode.id;
        }else {
            heap[heapSize] = newNode;
            location[heapSize] = newNode.id;
            decreaseKey(heapSize);
        }
        heapSize++;
    }

    public Node peek(){
        return heap[0];
    }

    public boolean isEmpty(){
            return heapSize == 0;
    }

    public void changeKey(int nodeId, double key){
        int index = location[nodeId];
        heap[index].key = key;
        decreaseKey(index);
    }

    public Node extractMin(){
        Node min = peek();
        location[heap[0].id] = -1;
        heap[0] = heap[heapSize - 1];
        heapSize--;
        heapify(0);
        return min;
    }

    public boolean exists(int nodeName){
        return this.location[nodeName] != -1;
    }

    public void decreaseKey(int i){
        while( i > 0 && heap[i].compareTo(heap[parent(i)]) == 1){
            Node temp = heap[i];
            heap[i] = heap[parent(i)];
            heap[parent(i)] = temp;
            location[heap[parent(i)].id] = parent(i);
            location[heap[i].id] = i;
            i = parent(i);
        }
    }
}
