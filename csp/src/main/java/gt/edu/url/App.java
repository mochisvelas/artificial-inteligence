package gt.edu.url;

import java.util.List;
import java.util.Map;
import java.util.HashMap;

public class App 
{
    public static void main( String[] args )
    {
        // CSP - AustraliaColoringConstraint
        // Variables
        List<String> variables = List.of("Western Australia", "Northern Territory",
                "Queensland", "South Australia", "New South Wales", "Victoria", "Tasmania");

        // Domains
        Map<String, List<String>> domains = new HashMap<>();
        for(var variable: variables){
            domains.put(variable, List.of("red", "green", "blue"));
        }

        // Restrictions
        CSP<String, String> problem = new CSP<>(variables, domains);

        problem.addConstraint(new AustraliaColoringConstraint("Western Australia", "Northern Territory"));
        problem.addConstraint(new AustraliaColoringConstraint("Western Australia", "South Australia"));
        problem.addConstraint(new AustraliaColoringConstraint("Northern Territory", "South Australia"));
        problem.addConstraint(new AustraliaColoringConstraint("Northern Territory", "Queensland"));
        problem.addConstraint(new AustraliaColoringConstraint("South Australia", "Queensland"));
        problem.addConstraint(new AustraliaColoringConstraint("New South Wales", "Queensland"));
        problem.addConstraint(new AustraliaColoringConstraint("New South Wales", "South Australia"));
        problem.addConstraint(new AustraliaColoringConstraint("Victoria", "South Australia"));
        problem.addConstraint(new AustraliaColoringConstraint("New South Wales", "Victoria"));
        problem.addConstraint(new AustraliaColoringConstraint("Tasmania", "Victoria"));

        System.out.println("Australia coloring CSP\n");
        var solution = problem.backtrack();
        System.out.println(solution + "\n");

        // CSP - ComplexConstraint
        // Variables
        List<String> complexVariables = List.of("A", "B", "C", "D", "E", "F", "G", "H", "I", "J",
                "K", "L", "M", "N", "O", "P", "Q", "R", "S", "T", "U", "V", "W", "X", "Y", "Z", "AA");

        // Domains
        Map<String, List<String>> complexDomains = new HashMap<>();
        for(var variable: complexVariables){
            complexDomains.put(variable, List.of("C", "M", "Y", "K"));
        }


        // Restrictions
        CSP<String, String> complexProblem = new CSP<>(complexVariables, complexDomains);

        complexProblem.addConstraint(new ComplexConstraint("A", "B"));
        complexProblem.addConstraint(new ComplexConstraint("A", "V"));
        complexProblem.addConstraint(new ComplexConstraint("B", "V"));
        complexProblem.addConstraint(new ComplexConstraint("C", "D"));
        complexProblem.addConstraint(new ComplexConstraint("C", "F"));
        complexProblem.addConstraint(new ComplexConstraint("C", "H"));
        complexProblem.addConstraint(new ComplexConstraint("D", "G"));
        complexProblem.addConstraint(new ComplexConstraint("D", "H"));
        complexProblem.addConstraint(new ComplexConstraint("E", "I"));
        complexProblem.addConstraint(new ComplexConstraint("F", "K"));
        complexProblem.addConstraint(new ComplexConstraint("G", "K"));
        complexProblem.addConstraint(new ComplexConstraint("H", "V"));
        complexProblem.addConstraint(new ComplexConstraint("H", "M"));
        complexProblem.addConstraint(new ComplexConstraint("I", "M"));
        complexProblem.addConstraint(new ComplexConstraint("J", "N"));
        complexProblem.addConstraint(new ComplexConstraint("J", "K"));
        complexProblem.addConstraint(new ComplexConstraint("K", "O"));
        complexProblem.addConstraint(new ComplexConstraint("L", "P"));
        complexProblem.addConstraint(new ComplexConstraint("L", "Q"));
        complexProblem.addConstraint(new ComplexConstraint("M", "Q"));
        complexProblem.addConstraint(new ComplexConstraint("P", "S"));
        complexProblem.addConstraint(new ComplexConstraint("P", "T"));
        complexProblem.addConstraint(new ComplexConstraint("P", "U"));
        complexProblem.addConstraint(new ComplexConstraint("R", "W"));
        complexProblem.addConstraint(new ComplexConstraint("R", "X"));
        complexProblem.addConstraint(new ComplexConstraint("R", "S"));
        complexProblem.addConstraint(new ComplexConstraint("S", "X"));
        complexProblem.addConstraint(new ComplexConstraint("S", "Y"));
        complexProblem.addConstraint(new ComplexConstraint("S", "Z"));
        complexProblem.addConstraint(new ComplexConstraint("T", "Z"));
        complexProblem.addConstraint(new ComplexConstraint("T", "AA"));
        complexProblem.addConstraint(new ComplexConstraint("T", "U"));
        complexProblem.addConstraint(new ComplexConstraint("U", "AA"));
        complexProblem.addConstraint(new ComplexConstraint("V", "W"));
        complexProblem.addConstraint(new ComplexConstraint("W", "X"));
        complexProblem.addConstraint(new ComplexConstraint("X", "Y"));
        complexProblem.addConstraint(new ComplexConstraint("Y", "Z"));
        complexProblem.addConstraint(new ComplexConstraint("Z", "AA"));

        System.out.println("Complex CSP\n");
        var complexSolution = complexProblem.backtrack();
        System.out.println(complexSolution);

    }
}
