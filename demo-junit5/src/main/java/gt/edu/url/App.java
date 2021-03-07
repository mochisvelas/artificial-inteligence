package gt.edu.url;

public class App 
{
    public static void main( String[] args )
    {
        var calculator = new Calculator();
        var result = calculator.sum(5, 5);
        System.out.println(result);
    }
}
