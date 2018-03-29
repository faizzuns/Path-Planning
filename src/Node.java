import java.util.ArrayList;
import java.util.List;

public class Node {
    private static int ID_GENERATOR = 0;
    private int id;
    private String value;
    private List<Node> listAdj;

    public Node(String value) {
        this.id = ID_GENERATOR;
        this.value = value;
        listAdj = new ArrayList<>();
        ID_GENERATOR++;
    }

    public static int getIdGenerator() {
        return ID_GENERATOR;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public List<Node> getListAdj() {
        return listAdj;
    }

    public void addAdj(Node node){
        if (!listAdj.contains(node)) listAdj.add(node);
    }

    public void printNode(){
        System.out.println("id = " + getId() + ", value = " + getValue());
    }
}
