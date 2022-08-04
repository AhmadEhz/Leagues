package HW7;

import HW7.entity.*;
import HW7.entity.football.FootballClub;
import HW7.entity.volleyball.VolleyballClub;

import java.text.ParsePosition;
import java.text.SimpleDateFormat;

public class Main {
    static Print print = new Print();
    static Input input = new Input();
    static Utility utility = new Utility();
    static boolean exit = false;

    static ClubList clubList = new ClubList();
    static String league;

    public static void main(String[] args) {
        print.welcome();
        /*
        Club fb1 = new FootballClub("fb1");
        Club fb2 = new FootballClub("fb2");
        Club vb1 = new VolleyballClub("vb1");
        Club vb2 = new VolleyballClub("vb2");
        clubList.add(fb1);
        clubList.add(fb2);
        clubList.add(vb1);
        clubList.add(vb2);
        fb1.setMatch(fb2, 3, 4);
        vb1.setMatch(vb2, 3, 1);
        System.out.println(clubList.get(0));
        System.out.println(clubList.get(1));
        System.out.println(clubList.get(2));
        System.out.println(clubList.get(3));*/
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
                case "0" -> exit = true;
                //need for loop and delete switch case
                default -> {
                    print.invalidEntry();
                }
            }
        }
        exit = false;
    }

    private static void setMatchMenu() {
        Club club = new FootballClub();
        Club opponentClub = new FootballClub();
        String result = "30-2";
        if (utility.addMatch(club, opponentClub, result))
            print.added();
        else print.invalidEntry();
        System.out.println(club);
        System.out.println(opponentClub);
    }

    static boolean isLegalDate(String s) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        sdf.setLenient(false);
        return sdf.parse(s, new ParsePosition(0)) != null;
    }
}