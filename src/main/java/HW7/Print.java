package HW7;

import HW7.entity.Club;
import HW7.entity.LeagueName;

import static HW7.Main.clubList;

public class Print {
    public void welcome() {
        System.out.println("Welcome!");
    }

    public void mainMenu() {
        System.out.println("1- Show league table");
        System.out.println("2- Add a match");
        System.out.println("3- Show club");
        System.out.println("4- Add club");
        System.out.println("0- Exit");
    }

    public void added() {
        System.out.println("Added!");
    }

    public void setLeagueMenu() {
        System.out.println("""
                1- Football
                2- Volleyball
                0- exit
                select league:""");
    }

    public void invalidEntry() {
        System.out.println("Invalid Entry!");
    }

    public void enterNameClub() {
        System.out.println("Enter the name of club:");
    }

    public void enterMatch() {
        System.out.println("Enter the match (format: FirstTeam 0-0 SecondTeam)");
    }

    public void leagueNames() {
        String[] leagues = new Utility().getLeagueNames();
        for (int i = 0; i < leagues.length; i++) {
            System.out.println(i + 1 + "- " + leagues[i].toLowerCase());
        }
        System.out.println("0- Exit");
    }

    public void leagueTeams(LeagueName league) {
        Club[] clubs = clubList.getLeague(league);
        if (clubs == null)
            noTeam();
        else {
            for (int i = 0; i < clubs.length && clubs[i] != null; i++)
                System.out.println(clubs[i]);
        }
    }

    private void noTeam() {
        System.out.println("There is no team!");
    }

    public void clubNotExist() {
        System.out.println("Club not exist!");
    }

    public void pointInvalid() {
        System.out.println("Invalid points of entered");
    }

    public void clubExist() {
        System.out.println("This club is exist!");
    }
}
