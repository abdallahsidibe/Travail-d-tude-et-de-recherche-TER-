package operators;


public class Conjunction extends TwoFormuleOperator {

    public Conjunction() {
        super("∧");
    }

    @Override
    public TwoFormuleOperator toNegation() {
        
        return new Disjunction();

    }


}
