public class Edge {
    private static int ID_GENERATOR = 0;
    private int id;
    private Node firstNode;
    private Node secondNode;
    private double edgeValue;

    public Edge(Node firstNode, Node secondNode, double edgeValue) {
        id = ID_GENERATOR;
        this.firstNode = firstNode;
        this.secondNode = secondNode;
        this.edgeValue = edgeValue;
        ID_GENERATOR++;
    }

    public static int getIdGenerator() {
        return ID_GENERATOR;
    }

    public Node getFirstNode() {
        return firstNode;
    }

    public Node getSecondNode() {
        return secondNode;
    }

    public double getEdgeValue() {
        return edgeValue;
    }

    public int getId() {
        return id;
    }

    public void printEdge() {
        System.out.println("id = " + getId() + ", value = " + getEdgeValue() );
        getFirstNode().printNode();
        getSecondNode().printNode();
    }
}
