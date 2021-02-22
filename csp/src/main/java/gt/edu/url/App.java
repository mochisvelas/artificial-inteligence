package gt.edu.url;

import java.util.List;
import java.util.Map;
import java.util.HashMap;

public class App 
{
    public static void main( String[] args )
    {
        // CSP
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

        // System.out.println(problem.ArcsQ);

        var solution = problem.backtrack();
        System.out.println(solution);

    }
}
