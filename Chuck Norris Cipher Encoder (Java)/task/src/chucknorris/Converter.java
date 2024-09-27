package chucknorris;

import java.util.ArrayList;
import java.util.List;

public class Converter {

    public String convertStringToBinary(String str) {

        char[] array = str.toCharArray();

        StringBuilder sb = new StringBuilder();

        for (char c : array) {
            String binaryString = Integer.toBinaryString(c);
            // Sicherstellen, dass die Binärzahl 7 Stellen hat:
            String formattedBinaryString = String.format("%7s", binaryString).replace(' ', '0');
            sb.append(formattedBinaryString);
        }

        return sb.toString();
    }

    public String convertBinaryToZeros(String str) {

        char currentChar = str.charAt(0);

        int count = 1;

        StringBuilder sb = new StringBuilder();

        for (int i = 1; i < str.length(); i++) {
            if (str.charAt(i) == currentChar) {
                count++;
            } else {
                if (currentChar == '0') {
                    sb.append("00 ");
                } else {
                    sb.append("0 ");
                }
                sb.append("0".repeat(Math.max(0, count)));
                sb.append(" ");
                currentChar = str.charAt(i);
                count = 1;

            }
        }

        // Last group
        if (currentChar == '0') {
            sb.append("00 ");
        } else {
            sb.append("0 ");
        }
        sb.append("0".repeat(Math.max(0, count)));

        return sb.toString();
    }

    public String convertFromZerosToBinary(String str) {

        // Split pattern into groups
        String[] groups = str.split(" ");
        StringBuilder binaryString = new StringBuilder();

        for (int i = 0; i < groups.length; i+=2) {
            // First group defines if char is 1 or 0
            String flagGroup = groups[i];
            String countGroup = groups[i + 1];

            // Define if 1 or 0
            char digit = flagGroup.equals("0") ? '1' : '0';

            // Insert number of digits into String
            binaryString.append(String.valueOf(digit).repeat(countGroup.length()));
        }
        return binaryString.toString();
    }

    public List<Character> convertFromBinaryToCharacters(String binaryString) {

        ArrayList<String> binaryGroups = new ArrayList<>();

        int length = binaryString.length();

        for (int i = 0; i < length; i += 7) {
            String group = binaryString.substring(i, Math.min(i + 7, length));
            binaryGroups.add(group);
        }

        List<Character> charList = binaryGroups.stream()
                .map(group -> Integer.parseInt(group, 2))
                .map(i -> (char) i.intValue())
                .toList();

        return charList;
    }

    public boolean isValidEncodedInput(String input) {

        // Schritt 1: Prüfen, ob die Eingabe nur aus Nullen besteht.
        if (!input.matches("[0 ]+")) {
            return false;
        }

        // Schritt 2: Die Eingabe in Blöcke aufteilen
        String[] blocks = input.split(" ");

        // Schritt 3: Überprüfen, ob die Anzahl der Blöcke gerade ist
        if (blocks.length % 2 != 0) {
            return false;
        }

        StringBuilder binaryString = new StringBuilder();

        for (int i = 0; i < blocks.length; i += 2) {
            String firstBlock = blocks[i];
            String secondBlock = blocks[i + 1];

            // Schritt 4: Überprüfen, ob der erste Block entweder "0" oder "00" ist
            if (!firstBlock.equals("0") && !firstBlock.equals("00")) {
                return false;
            }

            // Schritt 5: Den zweiten Block als Gruppe von '1' oder '0' interpretieren
            char bit = firstBlock.equals("0") ? '1' : '0';
            binaryString.append(String.valueOf(bit).repeat(secondBlock.length()));
        }

        // Schritt 6: Überprüfen, ob die Länge der dekodierten binären Zahlen ein Vielfaches von 7 ist
        if (binaryString.length() % 7 != 0) {
            return false;
        }

        // Wenn alle Prüfungen bestanden wurden, ist die Eingabe gültig
        return true;
    }

}
