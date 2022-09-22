
package tree;

import java.util.ArrayList;
import java.util.Arrays;
import formules.Atom;
import formules.Formule;

public class treeTest {

  
    public static void main(String[] args) {
        
        Atom p=new Atom("p");
        Atom q=new Atom("q");

        
        ArrayList<Atom> atoms = new ArrayList<>(Arrays.asList(p,q));
        
        State s0=new State("s0");
        State s1=new State("s1");
        State s2=new State("s2");

        
        s1.addAtom(q);
        s2.addAtom(p.toNegation());
        
        s0.addSuccessor(s1);
        s1.addSuccessor(s2);
        s2.addSuccessor(s1);
        
        Graph g =new Graph(s0,new ArrayList<State>(Arrays.asList(s0,s1,s2)),atoms);
        g.Print();
        
    }
    
}
