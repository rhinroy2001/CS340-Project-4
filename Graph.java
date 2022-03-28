import java.util.ArrayList;

public class Graph {
    ArrayList<Node> nodes;
    public Graph(){
        this.nodes = new ArrayList<>();
    }

    public Graph(ArrayList<Node> nodes){
        this.nodes = nodes;
    }

    public void addEdge(int u, int v, double weight) {
        int index = indexOf(u);
        if(index == -1){
            nodes.add(new Node(u));
        }
        Edge edge = new Edge(u, v, weight);
        nodes.get(indexOf(u)).edges.add(edge);
    }

    public int indexOf(int nodeName){
        for(int i = 0; i < nodes.size(); i++){
            if(nodes.get(i).id == nodeName){
                return i;
            }
        }
        return -1;
    }

//    public void addNode(int id){
//        Node node = new Node(id);
//        graph.add(node);
//    }

    public Graph prim(int root){
        double inf = Double.POSITIVE_INFINITY;
        PriorityQueue pq = new PriorityQueue(nodes.size());
        Graph graphOut = new Graph();
        for(Node n : nodes){
            n.key = inf;
            n.parent = -1;
            pq.insert(n);
        }
        nodes.get(root).key = 0;
        pq.decreaseKey(root);
//        for(int i = 0; i < graph.size(); i ++){
//            System.out.println(pq.extractMin().key);
//        }
        while(!pq.isEmpty()){
            Node node = pq.extractMin();
//            Node created = new Node(node.id);
//            graphOut.nodes.add(created);
            if(node.parent != -1){
                graphOut.addEdge(node.id, node.parent, node.key);
                graphOut.addEdge(node.parent, node.id, node.key);
            }

            for(Edge edge : node.edges){
                Node v = nodes.get(indexOf(edge.v));
                if(pq.exists(v.id) && edge.weight < v.key){
                    v.parent = node.id;
                    v.key = edge.weight;
//                    graphOut.addEdge(edge.u, edge.v, edge.weight);
                }
                pq.decreaseKey(v.id);
            }
        }
//        Graph graphOut = new Graph();
//        for(Node node : nodes){
//            graphOut.addEdge(node.parent, node.id, node.key);
//            graphOut.addEdge(node.id, node.parent, node.key);
//        }
        return graphOut;
    }

    public void dijkstra(int source){

    }
}
