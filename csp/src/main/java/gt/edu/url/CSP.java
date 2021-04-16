package gt.edu.url;

import java.util.List;
import java.util.Map;
import java.util.HashMap;
import java.util.ArrayList;
import java.util.Queue;
import java.util.LinkedList;
import java.util.stream.Collectors;

public class CSP<V, D>{

    private List<V> variables;
    private Map<V, List<D>> domains;
    private Map<V, List<Constraint<V, D>>> constraints = new HashMap<>();
    private List<List<V>> Arcs = new ArrayList<>();

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
            
            if(!Arcs.contains(constraint.variables)){
                Arcs.add(constraint.variables);
            }

            List<V> reversed = List.of(constraint.variables.get(1), constraint.variables.get(0));

            if(!Arcs.contains(reversed)){
                Arcs.add(reversed);
            }
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

    public boolean AC3(V assigned, Map<V, D> localAssignment){

        List<List<V>> neighbors = Arcs.stream()
            .filter(v -> v.get(0) == assigned)
            .collect(Collectors.toList());

        Queue<List<V>> ArcsQ = new LinkedList<>(neighbors);
        List<V> currentArc;

        while(!ArcsQ.isEmpty()){
            currentArc = ArcsQ.remove();

            if(Revise(currentArc, localAssignment)){

                if(domains.get(currentArc.get(0)).isEmpty()){
                    return false;
                }

                for(var arc: Arcs){

                    if(arc.get(1) == currentArc.get(0) && !ArcsQ.contains(arc)){
                        ArcsQ.add(arc);
                    }
                }
            }
        }
        return true;
    }

    public boolean Revise(List<V> arc, Map<V, D> localAssignment){

        boolean revised = false;
        Map<V, D> subLocalAssignment = new HashMap<>(localAssignment);

        for(var x: domains.get(arc.get(0))){

            subLocalAssignment.put(arc.get(0), x);

            for(var y: domains.get(arc.get(1))){

                subLocalAssignment.put(arc.get(1), y);

                if(!consistent(arc.get(0), subLocalAssignment)){
                    var localList = new ArrayList<>(domains.get(arc.get(1)));
                    localList.remove(x);
                    domains.put(arc.get(1), localList);
                    revised = true;
                    break;
                }
            }
        }
        return revised;
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
           System.out.println("Variable: " + unassigned + " Value: " + value);

           // Try assignment
           // 1 - create a copy of previous assignment 
           Map<V, D> localAssignment = new HashMap<>(assignment);

           // 2 - test (assign a value)
           localAssignment.put(unassigned, value);

           // 3 - verify assignment consistency
           if(consistent(unassigned, localAssignment)){

               domains.put(unassigned, List.of(value));
               if(!AC3(unassigned, localAssignment)){
                   throw new IllegalArgumentException("CSP cannot be solved");
               }
               Map<V, D> result = backtrack(localAssignment);

               if(result != null){
                   return result;
               }
           }
       }

       return null;
    }

}
