
package operators;

import binaryTree.*;
import formules.*;
import java.util.ArrayList;
import tree.State;

public class LogicTest {

    
    public static void main(String[] args) {

        State s0=new State("s0");
        
        Formule p=new Atom("p");
        Formule q=new Atom("q");
        Formule r=new Atom("r");
        
        s0.addAtom((Atom) q);
        
        
        Formule f1=new OpF(new Diamond(),p);
        Formule f2=new F1opF2(new OpF(new Square(),new F1opF2(q.toNegation(),new Disjunction(),new OpF(new Ring(),p.toNegation()))),new Conjunction(),f1);
        Formule fi=new F1opF2(p.toNegation(),new Conjunction(),f2);
        Model m=new Model();
        
        System.out.println("fi="+fi.toString());
        TreeNode root=new TreeNode();
        root.addList(fi.toList());
        BinaryTree bt=new BinaryTree(root);
        System.out.println("Testing validity with s0 : ");
        for(ArrayList<Formule> f : bt.listes_formule)
        {
            System.out.println(f +" :"+m.is_Valid(s0, f));
        }
        
        
        
        System.out.println("Applying Next:  ");
        
        for(ArrayList<Formule> f : bt.listes_formule)
        {
            System.out.println(m._Next(f));
        }

        } 
        
}
