package gt.edu.url;

import java.util.List;
import java.util.Map;
import java.util.HashMap;

public class ComplexApp 
{
    public static void main( String[] args )
    {
        // CSP
        // Variables
        List<String> variables = List.of("A", "B", "C", "D", "E", "F", "G", "H", "I", "J",
                "K", "L", "M", "N", "Ñ", "O", "P", "Q", "R", "S", "T", "U", "V", "W", "X", "Y", "Z", "AA");

        // Domains
        Map<String, List<String>> domains = new HashMap<>();
        for(var variable: variables){
            domains.put(variable, List.of("C", "M", "Y", "K"));
        }


        // Restrictions
        CSP<String, String> problem = new CSP<>(variables, domains);

        problem.addConstraint(new ComplexConstraint("A", "B"));
        problem.addConstraint(new ComplexConstraint("A", "V"));
        problem.addConstraint(new ComplexConstraint("B", "V"));
        problem.addConstraint(new ComplexConstraint("C", "D"));
        problem.addConstraint(new ComplexConstraint("C", "F"));
        problem.addConstraint(new ComplexConstraint("C", "H"));
        problem.addConstraint(new ComplexConstraint("D", "G"));
        problem.addConstraint(new ComplexConstraint("D", "H"));
        problem.addConstraint(new ComplexConstraint("E", "I"));
        problem.addConstraint(new ComplexConstraint("F", "K"));
        problem.addConstraint(new ComplexConstraint("G", "K"));
        problem.addConstraint(new ComplexConstraint("H", "V"));
        problem.addConstraint(new ComplexConstraint("H", "M"));
        problem.addConstraint(new ComplexConstraint("I", "M"));
        problem.addConstraint(new ComplexConstraint("J", "N"));
        problem.addConstraint(new ComplexConstraint("K", "Ñ"));
        problem.addConstraint(new ComplexConstraint("L", "O"));
        problem.addConstraint(new ComplexConstraint("L", "P"));
        problem.addConstraint(new ComplexConstraint("M", "P"));
        problem.addConstraint(new ComplexConstraint("O", "R"));
        problem.addConstraint(new ComplexConstraint("O", "S"));
        problem.addConstraint(new ComplexConstraint("O", "T"));
        problem.addConstraint(new ComplexConstraint("Q", "W"));
        problem.addConstraint(new ComplexConstraint("Q", "X"));
        problem.addConstraint(new ComplexConstraint("Q", "R"));
        problem.addConstraint(new ComplexConstraint("R", "X"));
        problem.addConstraint(new ComplexConstraint("R", "Y"));
        problem.addConstraint(new ComplexConstraint("R", "Z"));
        problem.addConstraint(new ComplexConstraint("S", "Z"));
        problem.addConstraint(new ComplexConstraint("S", "AA"));
        problem.addConstraint(new ComplexConstraint("S", "T"));
        problem.addConstraint(new ComplexConstraint("T", "AA"));
        problem.addConstraint(new ComplexConstraint("V", "W"));
        problem.addConstraint(new ComplexConstraint("W", "X"));
        problem.addConstraint(new ComplexConstraint("X", "Y"));
        problem.addConstraint(new ComplexConstraint("Y", "Z"));
        problem.addConstraint(new ComplexConstraint("Z", "AA"));

        // System.out.println(problem.ArcsQ);

        var solution = problem.backtrack();
        System.out.println(solution);

    }
}
