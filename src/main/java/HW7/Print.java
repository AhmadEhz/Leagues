package HW7;

public class Print {
    public void welcome () {
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
}
