public class Node {
    private static int ID_GENERATOR = 0;
    private int id;
    private String value;

    public Node(String value) {
        this.id = ID_GENERATOR;
        this.value = value;
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

    public void printNode(){
        System.out.println("id = " + getId() + ", value = " + getValue());
    }
}
