import javafx.util.Pair;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

public class Graph {
    private List<Node> listNode;
    private List<Edge> listEdge;

    public Graph() {
        listEdge = new ArrayList<>();
        listNode = new ArrayList<>();
    }

    public void addEdge(String firstNode, String secondNode, int value){
        addEdge(firstNode, secondNode, value, false);
    }

    public boolean addEdge(String firstNode, String secondNode, double value, boolean twoWays){
        if (!containEdge(firstNode, secondNode)){
            Node first = getNode(firstNode);
            Node second = getNode(secondNode);
            listEdge.add(new Edge(first, second, value));
            if (twoWays){
                listEdge.add(new Edge(second, first, value));
            }
            return true;
        }else{
            return false;
        }
    }

    public Node getNode(String node){
        Node n;
        if (!containNode(node)){
            n = new Node(node);
            listNode.add(n);
            return n;
        }else{
            int i = 0;
            while (i < listNode.size()){
                if (listNode.get(i).getValue().equals(node)) return listNode.get(i);
                i++;
            }
            return null;
        }
    }

    public Edge getEdge(String firstNode, String secondNode){
        int i = 0;
        while (i < listEdge.size()){
            if (listEdge.get(i).getFirstNode().getValue().equals(firstNode)
                    && listEdge.get(i).getSecondNode().getValue().equals(secondNode)){
                return listEdge.get(i);
            }
            i++;
        }
        return null;
    }

    public boolean addNode(String node){
        if (!containNode(node)){
            listNode.add(new Node(node));
            return true;
        }else{
            return false;
        }
    }

    public boolean containNode(String node){
        boolean found = false;
        int i = 0;
        while (!found && i < listNode.size()){
            if (listNode.get(i).getValue().equals(node)){
                found = true;
            }
            i++;
        }
        return found;
    }

    public boolean containEdge(String firstNode, String secondNode){
        boolean found = false;
        int i = 0;
        while (!found && i < listEdge.size()){
            if (listEdge.get(i).getFirstNode().getValue().equals(firstNode)
                    && listEdge.get(i).getSecondNode().getValue().equals(secondNode)){
                found = true;
            }
            i++;
        }
        return found;
    }

    public void printGraph(){
        System.out.println("NODE :");
        for (Node node : listNode){
            node.printNode();
        }

        System.out.println();

        System.out.println("EDGE : ");
        for (Edge edge : listEdge){
            edge.printEdge();
            System.out.println();
        }
    }

    public List<Node> getListNode() {
        return listNode;
    }

    public List<Edge> getListEdge() {
        return listEdge;
    }

    public void AStarAlgorithm(Map<Pair<String, String>, Integer> mapHeuristic, String from, String destination, List<String> result) {
        Node thisNode = getNode(from);
        Node destinationNode = getNode(destination);

        int[] distance = new int[getListNode().size()];
        Arrays.fill(distance, -1);
        distance[thisNode.getId()] = 0;
        int fn = distance[thisNode.getId()] + mapHeuristic.get(new Pair<>(thisNode.getValue(), destination));
    }
}
