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
        pq.changeKey(root, 0);
        while(!pq.isEmpty()){
            Node node = pq.extractMin();
            if(node.parent != -1){
                graphOut.addEdge(node.id, node.parent, node.key);
                graphOut.addEdge(node.parent, node.id, node.key);
            }

            for(Edge edge : node.edges){
                Node v = nodes.get(indexOf(edge.v));
                if(pq.exists(v.id) && edge.weight < v.key){
                    v.parent = node.id;
                    v.key = edge.weight;
                    pq.changeKey(v.id, v.key);
                }
            }
        }
        return graphOut;
    }

    public Graph dijkstra(int source){
        double inf = Double.POSITIVE_INFINITY;
        PriorityQueue pq = new PriorityQueue(nodes.size());
        Graph graphOut = new Graph();
        for(Node n : nodes){
            n.key = inf;
            n.parent = -1;
            pq.insert(n);
        }
        pq.changeKey(source, 0);
        while(!pq.isEmpty()){
            Node u = pq.extractMin();
            if(u.parent != -1){
                graphOut.addEdge(u.id, u.parent, u.key);
                graphOut.addEdge(u.parent, u.id, u.key);
            }
            for(Edge edge : u.edges){
                Node v = nodes.get(indexOf(edge.v));
                double distance = u.key + edge.weight;
                if(pq.exists(v.id) && distance < v.key) {
                    v.key = distance;
                    v.parent = u.id;
                    pq.changeKey(v.id, v.key);
                }
            }
        }
        return graphOut;
    }
}
