import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        // put your code here
        Scanner sc = new Scanner(System.in);

        double x = sc.nextDouble();

        double result = Math.pow(x, 3) + Math.pow(x, 2) + x + 1;

        System.out.println(result);
    }
}