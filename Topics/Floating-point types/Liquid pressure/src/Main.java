import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        // put your code here

        // Locale.setDefault(Locale.US);

        double density = scanner.nextDouble();
        double height = scanner.nextDouble();
        final double gravity = 9.8;

        double liquidPressure = density * gravity * height;

        System.out.printf("%.3f", liquidPressure);

    }
}