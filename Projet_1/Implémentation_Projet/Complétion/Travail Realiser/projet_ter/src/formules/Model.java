package formules;

import java.util.ArrayList;
import operators.*;
import tree.State;

public class Model {

    private ArrayList<ArrayList<Formule>> formules=new ArrayList<>();
    private ArrayList<ArrayList<Formule>> fullyExp_formules=new ArrayList<>();
    
    public boolean is_Consistent(ArrayList<Formule> list)
    {
        for(int i=0;i<list.size();i++)
        {
            if(list.contains(list.get(i).toNegation()))
            {
                return false;
            }
        }
        return true;
    }
    
    public ArrayList<Formule> _Next(ArrayList<Formule> list)
    {
        ArrayList<Formule> new_list=new ArrayList<Formule>();
        for(int i=0;i<list.size();i++)
        {
            if(list.get(i).isSucc()) 
            {
                new_list.add(((OpF)list.get(i)).getF());
            }
            
        }
        return new_list;
    }
    
    public boolean is_Valid(State node,ArrayList<Formule> list)
    {
        for(Atom a : node.getData())
        {
            if(list.contains(a.toNegation()))
                return false;
        }
        return true;
    }
    
}
