
package operators;

public abstract class TwoFormuleOperator extends Operator{
    
    
    public TwoFormuleOperator(String name)
    {
        super(name);
    }

    public abstract TwoFormuleOperator toNegation();
}
