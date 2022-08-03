package HW7;

import HW7.entity.*;
import HW7.entity.football.FootballClub;
import HW7.entity.football.FootballMatch;

import java.text.ParsePosition;
import java.text.SimpleDateFormat;

public class Main {
    static Print print = new Print();
    static Input input = new Input();
    static Utility utility = new Utility();
    static boolean exit = false;
    Match match;
    static String league;

    public static void main(String[] args) {
        print.welcome();
        mainMenu();
    }

    private static void mainMenu() {
        print.mainMenu();
        switch (input.scanner()) {
            case "1" -> {
            }
            case "2" -> setLeague();
            case "0" -> {
            }
        }
    }

    private static void setLeague() {
        while (!exit) {
            print.setLeagueMenu();
            switch (input.scanner()) {
                case "1" -> league = String.valueOf(LeagueName.FOOTBALL);
                case "2" -> league = String.valueOf(LeagueName.VOLLEYBALL);
                case "0" -> exit = true;
                default -> {
                    print.invalidEntry();
                }
            }
        }
        exit = false;
    }

    private static void setMatchMenu() {
        Club firstClub = new FootballClub();
        Club secondClub = new FootballClub();
        String result = "30-2";
        FootballMatch match = new FootballMatch((FootballClub) firstClub, (FootballClub) secondClub);
        if (match.checkMatch(utility.setResult(result)))
            match.setMatch(utility.setResult(result));
        print.added();
        System.out.println(firstClub);
        System.out.println(secondClub);
    }

    static boolean isLegalDate(String s) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        sdf.setLenient(false);
        return sdf.parse(s, new ParsePosition(0)) != null;
    }
}