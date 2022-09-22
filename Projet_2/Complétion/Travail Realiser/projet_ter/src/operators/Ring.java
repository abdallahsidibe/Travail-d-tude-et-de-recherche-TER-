package operators;


public class Ring extends OneFormuleOperator {

    public Ring() {
        super("◯");
    }

    @Override
    public OneFormuleOperator toNegation() {
        return this;
    }

}
