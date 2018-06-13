import java.util.Arrays;
import java.util.Vector;

public class Solve {
    public Node root;
    public SuperNode superRoot;
    public int lineLength=0;
    public int workspaceLength=0;
    public int workspaceXOffset =0;
    public Vector<Integer> initialState;
    public Vector<Integer> finalState;

    public Solve(){
        Integer[] initArray = {2,3,5,1,7};
        initialState = new Vector<Integer>(Arrays.asList(initArray));
        Integer[] finalArray = {2,0,7,4,5};
        finalState = new Vector<Integer>(Arrays.asList(finalArray));
        lineLength = finalState.size();
        if(initialState.size()!=finalState.size()){
            System.out.println("Error: different size between initial and final state");
            System.exit(0);
        }
        CalculateWorkspaceSize();
        superRoot = new SuperNode(initialState.get(0));
        SuperNode temp = superRoot;
        for(int i=1;i<lineLength;++i){
            SuperNode child = new SuperNode(initialState.get(i));
            temp.children.add(child);
            temp = child;
        }
    }

    private void CalculateWorkspaceSize(){
        int topBorder =0;
        int bottomBorder =lineLength-1;
        int initialMin = 0-initialState.get(0)+1;
        int finalMin =0- finalState.get(0)+1;
        for(int i =0;i<initialState.size();++i){
            int initialValue = i - initialState.get(i)+1;
            int finalValue = i-finalState.get(i)+1;
            if(initialValue <initialMin){
                initialMin =initialValue;
            }
            if(finalValue <finalMin){
                finalMin = finalValue;
            }
        }
        if(finalMin>initialMin){
            finalMin = initialMin;
        }
        topBorder = finalMin;
        workspaceLength =bottomBorder-topBorder+1;
        workspaceXOffset = -1*topBorder;
    }
    
    public static void main(String args[]){
        Solve problem = new Solve();

    }
}
