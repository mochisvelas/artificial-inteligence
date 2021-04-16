package gt.edu.url;

import java.util.Map;
import java.util.List;

public class ComplexConstraint  extends Constraint<String, String> {

    private String var1, var2;

    public ComplexConstraint(String var1, String var2){
        super(List.of(var1, var2));
        this.var1 = var1;
        this.var2 = var2;
    }

    @Override
    public boolean satisfied(Map<String, String> assignment){
        // Check
        // If variable has not been assigned
        if(!assignment.containsKey(var1) || !assignment.containsKey(var2)){
            return true;
        }

        // var1 <> var2
        return !assignment.get(var1).equals(assignment.get(var2));
    }
}

