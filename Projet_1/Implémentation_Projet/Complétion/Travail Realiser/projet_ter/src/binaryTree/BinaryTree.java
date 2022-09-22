package binaryTree;

import formules.Formule;
import formules.Model;
import java.util.ArrayList;

public class BinaryTree {
    
    private TreeNode root;
    private Model m;
    public ArrayList<ArrayList<Formule>> listes_formule;
    public BinaryTree(TreeNode root)
    {
        this.listes_formule=new ArrayList<>();
        this.root=root;
        this.m=new Model();
        constructTree(this.root);
        display(this.root);
    }
    
    public void constructTree (TreeNode node)
    {
        TreeNode right=new TreeNode();
        TreeNode left=new TreeNode();
        if(node.getData().isEmpty()) return;
        else
        {
            for(int i=0;i<node.getData().size();i++)
            {
                if(node.getData().get(i).isAtom() || node.getData().get(i).isSucc())
                {
                    
                }
                else
                {
                    if(node.getData().get(i).isConj())
                    
                    {
                    right.addList(node.getData());
                    right.getData().remove(node.getData().get(i));
                    right.getData().addAll(node.getData().get(i).getComponents().get(0));
                    constructTree(right);
                    }
                    else if(node.getData().get(i).isDis())
                    {
                    right.addList(node.getData());
                    right.getData().remove(node.getData().get(i));
                    right.getData().addAll(node.getData().get(i).getComponents().get(0));
                    constructTree(right);
                    left.addList(node.getData());
                    left.getData().remove(node.getData().get(i));
                    left.getData().addAll(node.getData().get(i).getComponents().get(1));
                    constructTree(left);
                    }
                    node.setLeft(left);
                    node.setRight(right);
                    break;
                }
            }
        }
    }
    
    public void display(TreeNode root)
    {
        if(root.getRight()!=null && !root.getRight().getData().isEmpty())
        {
            display(root.getRight());
        }
        if(root.getLeft()!=null && !root.getLeft().getData().isEmpty())
        {
            display(root.getLeft());
        }
        if(root.getLeft()==null && root.getRight()==null)
        {
        System.out.print(root.getData());
        if(this.m.is_Consistent(root.getData()))
        {
            System.out.println("    :  Consistent");
            this.listes_formule.add(root.getData());
        }
        else
        {
            System.out.println("    : not consistent");
        }
        }
    }
}
