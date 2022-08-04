package HW7;

import HW7.entity.*;
import HW7.entity.football.FootballClub;
import HW7.entity.volleyball.VolleyballClub;

import java.text.ParsePosition;
import java.text.SimpleDateFormat;
import java.util.EnumMap;
import java.util.Objects;

public class Main {
    static Print print = new Print();
    static Input input = new Input();
    static Utility utility = new Utility();
    static boolean exit = false;

    static ClubList clubList = new ClubList();
    static String league;
    static SetClub setClub;

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
        while (!exit) {
            print.mainMenu();
            switch (input.scanner()) {
                case "1" -> {
                    for (int i = 0; i < clubList.getLeague(LeagueName.FOOTBALL).length; i++) {
                        System.out.println(clubList.getLeague(LeagueName.FOOTBALL)[i]);
                    }
                }
                case "2" -> setLeague();
                case "4" -> addClubMenu();
                case "0" -> exit = true;
            }
        }
        exit = false;
    }

    private static void setLeague() {
        while (!exit) {
            print.setLeagueMenu();
            switch (input.scanner()) {
                case "1" -> setMatchMenu("FOOTBALL");
                case "2" -> setMatchMenu("VOLLEYBALL");
                case "0" -> exit = true;
                //need for loop and delete switch case
                default -> {
                    print.invalidEntry();
                }
            }
        }
        exit = false;
    }

    private static void setMatchMenu(String league) {
        print.enterMatch();
        if (addMatch(input.scanner(), league))
            print.added();
        else print.invalidEntry();
        /*Club club = new FootballClub();
        Club opponentClub = new FootballClub();
        String result = "30-2";
        if (utility.addMatch(club, opponentClub, result))
            print.added();
        else print.invalidEntry();*/
    }

    private static boolean addMatch(String match, String league) {
        LeagueName leagueName = LeagueName.valueOf(league);
        String[] matchArray = match.split(" ");

        Club club = clubList.get(SetClub.setClub(matchArray[0], leagueName));
        Club opponentClub = clubList.get(SetClub.setClub(matchArray[4], leagueName));
        if (club != null && opponentClub != null)
            if (club.setMatch(opponentClub, Integer.parseInt(matchArray[1]), Integer.parseInt(matchArray[3])))
                return true;
        return false;
    }

    private static void addClubMenu() {
        while (!exit) {
            print.setLeagueMenu();
            String input1 = input.scanner();
            if (input1.equals("1")) {
                createClubMenu(SetClub.setClub(LeagueName.FOOTBALL));
                print.added();
            } else if (input1.equals("2")) {
                createClubMenu(SetClub.setClub(LeagueName.VOLLEYBALL));
                print.added();
            } else if (input1.equals("0"))
                exit = true;
        }
        exit = false;
    }

    private static void createClubMenu(Club club) {
        Club newClub = club;
        print.enterNameClub();
        club.setName(input.scanner());
        newClub.setClub(club);
        clubList.add(newClub);
    }

    static boolean isLegalDate(String s) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        sdf.setLenient(false);
        return sdf.parse(s, new ParsePosition(0)) != null;
    }
}