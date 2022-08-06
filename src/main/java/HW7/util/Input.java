package HW7.util;

import java.util.Scanner;

import static HW7.util.Menu.input;

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
        return Integer.parseInt(input) >= 0;
    }

    public boolean checkMatch(String[] inputMatch) {
        if (inputMatch.length != 4)
            return false;
        return input.isDigit(inputMatch[1]) && input.isDigit(inputMatch[2]);

    }

    public boolean isDigit(String input) {
        for (int i = 0; i < input.length(); i++)
            if (!Character.isDigit(input.charAt(i)))
                return false;

        return true;
    }

    public boolean checkTeamName(String name) {
        return name.length() >= 4;
    }
}
