
package formules;

import java.util.ArrayList;
import operators.Conjunction;
import operators.Disjunction;
import operators.Release;
import operators.Ring;
import operators.TwoFormuleOperator;

public class F1opF2 extends Formule {

    private Formule f1,f2;
    private TwoFormuleOperator op;
    
    public F1opF2(Formule f1,TwoFormuleOperator op,Formule f2)
    {
        super(false);
        this.f1=f1;
        this.f2=f2;
        this.op=op;
    }

    public Formule getF1() {
        return f1;
    }

    public Formule getF2() {
        return f2;
    }

    public TwoFormuleOperator getOp() {
        return op;
    }
       
    @Override
    public String toString() {
        
        if(this.isMarked()) return "("+this.f1.toString()+""+this.op.toString()+""+this.f2.toString()+")"+"*";
        return "("+this.f1.toString()+""+this.op.toString()+""+this.f2.toString()+")";
        
    }

    @Override
    public Formule toNegation() {     
      
        return new F1opF2(this.f1.toNegation(),op.toNegation(),this.f2.toNegation());

    }
    
    @Override
    public ArrayList<ArrayList<Formule>> getComponents()
    {
       ArrayList<Formule> list=new ArrayList<>();
       ArrayList<Formule> list2=new ArrayList<>();
       ArrayList<ArrayList<Formule>> lists_formules =new ArrayList<>();
       
       if(this.getOp()instanceof Conjunction)
           {
              list.add(this.getF1());
              list.add(this.getF2());
              lists_formules.add(list);
           }
      else if(this.getOp()instanceof Disjunction)
           {
               list.add(((F1opF2)this).getF1());
               list2.add(((F1opF2)this).getF2());
               lists_formules.add(list);
               lists_formules.add(list2);
               
               
           }
     else if(this.getOp()instanceof Release)
           {
               list.add(this.getF1());
               list.add(this.getF2());
               list2.add(this.getF1());
               list2.add(new OpF(new Ring(),this));
               lists_formules.add(list);
               lists_formules.add(list2);
           }
     else 
           {
               list.add(this.getF2());
               list2.add(this.getF1());
               list2.add(new OpF(new Ring(),this));
               lists_formules.add(list);
               lists_formules.add(list2);
               
           }
       return lists_formules;
    }
    
}
