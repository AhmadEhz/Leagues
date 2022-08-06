package HW7.util;

import HW7.entity.*;

public class Menu {
    static ClubList clubList = new ClubList();
    static Print print = new Print();
    static Input input = new Input();
    static Utility utility = new Utility();
    static boolean exit = false;

    public void mainMenu() {
        print.welcome();
        LeagueName league;
        while (!exit) {
            print.mainMenu();
            switch (input.scanner()) {
                case "1" -> { // Show selected league teams
                    league = setLeague();
                    if (league != null) // If league is null, it means that the user entered 0 to exit
                        showLeaguesMenu(league);
                }
                case "2" -> { // Add a match to selected league
                    league = setLeague();
                    if (league != null)
                        addMatchMenu(league);
                }
                case "3" -> {
                    league = setLeague();
                    if (league != null)
                        showClubMenu(league);
                }
                case "4" -> { //Add a club to selected league
                    league = setLeague();
                    if (league != null)
                        addClubMenu(league);
                }
                case "5" -> {
                    league = setLeague();
                    if (league != null)
                        removeClubMenu(league);
                }
                case "0" -> exit = true;
                default -> print.invalidEntry();
            }
        }
    }
    private LeagueName setLeague() {
        String inputId;
        int leagueId;
        while (true) {
            print.leagueNames();
            inputId = input.scanner();
            if (inputId.equals("0"))
                return null;
            if (!input.hasInt(inputId))
                print.invalidEntry();
            else {
                leagueId = Integer.parseInt(inputId) - 1;
                if (leagueId >= utility.getLeagueNumber())
                    print.invalidEntry();
                else
                    return utility.getLeague(leagueId);
            }
        }
    }

    private void showClubMenu(LeagueName league) {
        while (!exit) {
            print.enterClub();
            String inputName = input.scanner();
            if (inputName.equals("0"))
                exit = true;
            else {
                Club club = clubList.get(SetClub.setClub(inputName, league));
                if (club == null)
                    print.clubNotExist();
                else print.club(club);
            }
        }
        exit = false;
    }

    private void showLeaguesMenu(LeagueName league) {
        print.leagueTeams(league);
        print.enterToExit();
        input.scanner();
    }

    private void addMatchMenu(LeagueName league) {
        while (!exit) {
            print.enterMatch();
            String[] inputMatch = input.scanner().split("( )|(-)");
            if (inputMatch.length == 1 && inputMatch[0].equals("0"))
                return;
            if (input.checkMatch(inputMatch)) {
                Club club = clubList.get(SetClub.setClub(inputMatch[0], league));
                Club opponentClub = clubList.get(SetClub.setClub(inputMatch[3], league));
                if (club != null && opponentClub != null)//checks both club exist in clubList
                    if (clubList.setMatch(club, opponentClub, Integer.parseInt(inputMatch[1]), Integer.parseInt(inputMatch[2]))) {
                        print.added();
                        return;
                    } else print.pointInvalid();
                else print.clubNotExist();
            } else print.invalidEntry();
        }
    }

    private void addClubMenu(LeagueName league) {
        while (!exit) {
            String inputName;
            print.enterNameClub();
            Club club = SetClub.setClub(league);
            inputName = input.scanner();
            if (inputName.equals("0"))
                return;
            if (input.checkTeamName(inputName)) {
                club.setName(inputName);
                if (clubList.add(club)) {
                    print.added();
                    return;
                } else print.clubExist();
            } else print.invalidEntry();
        }
    }

    private void removeClubMenu(LeagueName league) {
        while (!exit) {
            String inputName;
            print.enterNameClub();
            Club club = SetClub.setClub(league);
            inputName = input.scanner();
            if (inputName.equals("0"))
                return;
            if (input.checkTeamName(inputName)) {
                club.setName(inputName);
                if (clubList.remove(club)) {
                    print.removed();
                    return;
                } else print.clubNotExist();
            } else print.invalidEntry();
        }
    }
}