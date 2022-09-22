package formules;

import java.util.ArrayList;
import operators.Diamond;
import operators.OneFormuleOperator;
import operators.Ring;
import operators.Square;

public class OpF extends Formule{
    
    private OneFormuleOperator op;
    private Formule f;    
    
    public OpF(OneFormuleOperator op,Formule f)
    {
        super(false);
        this.op=op;
        this.f=f;
        
    }

    public OneFormuleOperator getOp() {
        return op;
    }

    public Formule getF() {
        return f;
    }

    
    @Override
    public String toString() {
        if(this.isMarked()) return this.op.toString()+this.f.toString()+"*";
        return this.op.toString()+this.f.toString();
    }

    @Override
    public Formule toNegation() {
        return new OpF(this.op.toNegation(),this.f.toNegation());
    }

    @Override
    public ArrayList<ArrayList<Formule>> getComponents() {
        
         ArrayList<Formule> list=new ArrayList<>();
         ArrayList<Formule> list2=new ArrayList<>();
         ArrayList<ArrayList<Formule>> lists_formules =new ArrayList<>();
       
         if(this.getOp()instanceof Square)
           {
               list.add(this.getF());
               list.add(new OpF(new Ring(),this));
               lists_formules.add(list);
           }
           else if(((OpF)this).getOp()instanceof Diamond)
           {
               list.add(this.getF());
               list2.add(new OpF(new Ring(),this));
               lists_formules.add(list);
               lists_formules.add(list2);
           }
          

       return lists_formules;

   
    }
    
    
}
