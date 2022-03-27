public class Edge implements Comparable<Edge> {
    int u;
    int v;
    double weight;

    public Edge(int u, int v, double weight){
        this.u = u;
        this.v = v;
        this.weight = weight;
    }

    // check this method to make sure the condition is correct
    @Override
    public int compareTo(Edge edge) {
        if(this.weight > edge.weight){
            return 1;
        }
        return 0;
    }
}
