package HW7;

import java.util.Scanner;

import static HW7.Main.input;
import static HW7.Main.utility;

public class Input {
    static Scanner scanner = new Scanner(System.in);

    public String scanner() {
        return scanner.nextLine();
    }

    public boolean hasInt(String input) {
        if (input.equals(""))
            return false;
        for (int i = 0; i < input.length(); i++) {
            if (!Character.isDigit(input.charAt(i))) {
                return false;
            }
        }
        if (Integer.parseInt(input) < 0)
            return false;
        return true;
    }

    public boolean checkMatch(String[] inputMatch) {
        if (inputMatch.length != 4)
            return false;
        if (!input.isDigit(inputMatch[1]) || !input.isDigit(inputMatch[2]))
            return false;
        else return true;

    }
    public boolean isDigit(String input) {
        for (int i = 0; i < input.length(); i++)
            if (!Character.isDigit(input.charAt(i)))
                return false;

        return true;
    }
}
