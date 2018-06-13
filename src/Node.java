import java.util.Vector;

public class Node {
    public double value;
    public Node parent;
    public Vector<Node> children;
    public Node(){
        value =0;
        parent = null;
        children = new Vector<>();
    }
    public Node(int value){
         this.value = value;
         parent = null;
         children = new Vector<>();
    }
}
