
package operators;

public abstract class OneFormuleOperator extends Operator {
        
    public OneFormuleOperator(String name)
    {
      super(name);
    }
    public abstract OneFormuleOperator toNegation();
        
}
