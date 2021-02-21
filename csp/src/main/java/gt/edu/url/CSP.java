package gt.edu.url;

import java.util.List;
import java.util.Map;
import java.util.HashMap;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.Collections;

public class CSP<V, D>{

    private List<V> variables;
    private Map<V, List<D>> domains;
    private Map<V, List<Constraint<V, D>>> constraints = new HashMap<>();
    private Queue<List<V>> arcsQ = new ArrayDeque<>();

    public CSP(List<V> variables, Map<V, List<D>> domains){
        this.variables = variables;
        this.domains = domains;

        for(V variable: variables){
            constraints.put(variable, new ArrayList<Constraint<V, D>>());
            // Each variable must have an assigned domain
            if(!domains.containsKey(variable)){
                throw new IllegalArgumentException("Variable" + variable + "does not contain a domain");
            }
        }
    }

    public void addConstraint(Constraint<V, D> constraint){

        for(V variable:constraint.variables){
            // Check if variable in constraint is in CSP too

            if(!this.variables.contains(variable)){
                throw new IllegalArgumentException("Variable" + variable + "is not in CSP");
            }

            constraints.get(variable).add(constraint);

        }
            
            if(!arcsQ.contains(constraint.variables)){
                arcsQ.add(constraint.variables);
            }

            Collections.reverse(constraint.variables);

            if(!arcsQ.contains(constraint.variables)){
                arcsQ.add(constraint.variables);
            }

            Collections.reverse(constraint.variables);
    }

    public boolean consistent(V variable, Map<V, D> assignment){

        for(Constraint<V, D> constraint: this.constraints.get(variable)){

            if(!constraint.satisfied(assignment)){
                return false;
            }
        }

        return true;
    }

    public Map<V, D> backtrack(){
        return backtrack(new HashMap<>());
    }

    public boolean AC3(){
        return true;
    }

    public Map<V, D> backtrack(Map<V, D> assignment) {

       // If assignment is complete (each variable has a value)
       if(variables.size() == assignment.size()){
           return assignment;
       }

       // Select and unassigned variable
       V unassigned = variables.stream()
           .filter(v -> !assignment.containsKey(v))
           .findFirst().get();

       for(D value: domains.get(unassigned)){
           System.out.println("Variable: " + unassigned + "Value: " + value);

           // Try assignment
           // 1 - create a copy of previous assignment 
           Map<V, D> localAssignment = new HashMap<>(assignment);

           // 2 - test (assign a value)
           localAssignment.put(unassigned, value);

           // 3 - verify assignment consistency
           if(consistent(unassigned, localAssignment)){
               Map<V, D> result = backtrack(localAssignment);

               if(result != null){
                   return result;
               }
           }
       }

       return null;
    }

}
