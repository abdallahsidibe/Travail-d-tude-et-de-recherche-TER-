package operators;


public class Disjunction extends TwoFormuleOperator {

    public Disjunction() {
        super("∨");
    }

    @Override
    public TwoFormuleOperator toNegation() {
        
        return new Conjunction();

    }
    

}
