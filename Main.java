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
        printGraph(graph.prim(3), outputPrims);
        printGraph(graph.dijkstra(0), outputDijkstra);
    }

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

    public static void printGraph(Graph graphToPrint, String filename) throws IOException {
        Collections.sort(graphToPrint.nodes, Comparator.comparing(Node::getId));
        File outputFile = new File(filename);
        FileWriter writer = new FileWriter(outputFile);
        for(int i = 0; i < graphToPrint.nodes.size(); i++) {
            writer.write(String.valueOf(graphToPrint.nodes.get(i).id));
            for (int j = 0; j < graphToPrint.nodes.get(i).edges.size(); j++) {
                writer.write((" " + graphToPrint.nodes.get(i).edges.get(j).v + " " + graphToPrint.nodes.get(i).edges.get(j).weight));
            }
            writer.write("\n");
        }
        writer.close();
    }
}
