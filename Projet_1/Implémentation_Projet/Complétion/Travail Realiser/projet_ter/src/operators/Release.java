package operators;

public class Release extends TwoFormuleOperator {

    protected Release() {
        super("R");
    }

    @Override
    public TwoFormuleOperator toNegation() {
        return new Until();
    }
}
