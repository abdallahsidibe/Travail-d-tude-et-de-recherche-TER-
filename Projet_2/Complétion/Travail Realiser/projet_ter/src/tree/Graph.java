
package tree;

import java.util.ArrayList;
import formules.Atom;

public class Graph {
    
    private State root;
    private ArrayList<Atom> atoms ;
    private ArrayList<State> states ;
    
    public Graph(State root)
    {
        this.root=root;
    }
    
    public Graph(State root,ArrayList<State> states)
    {
        this.root=root;
        this.states=states;
    }
    
    public Graph(State root,ArrayList<State> states,ArrayList<Atom> atoms)
    {
        this.root=root;
        this.states=states;
        this.atoms=atoms;
    }

    public State getRoot() {
        return root;
    }
    

    public ArrayList<Atom> getAtoms() {
        return atoms;
    }

    public ArrayList<State> getStates() {
        return states;
    }

    public void setAtoms(ArrayList<Atom> atoms) {
        this.atoms = atoms;
    }

    public void setStates(ArrayList<State> states) {
        this.states = states;
    }
    
    public void Print()
    {
        for(State s : states)
        {
            System.out.print(s.getName()+":{");
            for(Atom a : atoms)
            {
                if(s.getData().contains(a))
                {
                  
                  System.out.print(a.toString());
                  
                }
                else if(s.getData().contains(a.toNegation()))
                {
                    System.out.print(a.toNegation().toString());
                }
                else
                {
                    System.out.print(a.toString()+"?");
                }
                if(atoms.indexOf(a)<atoms.size()-1)
                {
                    System.out.print(",");
                }
             
            }
            System.out.println("}");
        }
        ArrayList<State> markedStates=new ArrayList<>();
        Construct(this.root,markedStates);
    }
    
    private void Construct(State s,ArrayList<State> markedStates)
    {
        markedStates.add(s);
        if(s.getSuccessors().isEmpty()) 
        {
            System.out.print(s.getName());
            return;
        }
        for(State succ : s.getSuccessors())
        {
            System.out.print(s.getName()+"->");
            if(markedStates.contains(succ)) 
            {
                System.out.print(succ.getName());
                continue;
            }
            Construct(succ,markedStates);
            System.out.println("");
            
        }
    }
    
}
