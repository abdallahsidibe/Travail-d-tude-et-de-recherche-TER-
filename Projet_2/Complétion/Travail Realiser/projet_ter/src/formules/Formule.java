
package formules;

import java.util.ArrayList;
import operators.*;

public abstract class Formule {
   private boolean marked;
   
   
   public Formule(boolean marked)
   {
       this.marked=marked;
   }
      
   public abstract String toString();
   
   public abstract Formule toNegation();
   
   public  void mark()
   {
       marked=true;
   }
   public boolean isMarked()
   {
       return marked;
   }
   
   public ArrayList<Formule> toList()
   {
       ArrayList<Formule> a=new ArrayList<>();
       a.add(this);
       return a;
   }
   
   public boolean isSucc()
   {
       if(this instanceof OpF && (((OpF)this).getOp() instanceof Ring)) return true;
       else return false;
   }
   public boolean isConj()
   {
       if(this instanceof OpF && (((OpF)this).getOp() instanceof Square)) return true;
       if(this instanceof F1opF2 && (((F1opF2)this).getOp()instanceof Conjunction)) return true;
       return false;
   }
   public boolean isDis()
   {
       if(!(this.isConj()||this.isSucc() || this.isAtom())) return true;
       return false;
   }
   public boolean isAtom()
   {
       if(this instanceof Atom) return true;
       return false;
   }
   public abstract ArrayList<ArrayList<Formule>> getComponents();
  
}