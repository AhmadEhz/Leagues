package HW7.util;

import HW7.entity.Club;
import HW7.entity.LeagueName;

import static HW7.util.Menu.clubList;
import static HW7.util.Menu.utility;

public class Print {
    public void welcome() {
        System.out.println("Welcome!");
        utility.delay(1);
    }

    public void mainMenu() {
        System.out.println("1- Show league table");
        System.out.println("2- Add a match");
        System.out.println("3- Show club");
        System.out.println("4- Add club");
        System.out.println("5- Remove club");
        System.out.println("0- Exit");
        enterNumber();
    }
    public void enterNumber() {
        System.out.println("Enter number:");
    }

    public void added() {
        System.out.println("Added!");
        utility.delay(2);
    }


    public void invalidEntry() {
        System.out.println("Invalid Entry!");
        utility.delay(1);
    }

    public void enterNameClub() {
        System.out.println("Enter the name of club (0 to exit) :");
    }

    public void enterMatch() {
        System.out.println("Enter the match (format: FirstTeam 0-0 SecondTeam) (0 to exit) :");
    }

    public void leagueNames() {
        String[] leagues = new Utility().getLeagueNames();
        System.out.println("leagues:");
        for (int i = 0; i < leagues.length; i++) {
            System.out.println(i + 1 + "- " + leagues[i].toLowerCase());
        }
        System.out.println("0- Exit");
        selectLeague();
    }

    private void selectLeague() {
        System.out.println("Select league:");
    }

    public void leagueTeams(LeagueName league) {
        Club[] clubs = clubList.getLeague(league);
        if (clubs == null)
            noTeam();
        else {
            for (int i = 0; i < clubs.length && clubs[i] != null; i++)
                System.out.println((i+1)+ "- "+clubs[i]);
        }
    }

    private void noTeam() {
        System.out.println("There is no team!");
    }

    public void clubNotExist() {
        System.out.println("Club not exist!");
        utility.delay(2);
    }

    public void pointInvalid() {
        System.out.println("Invalid points entered");
        utility.delay(2);
    }

    public void clubExist() {
        System.out.println("This club is exist!");
        utility.delay(2);
    }

    public void enterClub() {
        System.out.println("Enter club name (0 to exit) :");
    }

    public void club(Club club) {
        System.out.println(club);
    }

    public void enterToExit() {
        System.out.print("Press enter to exit:");
    }

    public void removed() {
        System.out.println("Removed!");
        utility.delay(2);
    }
}
