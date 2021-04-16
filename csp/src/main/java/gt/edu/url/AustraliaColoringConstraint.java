package gt.edu.url;

import java.util.Map;
import java.util.List;

public class AustraliaColoringConstraint  extends Constraint<String, String> {

    private String place1, place2;

    public AustraliaColoringConstraint(String place1, String place2){
        super(List.of(place1, place2));
        this.place1 = place1;
        this.place2 = place2;
    }

    @Override
    public boolean satisfied(Map<String, String> assignment){
        // Check
        // If variable has not been assigned
        if(!assignment.containsKey(place1) || !assignment.containsKey(place2)){
            return true;
        }

        // place1 <> place2
        return !assignment.get(place1).equals(assignment.get(place2));
    }
}

