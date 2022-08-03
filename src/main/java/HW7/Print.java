package HW7;

public class Print {
    public void welcome () {
        System.out.println("Welcome!");
    }

    public void mainMenu() {
        System.out.println("1- Show league table");
        System.out.println("2- Add a match");
        System.out.println("0- Exit");
    }

    public void added() {
        System.out.println("Added!");
    }

    public void setLeagueMenu() {
        System.out.println("""
                1- Volleyball
                2- Football
                select league:""");
    }

    public void invalidEntry() {
        System.out.println("Invalid Entry!");
    }
}
