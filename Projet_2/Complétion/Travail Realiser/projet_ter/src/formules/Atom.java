
package formules;

import formules.Formule;
import java.util.ArrayList;

public class Atom extends Formule{
    String name;
    private boolean value=true;
    private  Atom negation=null;
    
    public Atom(String name)
    {
        super(false);
        this.name=name;
    }
    
    public Atom toNegation()
    {
        if(negation==null)
        {
            negation=new Atom(this.name);
            negation.negation=this;
            negation.value=!value;
        }
        return negation;
    }
    
    public String toString()
    {
        if(value)return this.name;
        else return "¬"+this.name;
    }

    @Override
    public ArrayList<ArrayList<Formule>> getComponents() {
        ArrayList<ArrayList<Formule>> lists_formules =new ArrayList<>();
        return lists_formules;
    }

   
    
}
