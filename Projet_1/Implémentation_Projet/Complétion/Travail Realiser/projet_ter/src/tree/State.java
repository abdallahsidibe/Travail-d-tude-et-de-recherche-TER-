
package tree;

import java.util.ArrayList;
import formules.Atom;

public class State {
    private String name;
    private ArrayList<Atom> data;
    private ArrayList<State> successors;
    
    public State(String name)
    {
        this.name=name;
        this.data=new ArrayList<>();
        this.successors=new ArrayList<>();
    }
    public State(String name,ArrayList<Atom> atoms)
    {
        this.name=name;
        this.data=atoms;
        this.successors=new ArrayList<>();
    }
    public State(String name,ArrayList<State> successors,ArrayList<Atom> data)
    {
        this.name=name;
        this.successors=successors;
        this.data=data;
    }

    public String getName() {
        return name;
    }

    public ArrayList<Atom> getData() {
        return data;
    }

    public ArrayList<State> getSuccessors() {
        return successors;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setData(ArrayList<Atom> data) {
        this.data = data;
    }

    public void addSuccessors(ArrayList<State> successors) {
        this.successors = successors;
    }
    public void addSuccessor(State s)
    {
        successors.add(s);
    }
    public void addAtom(Atom a)
    {
        this.data.add(a);
    }

       
}
