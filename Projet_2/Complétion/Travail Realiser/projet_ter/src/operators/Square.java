package operators;

public class Square extends OneFormuleOperator {

    public Square() {
        super("◻");
    }

    @Override
    public OneFormuleOperator toNegation() {
        
        return new Diamond();
    }

}
