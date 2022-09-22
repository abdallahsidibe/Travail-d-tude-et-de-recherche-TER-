package operators;

public class Diamond extends OneFormuleOperator {

    public Diamond() {
        super("◊");
    }

    @Override
    public OneFormuleOperator toNegation() {

        return new Square();
    }

}
