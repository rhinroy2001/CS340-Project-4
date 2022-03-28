import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException {
        String inputFilename = "/Users/ryanhagen/IdeaProjects/CS340-Project-4/sample.txt";
        String outputPrims = "/Users/ryanhagen/IdeaProjects/CS340-Project-4/primout.txt";
        String outputDijkstra = "/Users/ryanhagen/IdeaProjects/CS340-Project-4/dijkstraout.txt";
        Graph graph = readGraph(inputFilename);
//        printGraph(graph);
//        printGraph(graph.prim(3));
        printGraph(graph.dijkstra(5));

        // Min Priority Queue test. It works!!
//        PriorityQueue pq = new PriorityQueue(4);
//        Node node0 = new Node(0);
//        node0.key = 3;
//        pq.insert(node0);
//        Node node1 = new Node(1);
//        node1.key = 14;
//        pq.insert(node1);
//        Node node2 = new Node(2);
//        node2.key = 7;
//        pq.insert(node2);
//        Node node3 = new Node(3);
//        node3.key = 9;
//        pq.insert(node3);
//        for(int i = 0; i < 4; i++){
//            System.out.println(pq.extractMin().key + " ");
//        }
    }

    // finish
    public static Graph readGraph(String filename) throws IOException {
        File inputFile = new File(filename);
        int u = 0;
        int v = 0;
        double weight = 0.0;
        Scanner fileScanner = new Scanner(inputFile);
        Graph graph = new Graph();
        while(fileScanner.hasNextLine()) {
            String line = fileScanner.nextLine();
            Scanner lineScanner = new Scanner(line);
            u = lineScanner.nextInt();
            graph.nodes.add(new Node(u));
            while(lineScanner.hasNext()) {
                v = lineScanner.nextInt();
                weight = lineScanner.nextDouble();
                graph.addEdge(u, v, weight);
            }
            lineScanner.close();
        }

        fileScanner.close();
        return graph;
    }

    // finish
    public static void printGraph(Graph graphToPrint){
        Collections.sort(graphToPrint.nodes, Comparator.comparing(Node::getId));
        for(int i = 0; i < graphToPrint.nodes.size(); i++) {
            System.out.print(graphToPrint.nodes.get(i).id);
            for (int j = 0; j < graphToPrint.nodes.get(i).edges.size(); j++) {
                System.out.print( " " + graphToPrint.nodes.get(i).edges.get(j).v + " " + graphToPrint.nodes.get(i).edges.get(j).weight);
            }
            System.out.println("");
        }
    }

    public static void printGraph1(Graph graphToPrint, String filename) throws IOException {
        File outputFile = new File(filename);
        FileWriter writer = new FileWriter(outputFile);
        for(int i = 0; i < graphToPrint.nodes.size(); i++) {
            writer.write((graphToPrint.nodes.get(i).id));
            for (int j = 0; j < graphToPrint.nodes.get(i).edges.size(); j++) {
                writer.write(( " " + graphToPrint.nodes.get(i).edges.get(j).v + " " + graphToPrint.nodes.get(i).edges.get(j).weight + " "));
            }
            writer.write("\n");
        }
    }
}
