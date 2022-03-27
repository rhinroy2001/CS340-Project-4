public class PriorityQueue extends Heap{
    public PriorityQueue(int maxsize){
        super();
        Heap pq = new Heap(maxsize);
        heapSize = 0;
        location = new int[maxsize];
    }

    public void insert(Node newNode){
        heapSize++;
        if(heapSize == 1) {
            heap[heapSize - 1] = newNode;
            location[heapSize - 1] = newNode.id;
        }else {
            heap[heapSize - 1] = newNode;
            location[heapSize - 1] = newNode.id;
            decreaseKey(heapSize - 1);
        }
    }

    public Node peek(){
        return heap[0];
    }

    public boolean isEmpty(){
        if(heapSize == 0){
            return true;
        }
        return false;
    }

    public void changeKey(int i, int k){
        heap[i].key = k;
        decreaseKey(i);
    }

    public Node extractMin(){
        Node min = heap[0];
        location[heap[0].id] = -1;
        heap[0] = heap[heapSize - 1];
        location[heap[0].id] = heap[0].id;
        heapSize--;
        heapify(0);
        return min;
    }

    public boolean exists(int nodeName){
        return this.location[nodeName] != -1;
    }

    public void decreaseKey(int id){
        while( id > 0 && heap[id].compareTo(heap[parent(id)]) == 1){
//            double temp1 = heap[parent(i)].key;
//            heap[parent(i)].key = heap[i].key;
//            heap[i].key = temp1;
//            int temp3 = heap[parent(i)].id;
//            heap[parent(i)].id = heap[i].id;
//            heap[i].id = temp3;
//            int temp2 = location[heap[parent(i)].id];
//            location[heap[parent(i)].id] = location[heap[i].id];
//            location[heap[i].id] = temp2;
            Node temp = heap[id];
            heap[id] = heap[parent(id)];
            heap[parent(id)] = temp;
            location[heap[parent(id)].id] = parent(id);
            location[heap[id].id] = id;
            id = parent(id);

        }
    }
}
