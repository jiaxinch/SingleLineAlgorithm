import java.util.Vector;

public class Node {
    public double value;
    public Node parent;
    public Vector<Node> children;
    public int superXCord;
    public int superYCord;
    public Node(){
        value =0;
        parent = null;
        children = new Vector<>();
    }
    public Node(int value, int xCord, int yCord){
         this.value = value;
         parent = null;
         superXCord =xCord;
         superYCord = yCord;
         children = new Vector<>();
    }
}
