public class Heap {
    protected Node[] heap;
    protected int heapSize;
    protected int[] location;

    public Heap(){
        heapSize = 20;
        heap = new Node[heapSize];
        location = new int[heapSize];
    }

    public Heap(int n){
        heap = new Node[n];
        heapSize = heap.length;
        location = new int[heapSize];
    }

//    public Heap(Node[] a){
//        heapSize = a.length;
//        heap = a;
//        location = new int[a.length];
//    }

    public int parent(int i){
        return (i - 1) / 2;
    }

    public int left(int i){
        return (i * 2) + 1;
    }

    public int right(int i){
        return (i * 2) + 2;
    }

    public void heapify(int i){
        int l = left(i);
        int r = right(i);
        int significant = i;
        if(l < heapSize && heap[l].compareTo(heap[significant]) == 1){
            significant = l;
        }
        if(r < heapSize && heap[r].compareTo(heap[significant]) == 1){
            significant = r;
        }
        if(significant != i){
            Node temp = heap[i];
            heap[i] = heap[significant];
            heap[significant] = temp;
            location[heap[significant].id] = significant;
            location[heap[i].id] = i;
            heapify(significant);
        }
    }

    public void buildHeap(){
        for(int i = (heapSize / 2) - 1; i >= 0; i--){
            heapify(i);
        }
    }
}
