package HW7;

import HW7.entity.*;

import java.text.ParsePosition;
import java.text.SimpleDateFormat;

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
        LeagueName league;
        while (!exit) {
            print.mainMenu();
            switch (input.scanner()) {
                case "1" -> { // Show selected league teams
                    league = setLeague();
                    if (league == null)
                        exit = true;
                    showLeaguesMenu(league);
                }
                case "2" -> { // Add a match to selected league
                    league = setLeague();
                    if (league == null)
                        exit = true;
                    setMatchMenu(league);
                }
                case "3" -> {
                }
                case "4" -> { //Add a club to selected league
                    league = setLeague();
                    if (league == null)
                        exit = true;
                    createClubMenu(league);
                }
                case "0" -> exit = true;
                default -> print.invalidEntry();
            }
        }
    }

    private static void showLeaguesMenu(LeagueName league) {
        print.leagueTeams(league);
    }

    private static LeagueName setLeague() {
        String inputId = null;
        int leagueId = 0;
        while (true) {
            print.leagueNames();
            inputId = input.scanner();
            if (!input.hasInt(inputId))
                print.invalidEntry();
            if (inputId.equals("0"))
                return null;
            else leagueId = Integer.parseInt(inputId) - 1;
            if (leagueId >= utility.getLeagueNumber())
                print.invalidEntry();
            else {
                return utility.getLeague(leagueId);
            }
        }
    }

    private static void setMatchMenu(LeagueName league) {
        print.enterMatch();
        String[] inputMatch = input.scanner().split("( )|(-)");
        if (input.checkMatch(inputMatch)) {
            Club club = clubList.get(SetClub.createClub(inputMatch[0], league));
            Club opponentClub = clubList.get(SetClub.createClub(inputMatch[3], league));
            if (club != null && opponentClub != null)//checks both club exist in clubList
                if (clubList.setMatch(club, opponentClub, Integer.parseInt(inputMatch[1]), Integer.parseInt(inputMatch[2])))
                    print.added();
                else print.pointInvalid();
            else print.clubNotExist();
        } else print.invalidEntry();
    }

    /*private static boolean addMatch(String [] match, int leagueId) {
        LeagueName leagueName = LeagueName.valueOf(league);

        Club club = clubList.get(SetClub.createClub(matchArray[0], leagueName));
        Club opponentClub = clubList.get(SetClub.createClub(matchArray[4], leagueName));
        if (club != null && opponentClub != null)
            if (club.setMatch(opponentClub, Integer.parseInt(matchArray[1]), Integer.parseInt(matchArray[3])))
                return true;
        return false;
    }*/

    private static void createClubMenu(LeagueName league) {//Club is imported from ClubList
        print.enterNameClub();
        Club club = SetClub.setClub(league);
        club.setName(input.scanner());
        if (clubList.add(club))
            print.added();
        else print.clubExist();
    }

    static boolean isLegalDate(String s) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        sdf.setLenient(false);
        return sdf.parse(s, new ParsePosition(0)) != null;
    }

}