
package binaryTree;

import formules.*;
import java.util.ArrayList;

public class TreeNode {
    
    private ArrayList<Formule> data;
    private TreeNode left;
    private TreeNode right;
    
    public TreeNode()
    {
        this.data=new ArrayList<>();
    }

    public void addList(ArrayList<Formule> data) {
        this.data.addAll(data);
    }

    public void setLeft(TreeNode left) {
        this.left = left;
    }

    public void setRight(TreeNode right) {
        this.right = right;
    }

    public ArrayList<Formule> getData() {
        return data;
    }

    public TreeNode getLeft() {
        return left;
    }

    public TreeNode getRight() {
        return right;
    }
    
    
    
}
