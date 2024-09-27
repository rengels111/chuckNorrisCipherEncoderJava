package chucknorris;

import java.util.List;
import java.util.Scanner;

public class Controller {

    String firstMessage = "Please input operation (encode/decode/exit):";

    public void doOperations() {

        Scanner sc = new Scanner(System.in);

        Converter converter = new Converter();

        boolean on = true;

        while (on) {

            System.out.println(firstMessage);
            String input = sc.nextLine();

            switch (input) {
                case "encode":
                    System.out.println("Input string:");
                    String in = sc.nextLine();
                    String binary = converter.convertStringToBinary(in);
                    String encoded = converter.convertBinaryToZeros(binary);
                    System.out.printf("Encoded string:\n%s\n\n", encoded);
                    break;
                case "decode":
                    System.out.println("Input encoded string:");
                    String in2 = sc.nextLine();
                    boolean validEncodedInput = converter.isValidEncodedInput(in2);
                    if (validEncodedInput) {
                        String binary2 = converter.convertFromZerosToBinary(in2);
                        List<Character> decoded = converter.convertFromBinaryToCharacters(binary2);
                        System.out.println("Decoded string:");
                        decoded.forEach(System.out::print);
                        System.out.println();
                        System.out.println();
                        break;
                    } else {
                        System.out.println("Encoded string is not valid.");
                        System.out.println();
                        break;
                    }
                case "exit":
                    System.out.println("Bye!");
                    on = false;
                    sc.close();
                    break;
                default:
                    System.out.printf("There is no '%s' operation\n\n", input);
                    break;
            }
        }



    }

}
