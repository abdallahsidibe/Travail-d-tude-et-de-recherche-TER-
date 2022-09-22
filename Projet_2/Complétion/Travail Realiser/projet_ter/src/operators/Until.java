package operators;

public class Until extends TwoFormuleOperator {

    public Until() {
        super(" U ");
    }

    @Override
    public TwoFormuleOperator toNegation() {
        return new Release();
    }

}
