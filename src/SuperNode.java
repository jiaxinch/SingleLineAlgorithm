import java.util.Vector;

public class SuperNode{
    public Vector<Node> innerNode;
    public SuperNode parent;
    public Vector<SuperNode> children;
    public SuperNode(){
        innerNode = new Vector<Node>();
        parent = null;
        children = new Vector<SuperNode>();
    }
    public SuperNode(int value){
        innerNode = new Vector<Node>();
        parent = null;
        children = new Vector<SuperNode>();
        innerNode.add(new Node(value));
    }
}
