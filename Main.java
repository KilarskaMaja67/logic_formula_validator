import java.util.Scanner;


public class Main {
    public static void main(String[] args) {

        Scanner scr=new Scanner(System.in);
        String formula=scr.nextLine();
        System.out.println(is_correct(formula));

    }

    public static boolean is_correct(String formula)
    {
        //removing spaces
        String current = formula.replaceAll("\\s+", "");

        //checking if any incorrect symbols are used
        if (!current.matches("[a-z0-1()!&|>=]+")) {
            return false;
        }
        
        //swapping out all a-z and 0-1 with X
        current=current.replaceAll("[a-z0-1]", "X");
        String previous;
        do {
            previous = current;
            current = current.replace("!X", "X");
            current = current.replace("(X)", "X");
            current = current.replace("X&X", "X");
            current = current.replace("X|X", "X");
            current = current.replace("X>X", "X");
            current = current.replace("X=X", "X");

        } while (current.length() < previous.length()); //while there are still formulas to reduce

        return current.equals("X");//if the end result is "X" then the expression is correct

    }
}