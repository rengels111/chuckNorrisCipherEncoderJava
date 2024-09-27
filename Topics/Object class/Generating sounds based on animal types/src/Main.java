// Java code template starts here
import java.util.*;

public class Main {

    // Define Animal class here
    class Animal {

    }

    // Define Dog class here
    class Dog extends Animal {

    }

    // Define Cat class here
    class Cat extends Animal {

    }

    public static void main(String[] args) {

        // In this section, you need to add code to receive input
        // and create the corresponding animal object

        Scanner sc = new Scanner(System.in);

        String input1 = sc.nextLine();
        String input2 = sc.nextLine();

        // Replace the placeholders with the appropriate calls
        if(input1.equals("Dog")) {
            System.out.println("Bark!");
        } else if(input1.equals("Cat")) {
            System.out.println("Meow!");
        } else {
            System.out.println("Animal type not recognized");
        }
    }
}

// Java code template ends here