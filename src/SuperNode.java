import java.util.Vector;

public class SuperNode{
    public Vector<Node> innerNode;
    public SuperNode parent;
    public Vector<SuperNode> children;
    public int xCord;
    public int yCord;
    public SuperNode(){
        innerNode = new Vector<Node>();
        parent = null;
        children = new Vector<SuperNode>();
        xCord=0;
        yCord=0;
    }
    public SuperNode(int value, int xCord, int yCord){
        innerNode = new Vector<Node>();
        parent = null;
        this.xCord =xCord;
        this.yCord = yCord;
        children = new Vector<SuperNode>();
        innerNode.add(new Node(value,xCord,yCord));
    }
    public void AddInnerNode(int value){
        innerNode.add(new Node(value, xCord,yCord));
    }
}
