import java.util.Arrays;
import java.util.Collections;
import java.util.Vector;

public class Solve {
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
        superRoot = new SuperNode(initialState.get(0),0,0);
        SuperNode temp = superRoot;
        for(int i=1;i<lineLength;++i){
            SuperNode child = new SuperNode(initialState.get(i),0,i);
            temp.innerNode.get(0).children.add(child.innerNode.get(0));// link the parent-child relationship between the nodes
            child.innerNode.get(0).parent = temp.innerNode.get(0);
            //add final state Node to the tree
            child.AddInnerNode(finalState.get(i));
//            if(temp.innerNode.size()==1){// then this node is the superRoot, which means it is the reservoir
//                temp.innerNode.get(0).children.add(child.innerNode.get(1));
//                child.innerNode.get(1).parent =temp.innerNode.get(0);
//            }
            child.parent = temp;// link the parent-child relationship between the supernodes,
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
        workspaceLength =bottomBorder-topBorder+1+1;
        workspaceXOffset = -1*topBorder+1;
        Collections.reverse(initialState);
        Collections.reverse(finalState);
        for(int i =0;i<workspaceXOffset;++i){
            initialState.add(0);
            finalState.add(0);
        }
        Collections.reverse(initialState);
        Collections.reverse(finalState);
    }

    public void ConstructTree(){
        SuperNode superLeaf = findSuperLeaf();
        int index = superLeaf.yCord;
        while(finalState.get(index)==superLeaf.innerNode.get(0).value){
            if(superLeaf.parent!=null){
                superLeaf=superLeaf.parent;
            }
            else{
                System.out.println("the initial state and the final state have the same configuration");
                System.exit(0);
            }
        }
        // here superleaf is the first element that differs between two configuration.
        SuperNode currentSuperNode = superLeaf;
        while(currentSuperNode.parent!=null){

        }
    }
    private SuperNode findSuperLeaf(){
        SuperNode temp = superRoot;
        while(temp.children.size()!=0){
            temp = temp.children.get(0);
        }
        return temp;
    }
    public static void main(String args[]){
        Solve problem = new Solve();
        problem.ConstructTree();
    }
}
