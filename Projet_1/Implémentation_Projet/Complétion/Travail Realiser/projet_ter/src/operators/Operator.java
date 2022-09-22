
package operators;

public abstract class Operator {
    
    private final String name;

    public Operator(String name)
    {
        this.name=name;
    }
    
    public String toString()
    {
        return this.name;
    }
    
    public abstract Operator toNegation();
}
