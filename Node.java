import java.util.ArrayList;

public class Node implements Comparable<Node>{
    public int id;
    // figure out what value key is supposed to be
    public double key;
    ArrayList<Edge> edges;
    int parent;

    public Node(int id){
        this.id = id;
        this.edges = new ArrayList<>();
    }

    public int getId(){
        return id;
    }

//    public void setKey(double key){
//        this.key = key;
//    }

//    public void setParent(int parent){
//        this.parent = parent;
//    }

    @Override
    public int compareTo(Node node) {
        if(this.key < node.key){
            return 1;
        }
        return 0;
    }
}
